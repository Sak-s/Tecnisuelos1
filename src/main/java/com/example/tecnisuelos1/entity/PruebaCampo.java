/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author santiago
 */
@Entity
@Table(name = "prueba_campo")
public class PruebaCampo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nombreEmpleado;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(length = 200)
    private Integer numeroCilindro;
    private Integer numeroPrueba;
    @Column(length = 200, nullable = false)
    private String cliente;
    @Column(length = 200, nullable = false)
    private String ubicacion;
    @Column(length = 200, nullable = false)
    private String sondeo;
    @Column(length = 200, nullable = false)
    private String revenimiento;
    @Column(length = 200, nullable = false)
    private String ultrasonico;
    @Column(length = 200)
    private Integer esclerometria;
    @Column(length = 200, nullable = false)
    private String analisisPetrograficos;
    @Column(length = 200, nullable = false)
    private String elaboracion;
    @Column(length = 200, nullable = false)
    private String reactividad;
    @Column(length = 200, nullable = false)
    private String compresion;

    public PruebaCampo() {
    }

    public PruebaCampo(
            Long id,
            String nombreEmpleado,
            LocalDate fecha,
            Integer numeroCilindro,
            Integer numeroPrueba,
            String cliente,
            String ubicacion,
            String sondeo,
            String revenimiento,
            String ultrasonico,
            Integer esclerometria,
            String analisisPetrograficos,
            String elaboracion,
            String reactividad,
            String compresion
    ) {
        this.id = id;
        this.fecha = fecha;
        this.numeroCilindro = numeroCilindro;
        this.numeroPrueba = numeroPrueba;
        this.cliente = cliente;
        this.ubicacion = ubicacion;
        this.sondeo = sondeo;
        this.revenimiento = revenimiento;
        this.ultrasonico = ultrasonico;
        this.esclerometria = esclerometria;
        this.analisisPetrograficos = analisisPetrograficos;
        this.elaboracion = elaboracion;
        this.reactividad = reactividad;
        this.compresion = compresion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getNumeroCilindro() {
        return numeroCilindro;
    }

    public void setNumeroCilindro(Integer numeroCilindro) {
        this.numeroCilindro = numeroCilindro;
    }

    public Integer getNumeroPrueba() {
        return numeroPrueba;
    }

    public void setNumeroPrueba(Integer numeroPrueba) {
        this.numeroPrueba = numeroPrueba;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSondeo() {
        return sondeo;
    }

    public void setSondeo(String sondeo) {
        this.sondeo = sondeo;
    }

    public String getRevenimiento() {
        return revenimiento;
    }

    public void setRevenimiento(String revenimiento) {
        this.revenimiento = revenimiento;
    }

    public String getUltrasonico() {
        return ultrasonico;
    }

    public void setUltrasonico(String ultrasonico) {
        this.ultrasonico = ultrasonico;
    }

    public Integer getEsclerometria() {
        return esclerometria;
    }

    public void setEsclerometria(Integer esclerometria) {
        this.esclerometria = esclerometria;
    }

    public String getAnalisisPetrograficos() {
        return analisisPetrograficos;
    }

    public void setAnalisisPetrograficos(String analisisPetrograficos) {
        this.analisisPetrograficos = analisisPetrograficos;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public String getReactividad() {
        return reactividad;
    }

    public void setReactividad(String reactividad) {
        this.reactividad = reactividad;
    }

    public String getCompresion() {
        return compresion;
    }

    public void setCompresion(String compresion) {
        this.compresion = compresion;
    }
}
