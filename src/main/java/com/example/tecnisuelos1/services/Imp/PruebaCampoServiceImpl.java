/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.services.Imp;

import com.example.tecnisuelos1.entity.PruebaCampo;
import com.example.tecnisuelos1.repository.PruebaCampoRepository;
import com.example.tecnisuelos1.services.PruebaCampoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santiago
 */
@Service
public class PruebaCampoServiceImpl implements PruebaCampoService {

    @Autowired
    private PruebaCampoRepository pruebaCampoRepository;

    @Override
    public List<PruebaCampo> getAllPruebas() {
        return pruebaCampoRepository.findAll();
    }

    @Override
    public PruebaCampo getPruebaById(Long id) {
        return pruebaCampoRepository.findById(id).get();
    }

    @Override
    public PruebaCampo createPrueba(PruebaCampo pruebaCampo) {
        return pruebaCampoRepository.save(pruebaCampo);
    }

    @Override
    public PruebaCampo updatePrueba(PruebaCampo pruebaCampo) {
        PruebaCampo pruebaCampoUpdate = pruebaCampoRepository.findById(pruebaCampo.getId()).get();
        pruebaCampoUpdate.setNombreEmpleado(pruebaCampo.getNombreEmpleado());
        pruebaCampoUpdate.setFecha(pruebaCampo.getFecha());
        pruebaCampoUpdate.setNumeroCilindro(pruebaCampo.getNumeroCilindro());
        pruebaCampoUpdate.setNumeroPrueba(pruebaCampo.getNumeroPrueba());
        pruebaCampoUpdate.setCliente(pruebaCampo.getCliente());
        pruebaCampoUpdate.setUbicacion(pruebaCampo.getUbicacion());
        pruebaCampoUpdate.setSondeo(pruebaCampo.getSondeo());
        pruebaCampoUpdate.setRevenimiento(pruebaCampo.getRevenimiento());
        pruebaCampoUpdate.setUltrasonico(pruebaCampo.getUltrasonico());
        pruebaCampoUpdate.setEsclerometria(pruebaCampo.getEsclerometria());
        pruebaCampoUpdate.setAnalisisPetrograficos(pruebaCampo.getAnalisisPetrograficos());
        pruebaCampoUpdate.setElaboracion(pruebaCampo.getElaboracion());
        pruebaCampoUpdate.setReactividad(pruebaCampo.getReactividad());
        pruebaCampoUpdate.setCompresion(pruebaCampo.getCompresion());

        PruebaCampo pruebaCampoUpdated = pruebaCampoRepository.save(pruebaCampoUpdate);
        return pruebaCampoUpdated;
    }

    @Override
    public void deletePrueba(Long id) {
        PruebaCampo pruebaCampo = pruebaCampoRepository.findById(id).get();
        if (pruebaCampo != null) {
            pruebaCampoRepository.deleteById(id);
        }
    }
}
