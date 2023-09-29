/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.tecnisuelos1.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.example.tecnisuelos1.entity.PruebaCampo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaCampoRepository extends JpaRepository<PruebaCampo, Long> {
    @Query
    ("SELECT p FROM PruebaCampo p WHERE p.nombreEmpleado LIKE %?1% OR p.fecha LIKE %?1% OR p.numeroCilindro LIKE %?1% OR p.numeroPrueba LIKE %?1% OR p.cliente LIKE %?1% OR p.ubicacion LIKE %?1% OR p.sondeo LIKE %?1% OR p.revenimiento LIKE %?1% OR p.ultrasonico LIKE %?1% OR p.esclerometria LIKE %?1% OR p.analisisPetrograficos LIKE %?1% OR p.elaboracion LIKE %?1% OR p.reactividad LIKE %?1% OR p.compresion LIKE %?1% OR p.tipoPrueba LIKE %?1%")
    public List<PruebaCampo> findAll(String palabraClave);

}
