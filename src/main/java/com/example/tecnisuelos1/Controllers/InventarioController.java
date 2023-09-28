/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.Controllers;



import com.example.tecnisuelos1.entity.Inventario;
import com.example.tecnisuelos1.services.InventarioService;
import com.example.tecnisuelos1.services.excelReports.InventarioExcel;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author santiago
 */
@Controller
@RequestMapping
public class InventarioController {
     @Autowired
        private InventarioService inventarioInterface;

     @GetMapping("/crudInventario")
    public String vistaCrudInventario(Model model) {
        List<Inventario> listaInventario = inventarioInterface.getInventario();
        model.addAttribute("listai", listaInventario);
        return "crudI/crudInventario";
    }

    @GetMapping("/agregarInventario")
    public String vistaAgregar(Model model) {
        return "crudI/agregarInventario";

    }    

     @PostMapping("/guardarInventario")
    public String GuardarInventario(@ModelAttribute Inventario invent, BindingResult resultado) {
        inventarioInterface.crearInven(invent);
        return "redirect:/crudInventario";
    }


    @RequestMapping("/editarInventario/{id}")
    public String verFormularioEdicionc(@PathVariable Long id, Model modelo) {
        
        Inventario inventarioActual = inventarioInterface.buscarByIde(id);
        if (inventarioActual != null) {
           modelo.addAttribute("inventario", inventarioActual);
        }
        return "crudI/editarInventario";
    }

    @PostMapping("/actualizarInventario/{id}")
    public String actualizarInven(@PathVariable  Long id, Inventario invent,  BindingResult resultado, Model modelo ){
        
        inventarioInterface.ActualizarInven(invent);
        return "redirect:/crudInventario";
        
    }

  
    @GetMapping("/eliminarInventario/{id}")
    public String eliminarInventario(@PathVariable  Long id) {
        inventarioInterface.borrarInven(id);
        return "redirect:/crudInventario";
    }

    @GetMapping("/inventario/export/excel")
     public void exportToExcel(HttpServletResponse response) throws IOException {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date(0));
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=InformeInventario_"+ currentDateTime +".xlsx";
            response.setHeader(headerKey, headerValue);
            List<Inventario> inventarioInfoList = inventarioInterface.getInventario();
            InventarioExcel excelExporter = new InventarioExcel(inventarioInfoList);
            excelExporter.export(response);
     }
}
