/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.Controllers;


import com.example.tecnisuelos1.entity.Contador;
import com.example.tecnisuelos1.services.ContadorService;
import com.example.tecnisuelos1.services.excelReports.ContadorExcel;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping

public class ContadorController {
    
    @Autowired
        private ContadorService contadorInterface;
        private String plabraClave;


    @GetMapping("/crudContador")
    public String vistaCrudContador(@Param("palabraClave") String palabraClave, Model model) {
        this.plabraClave = palabraClave;
        List<Contador> listaCliente = contadorInterface.getCliente(palabraClave);
        model.addAttribute("monalisa", listaCliente);
        model.addAttribute("palabraClave", palabraClave);
        return "crudC/crudContador";
    }

    @GetMapping("/agregarCliente")
    public String vistaAgregar(Model model) {
        return "crudC/agregarCliente";

    }    
    
    @PostMapping("/guardarCliente")
    public String GuardarCliente(@ModelAttribute Contador contador, BindingResult resultado) {
        contadorInterface.crearCliente(contador);
        return "redirect:/crudContador";
    }


    @RequestMapping("/verEditar/{id}")
    public String verFormularioEdicion(@PathVariable Long id, Model modelo) {
        
        Contador clienteActual = contadorInterface.buscarById(id);
        if (clienteActual != null) {
           modelo.addAttribute("cliente", clienteActual);
        }
        return "crudC/editarCrud";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizaUsuario(@PathVariable  Long id, Contador contador,  BindingResult resultado, Model modelo ){
        
        contadorInterface.ActualizarCliente(contador);
        return "redirect:/crudContador";
        
    }

  
    @GetMapping("/eliminarCliente/{id}")
    public String eliminaUsuario(@PathVariable  Long id) {
        contadorInterface.borrarCliente(id);
        return "redirect:/crudContador";
    }

       @GetMapping("/contador/export/excel")
     public void exportToExcel(HttpServletResponse response) throws IOException {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date(0));
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=CarteraCliente_"+ currentDateTime +".xlsx";
            response.setHeader(headerKey, headerValue);
            List<Contador> contadorList = contadorInterface.getCliente(plabraClave);
            ContadorExcel excelExporter = new ContadorExcel(contadorList);
            excelExporter.export(response);
     }
    
    
    /*@GetMapping("/actualizar")
    public String updateCliente(@ModelAttribute Contador contador, BindingResult resultado) {
        contadorInterface.ActualizarCliente(contador);
        return "redirect:/crudContador";
    }*/

    

   
}
