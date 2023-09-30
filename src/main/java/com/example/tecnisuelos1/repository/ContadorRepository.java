/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.repository;

import com.example.tecnisuelos1.entity.Contador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santiago
 */
@Repository
public interface ContadorRepository  extends JpaRepository<Contador, Long>{
    @Query
    ("SELECT c FROM Contador c WHERE CONCAT(c.clienteId, ' ', c.fecha, ' ', c.celNumero, ' ', c.direccionCliente, ' ', c.nombreCliente, ' ', c.apellidoCliente, ' ', c.emailCliente) LIKE %?1%")
    public List<Contador> findAll(String palabraClave);
}
    