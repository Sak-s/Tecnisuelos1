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
@Table(name = "inventario")
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventarioId;

    @Column(length = 100, nullable = false)
    private String cantidadInven;

    @Column(length = 200, nullable = false)
    private String nombreInven;

    @Column(length = 300, nullable = false)
    private String descripcionInven;

    @Column(length = 200, nullable = false)
    private String categoriaInven;

    @Column(length = 200, nullable = false)
    private String imagenInven;

    public Inventario(long inventarioId, String cantidadInven, String nombreInven, String descripcionInven,
            String categoriaInven, String imagenInven) {
        this.inventarioId = inventarioId;
        this.cantidadInven = cantidadInven;
        this.nombreInven = nombreInven;
        this.descripcionInven = descripcionInven;
        this.categoriaInven = categoriaInven;
        this.imagenInven = imagenInven;
    }

    public Inventario() {

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(long inventarioId) {
        this.inventarioId = inventarioId;
    }

    public String getCantidadInven() {
        return cantidadInven;
    }

    public void setCantidadInven(String cantidadInven) {
        this.cantidadInven = cantidadInven;
    }

    public String getNombreInven() {
        return nombreInven;
    }

    public void setNombreInven(String nombreInven) {
        this.nombreInven = nombreInven;
    }

    public String getDescripcionInven() {
        return descripcionInven;
    }

    public void setDescripcionInven(String descripcionInven) {
        this.descripcionInven = descripcionInven;
    }

    public String getCategoriaInven() {
        return categoriaInven;
    }

    public void setCategoriaInven(String categoriaInven) {
        this.categoriaInven = categoriaInven;
    }

    public String getImagenInven() {
        return imagenInven;
    }

    public void setImagenInven(String imagenInven) {
        this.imagenInven = imagenInven;
    }

}
