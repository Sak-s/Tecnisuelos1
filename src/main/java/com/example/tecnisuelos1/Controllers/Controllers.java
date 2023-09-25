/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author santiago
 */
@Controller
@RequestMapping
public class Controllers {
    @GetMapping("/index")
    public String vistaIndex(Model model) {
        return "index";
    }

    @GetMapping("/Agendar")
    public String vistaAgendar(Model model) {
        return "agendar";
    }
    @GetMapping("/pruebasdeCampo")
    public String vistapruebadecampo(Model model) {
        return "pruebasdeCampo";
    }

    @GetMapping("/HistoInformes")
    public String vistaHistoInforme(Model model) {
        return "histoInformes";
    }

     @GetMapping("/servicios")
    public String vistaServicios(Model model) {
        return "servicios";
    }
     @GetMapping("/404act")
    public String vistaError(Model model) {
        return "404act";
    }
     @GetMapping("/500act")
    public String vistaError500(Model model) {
        return "500act";
    }
     @GetMapping("/inicio")
    public String vistaInicio(Model model) {
        return "inicio";
    }

     @GetMapping("/crearCuenta")
    public String vistaCrearCuenta(Model model) {
        return "crearCuenta";
    }
    @GetMapping("/RecupContra")
    public String vistaRecup(Model model) {
        return "RecupContra";
    }
   @GetMapping("/administrador")
    public String vistaAdmin(Model model) {
        return "administrador";
    }
    @GetMapping("/cronograma")
    public String cronogramaa(Model model) {
        return "cronograma";
    }
}
