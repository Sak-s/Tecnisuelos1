/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.services.Imp;

import com.example.tecnisuelos1.entity.Laboratorista;
import com.example.tecnisuelos1.repository.LaboratoristaRepository;
import com.example.tecnisuelos1.services.LaboratoristaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santiago
 */
@Service
public class LaboratoristaServiceImpl implements LaboratoristaService {

    @Autowired
    private LaboratoristaRepository labotory;

    @Override
    public List<Laboratorista> getLabo(String palabraClave) {
        if (palabraClave !=null) {
            return labotory.findAll(palabraClave);
        }
        return labotory.findAll();
    }

    @Override
    public Laboratorista crearInforme(Laboratorista labo) {

        Laboratorista nuevoInforme = labotory.save(labo);
        return nuevoInforme;
    }

    @Override
    public void borrarInforme(Long idLaboratorista) {
        Laboratorista eliminarInforme = labotory.findById(idLaboratorista).get();
        if (eliminarInforme != null) {
            labotory.deleteById(idLaboratorista);
        }
    }

    @Override
    public Laboratorista buscarById(Long idLaboratorista) {
        Laboratorista informeExiste = labotory.findById(idLaboratorista).get();
        return informeExiste;
    }

    @Override
    public Laboratorista ActualizarInforme(Laboratorista labo) {
        Laboratorista editarInforme = labotory.findById(labo.getLaboratoristaId()).get();
        editarInforme.setNombreEmpleado(labo.getNombreEmpleado());
        editarInforme.setTipoPrueba(labo.getTipoPrueba());
        editarInforme.setFecha(labo.getFecha());
        editarInforme.setNumerocilindro(labo.getNumerocilindro());
        editarInforme.setNumeroPrueba(labo.getNumeroPrueba());
        editarInforme.setCliente(labo.getCliente());
        editarInforme.setGranulometria(labo.getGranulometria());
        editarInforme.setContenidoAire(labo.getContenidoAire());
        editarInforme.setFlexionCocreto(labo.getFlexionCocreto());
        editarInforme.setCompresion(labo.getCompresion());
        editarInforme.setEstudioPetrografico(labo.getEstudioPetrografico());
        editarInforme.setElasticidadExtensometro(labo.getElasticidadExtensometro());
        editarInforme.setContraccionSecado(labo.getContraccionSecado());
        editarInforme.setPruebasPermeabilidad(labo.getPruebasPermeabilidad());

        Laboratorista informeUpdate = labotory.save(editarInforme);
        return informeUpdate;
    }

}
