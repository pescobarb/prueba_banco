/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.banco.controlador;

import com.app.banco.dto.EstadoCuentaDto;
import com.app.banco.entidades.Cuenta;
import com.app.banco.entidades.Movimientos;
import com.app.banco.servicio.CuentaServicio;
import com.app.banco.servicio.MovimientoServicio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alba.escobar
 */
@RestController
@RequestMapping("/reportes")
public class ReporteControlador {

    @Autowired
    private MovimientoServicio movimientoServicio;
    @Autowired
    private CuentaServicio cuentaServicio;

    @GetMapping("/{id}/reporteMovimientosCuenta")
    public List<EstadoCuentaDto> obtenerReporteMovimientos(
            @PathVariable Long id,
            @RequestParam String fechaInicial,
            @RequestParam String fechaFinal) {
        Cuenta cuentaExistente = cuentaServicio.obtenerPorId(id);
        if (cuentaExistente != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaInicio = LocalDate.parse(fechaInicial, formatter);
            LocalDate fechaFin = LocalDate.parse(fechaFinal, formatter);
            return movimientoServicio.obtenerMovimientosPorFechas(id, fechaInicio, fechaFin);
        } else {
            System.out.println("Cuenta no existe");
            return null;
        }
    }

}
