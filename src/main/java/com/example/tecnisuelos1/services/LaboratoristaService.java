/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.services;

import com.example.tecnisuelos1.entity.Laboratorista;
import java.util.List;

/**
 *
 * @author santiago
 */
public interface LaboratoristaService {

    public List<Laboratorista> getLabo();

    public Laboratorista crearInforme(Laboratorista labo);

    public void borrarInforme(Long idLaboratorista);

    public Laboratorista buscarById(Long idLaboratorista);

    public Laboratorista ActualizarInforme(Laboratorista labo);
}
