/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.Controllers;

import com.example.tecnisuelos1.entity.PruebaCampo;
import com.example.tecnisuelos1.services.PruebaCampoService;
import com.example.tecnisuelos1.services.excelReports.PruebaCampoExcelExporter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class PruebaCampoController {
    @Autowired
    private PruebaCampoService pruebaCampoInterface;

    // Listar todas las pruebas
    @GetMapping("/pruebaCampoView")
    public String getPruebaCampo(Model model) {
        List<PruebaCampo> pruebas = pruebaCampoInterface.getAllPruebas();
        model.addAttribute("pruebas", pruebas);
        return "pruebaCampoCrud/pruebaCampoView";
    }

    // Vista prueba de campo
    @GetMapping("/pruebaCampoAddView")
    public String pruebaCampoAddView() {
        return "pruebaCampoCrud/pruebaCampoAddView";
    }

    // Procesar el formulario de creación de prueba
    @PostMapping("/pruebaCampoAdd")
    public String pruebaCampoAdd(@ModelAttribute PruebaCampo prueba) {
        pruebaCampoInterface.createPrueba(prueba);
        return "redirect:/pruebaCampoView";
    }

    // Vista edición de prueba de campo
    @GetMapping("/pruebaCampoUpdateView/{id}")
    public String pruebaCampoUpdateView(@PathVariable Long id, Model model) {
        PruebaCampo prueba = pruebaCampoInterface.getPruebaById(id);
        if (prueba == null) {
            return "redirect:/pruebaCampoView";
        }
        model.addAttribute("prueba", prueba);
        return "pruebaCampoCrud/pruebaCampoUpdateView";
    }

    // Procesar el formulario de creación de prueba
    @PostMapping("/pruebaCampoUpdate")
    public String pruebaCampoUpdate(@ModelAttribute PruebaCampo prueba) {
        pruebaCampoInterface.updatePrueba(prueba);
        return "redirect:/pruebaCampoView";
    }

    // Eliminar una prueba
    @GetMapping("/pruebaCampoDelete/{id}")
    public String delete(@PathVariable Long id) {
        pruebaCampoInterface.deletePrueba(id);
        return "redirect:/pruebaCampoView";
    }

     @GetMapping("/pruebaCampo/export/excel")
     public void exportToExcel(HttpServletResponse response) throws IOException {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=pruebaCampo_"+ currentDateTime +".xlsx";
            response.setHeader(headerKey, headerValue);
            List<PruebaCampo> pruebaCampoList = pruebaCampoInterface.getAllPruebas();
            PruebaCampoExcelExporter excelExporter = new PruebaCampoExcelExporter(pruebaCampoList);
            excelExporter.export(response);
     }
}
