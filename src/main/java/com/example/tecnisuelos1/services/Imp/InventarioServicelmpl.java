/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.services.Imp;

import com.example.tecnisuelos1.entity.Inventario;
import com.example.tecnisuelos1.repository.InventarioRepository;
import com.example.tecnisuelos1.services.InventarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santiago
 */
@Service
public class InventarioServicelmpl implements InventarioService {
    
    @Autowired
    private InventarioRepository inven;

    @Override
    public List<Inventario> getInventario() {
        List<Inventario> lista = inven.findAll();
        return lista;
    }

    @Override
    public Inventario crearInven(Inventario invent) {
        Inventario nuevoInventario = inven.save(invent);
        return nuevoInventario;
    }

     @Override
    public void borrarInven(Long idInvent) {
        Inventario eliminarInventario = inven.findById(idInvent).get();
        if (eliminarInventario != null) {
            inven.deleteById(idInvent);
        }
    }

     @Override
    public Inventario buscarByIde(Long idInvent) {
        Inventario inventarioExiste = inven.findById(idInvent).get();
        return inventarioExiste;
    } 

    @Override
    public Inventario ActualizarInven(Inventario invent) {
        Inventario editarInventario = inven.findById(invent.getInventarioId()).get();
        editarInventario.setCantidadInven(invent.getCantidadInven());
        editarInventario.setNombreInven(invent.getNombreInven());
        editarInventario.setDescripcionInven(invent.getDescripcionInven());
        editarInventario.setCategoriaInven(invent.getCategoriaInven());
        editarInventario.setImagenInven(invent.getImagenInven());

        Inventario inventarioUpdate = inven.save(editarInventario);
        return inventarioUpdate;
    } 
}
