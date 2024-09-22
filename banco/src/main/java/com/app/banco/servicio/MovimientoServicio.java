/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.banco.servicio;

import com.app.banco.dto.EstadoCuentaDto;
import com.app.banco.entidades.Movimientos;
import com.app.banco.entidades.MovimientosH;
import com.app.banco.repositorio.MovimientosHRepositorio;
import com.app.banco.repositorio.MovimientosRepositorio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>Servicio para Movimientos</b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
@Service
public class MovimientoServicio {

    @Autowired
    private MovimientosRepositorio movimientosRepositorio;
        @Autowired
    private MovimientosHRepositorio movimientosHRepositorio;

    public List<Movimientos> obtenerTodos() {
        return movimientosRepositorio.findAll();
    }

    public Movimientos obtenerPorId(Long id) {
        Optional<Movimientos> mvs = movimientosRepositorio.findById(id);
 
        if (mvs.isPresent()) {
            return mvs.get();
        } else {
            new RuntimeException("Movimiento no encontrado con id " + id);
        }
        return null;
    }

    public Movimientos guardar(Movimientos producto) {
        return movimientosRepositorio.save(producto);
    }

    public void eliminar(Long id) {
        movimientosRepositorio.deleteById(id);
    }

    public Movimientos actualizarMovimientoSaldo(Long id, Double nuevoSaldo) {
        return movimientosRepositorio.findById(id)
                .map(movimientoExistente -> {
                    MovimientosH movH = new MovimientosH();
                    movimientoExistente.setValor(nuevoSaldo);
                    movH.setIdMovimiento(movimientoExistente.getId());
                    movH.setValorTransaccion( movimientoExistente.getValor());
                    movH.setSaldoActual(movimientoExistente.getSaldo());
                    movimientosHRepositorio.save(movH);
                    return movimientosRepositorio.save(movimientoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado con id " + id));
    }
    
    public List<EstadoCuentaDto> obtenerMovimientosPorFechas(Long idCuenta, LocalDate fechaInicio, LocalDate fechaFin) {
        return movimientosRepositorio.buscarMovimientosPorCuentaFechas(idCuenta, fechaInicio, fechaFin);
    }
}
