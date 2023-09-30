/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.repository;

import java.util.List;
import com.example.tecnisuelos1.entity.Laboratorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LaboratoristaRepository extends JpaRepository<Laboratorista, Long> {
    @Query
    ("SELECT l FROM Laboratorista l WHERE CONCAT(l.nombreEmpleado, ' ', l.fecha, ' ', l.numerocilindro, ' ', l.numeroPrueba, ' ', l.cliente, ' ', l.granulometria, ' ', l.tipoPrueba) LIKE %?1%")
    public List<Laboratorista> findAll(String palabraClave);

    
}
