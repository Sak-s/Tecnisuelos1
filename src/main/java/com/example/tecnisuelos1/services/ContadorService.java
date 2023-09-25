/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.services;

import com.example.tecnisuelos1.entity.Contador;
import java.util.List;

/**
 *
 * @author santiago
 */
public interface ContadorService {

    public List<Contador> getCliente();

    public Contador crearCliente(Contador conta);

    public void borrarCliente(Long idContador);

    public Contador buscarById(Long idContador);

    public Contador ActualizarCliente(Contador conta);

}
