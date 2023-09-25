/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.Controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.tecnisuelos1.entity.Laboratorista;
import com.example.tecnisuelos1.services.LaboratoristaService;
import com.example.tecnisuelos1.services.excelReports.LaboratoristaExcel;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping

public class LaboratoristaController {
    @Autowired
    private LaboratoristaService laboInterface;

    @GetMapping("/crudLaboratorista")
    public String vistaCrudLaboratorista(Model model) {
        List<Laboratorista> listaInformes = laboInterface.getLabo();
        model.addAttribute("lista", listaInformes);
        return "crudL/crudLaboratorista";
    }

    @GetMapping("/agregarInforme")
    public String vistaAdd(Model model) {
        return "crudL/nuevoInforme";

    }

    @PostMapping("/guardarInforme")
    public String GuardarInforme(@ModelAttribute Laboratorista laboratorista, BindingResult resultado) {

        laboInterface.crearInforme(laboratorista);
        System.out.println("Informe Guardado con Exito. ");
        return "redirect:/crudLaboratorista";
    }

        @GetMapping("/eliminarInforme/{id}")
    public String eliminaUsuario(@PathVariable  Long id) {
       laboInterface.borrarInforme(id);
        return "redirect:/crudLaboratorista";
    }

    @GetMapping("/laboratorista/export/excel")
     public void exportToExcel(HttpServletResponse response) throws IOException {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date(0));
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=pruebaCampo_"+ currentDateTime +".xlsx";
            response.setHeader(headerKey, headerValue);
            List<Laboratorista> laboratoristaInfoList = laboInterface.getLabo();
            LaboratoristaExcel excelExporter = new LaboratoristaExcel(laboratoristaInfoList);
            excelExporter.export(response);
     }
    
}
