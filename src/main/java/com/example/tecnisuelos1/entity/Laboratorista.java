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


/**
 *
 * @author santiago
 */
@Entity
@Table(name = "laboratorista")
public class Laboratorista implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long laboratoristaId;

    @Column(nullable = false)
    private String tipoPrueba;

    @Column(length = 200, nullable = false)
    private String nombreEmpleado;

    @Column(nullable = false)
    private String fecha;

    @Column(length = 200, nullable = false)
    private String numerocilindro;

    @Column(length = 200, nullable = false)
    private String numeroPrueba;

    @Column(length = 200, nullable = false)
    private String cliente;

    @Column(length = 200, nullable = false)
    private String granulometria;

    @Column(length = 200, nullable = false)
    private String contenidoAire;

    @Column(length = 200, nullable = false)
    private String flexionCocreto;

    @Column(length = 200, nullable = false)
    private String compresion;

    @Column(length = 20, nullable = false)
    private String estudioPetrografico;

    @Column(nullable = false)
    private String elasticidadExtensometro;

    @Column(length = 200, nullable = false)
    private String contraccionSecado;

    @Column(length = 200, nullable = false)
    private String pruebasPermeabilidad;

    // Constructor
    public Laboratorista() {
    }

    public Laboratorista(
            Long laboratoristaId,
            String tipoPrueba,
            String nombreEmpleado,
            String fecha,
            String numerocilindro,
            String numeroPrueba,
            String cliente,
            String granulometria,
            String contenidoAire,
            String flexionCocreto,
            String compresion,
            String estudioPetrografico,
            String elasticidadExtensometro,
            String contraccionSecado,
            String pruebasPermeabilidad) {

        this.laboratoristaId = laboratoristaId;
        this.nombreEmpleado = nombreEmpleado;
        this.tipoPrueba = tipoPrueba;
        this.fecha = fecha;
        this.numerocilindro = numerocilindro;
        this.numeroPrueba = numeroPrueba;
        this.cliente = cliente;
        this.granulometria = granulometria;
        this.contenidoAire = contenidoAire;
        this.flexionCocreto = flexionCocreto;
        this.compresion = compresion;
        this.estudioPetrografico = estudioPetrografico;
        this.elasticidadExtensometro = elasticidadExtensometro;
        this.contraccionSecado = contraccionSecado;
        this.pruebasPermeabilidad = pruebasPermeabilidad;
    }

    // Getters y setters 
    public long getLaboratoristaId() {
        return laboratoristaId;
    }

    public void setLaboratoristaId(long laboratoristaId) {
        this.laboratoristaId = laboratoristaId;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumerocilindro() {
        return numerocilindro;
    }

    public void setNumerocilindro(String numerocilindro) {
        this.numerocilindro = numerocilindro;
    }

    public String getNumeroPrueba() {
        return numeroPrueba;
    }

    public void setNumeroPrueba(String numeroPrueba) {
        this.numeroPrueba = numeroPrueba;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getGranulometria() {
        return granulometria;
    }

    public void setGranulometria(String granulometria) {
        this.granulometria = granulometria;
    }

    public String getContenidoAire() {
        return contenidoAire;
    }

    public void setContenidoAire(String contenidoAire) {
        this.contenidoAire = contenidoAire;
    }

    public String getFlexionCocreto() {
        return flexionCocreto;
    }

    public void setFlexionCocreto(String flexionCocreto) {
        this.flexionCocreto = flexionCocreto;
    }

    public String getCompresion() {
        return compresion;
    }

    public void setCompresion(String compresion) {
        this.compresion = compresion;
    }

    public String getEstudioPetrografico() {
        return estudioPetrografico;
    }

    public void setEstudioPetrografico(String estudioPetrografico) {
        this.estudioPetrografico = estudioPetrografico;
    }

    public String getElasticidadExtensometro() {
        return elasticidadExtensometro;
    }

    public void setElasticidadExtensometro(String elasticidadExtensometro) {
        this.elasticidadExtensometro = elasticidadExtensometro;
    }

    public String getContraccionSecado() {
        return contraccionSecado;
    }

    public void setContraccionSecado(String contraccionSecado) {
        this.contraccionSecado = contraccionSecado;
    }

    public String getPruebasPermeabilidad() {
        return pruebasPermeabilidad;
    }

    public void setPruebasPermeabilidad(String pruebasPermeabilidad) {
        this.pruebasPermeabilidad = pruebasPermeabilidad;
    }
}
