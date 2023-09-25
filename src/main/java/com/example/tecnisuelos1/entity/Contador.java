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
import java.util.Date;

/**
 *
 * @author santiago
 */
@Entity
@Table (name = "contador")
public class Contador implements Serializable {

     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clienteId;
    
    @Column(nullable = false)
    private Date fecha;

    @Column(length = 200, nullable = false)
    private String celNumero;

    @Column(length = 200, nullable = false)
    private String direccionCliente;

    @Column(length = 200, nullable = false)
    private String nombreCliente;

    @Column(length = 200, nullable = false)
    private String apellidoCliente;

    @Column(length = 200, nullable = false)
    private String emailCliente;

    //Constructor
    public Contador(Long clienteId, Date fecha, String celNumero, String direccionCliente, String nombreCliente, String apellidoCliente, String emailCliente){

        this.clienteId = clienteId;
        this.fecha = fecha;
        this.celNumero = celNumero;
        this.direccionCliente = direccionCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.emailCliente = emailCliente;
    }

    public Contador(){
        

    }
    //Getters and Setters
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCelNumero() {
        return celNumero;
    }

    public void setCelNumero(String celNumero) {
        this.celNumero = celNumero;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    












}