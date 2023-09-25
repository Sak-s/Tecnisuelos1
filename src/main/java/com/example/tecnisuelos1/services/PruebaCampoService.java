/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.services;

import com.example.tecnisuelos1.entity.PruebaCampo;
import java.util.List;

/**
 *
 * @author santiago
 */
public interface PruebaCampoService {

    public List<PruebaCampo> getAllPruebas();

    public PruebaCampo getPruebaById(Long id);

    public PruebaCampo createPrueba(PruebaCampo pruebaCampo);

    public PruebaCampo updatePrueba(PruebaCampo pruebaCampo);

    public void deletePrueba(Long id);
}
