/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.services;

import com.example.tecnisuelos1.entity.Inventario;
import java.util.List;

/**
 *
 * @author santiago
 */
public interface InventarioService {

    public List<Inventario> getInventario(String palabraClave);
    public Inventario crearInven(Inventario invent);
    public void borrarInven(Long idInvent);
    public Inventario buscarByIde(Long idInvent);
    public Inventario ActualizarInven(Inventario invent);
}
