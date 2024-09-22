/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.banco.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author alba.escobar
 */
public class EstadoCuentaDto implements Serializable {

    private LocalDate fecha;
    private String nombresCliente;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Double movimiento;
    private Double saldoDisponible;

    public EstadoCuentaDto(LocalDate fecha, String nombresCliente, String numeroCuenta, String tipoCuenta, Double saldoInicial, Double movimiento, Double saldoDisponible) {
        this.fecha = fecha;
        this.nombresCliente = nombresCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.movimiento = movimiento;
        this.saldoDisponible = saldoDisponible;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    
    
    
   

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Double movimiento) {
        this.movimiento = movimiento;
    }

   

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

}
