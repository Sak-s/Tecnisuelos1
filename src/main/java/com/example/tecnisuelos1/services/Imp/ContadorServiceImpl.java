/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.services.Imp;

import com.example.tecnisuelos1.entity.Contador;
import com.example.tecnisuelos1.repository.ContadorRepository;
import com.example.tecnisuelos1.services.ContadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santiago
 */
@Service
public class ContadorServiceImpl implements ContadorService {

    @Autowired
    private ContadorRepository clie;

    @Override
    public List<Contador> getCliente(String palabraClave){
        if (palabraClave != null){
            return clie.findAll(palabraClave);
        }
        return clie.findAll();
    }

    @Override
    public Contador crearCliente(Contador conta) {
        Contador nuevoCliente = clie.save(conta);
        return nuevoCliente;
    }

    @Override
    public void borrarCliente(Long idContador) {
        Contador eliminarCliente = clie.findById(idContador).get();
        if (eliminarCliente != null) {
            clie.deleteById(idContador);
        }
    }

    @Override
    public Contador buscarById(Long idContador) {
        Contador clienteExiste = clie.findById(idContador).get();
        return clienteExiste;
    }

    @Override
    public Contador ActualizarCliente(Contador conta) {
        Contador editarCliente = clie.findById(conta.getClienteId()).get();
        editarCliente.setFecha(conta.getFecha());
        editarCliente.setCelNumero(conta.getCelNumero());
        editarCliente.setDireccionCliente(conta.getDireccionCliente());
        editarCliente.setNombreCliente(conta.getNombreCliente());
        editarCliente.setApellidoCliente(conta.getApellidoCliente());
        editarCliente.setEmailCliente(conta.getEmailCliente());

        Contador clianteUpdate = clie.save(editarCliente);
        return clianteUpdate;
    }

}
