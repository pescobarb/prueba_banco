package com.app.banco.controlador;

import com.app.banco.entidades.Movimientos;
import com.app.banco.entidades.MovimientosH;
import com.app.banco.servicio.MovimientoServicio;
import com.app.banco.servicio.MovimientosHServicio;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alba.escobar
 */
@RestController
@RequestMapping("/movimientos")
public class MovimientosControlador {

    @Autowired
    private MovimientoServicio movimientoServicio;
    @Autowired
    private MovimientosHServicio movimientoHServicio;

    // GET: Listar todos los movimientos
    @GetMapping
    public List<Movimientos> listarTodos() {
        return movimientoServicio.obtenerTodos();
    }
    
       // GET: Listar todos los movimientos
    @GetMapping("/historico")
    public List<MovimientosH> listarTodosHistoricos() {
        return movimientoHServicio.obtenerTodos();
    }

    // GET: Obtener un movimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimientos> obtenerPorId(@PathVariable Long id) {
        Movimientos movimiento = movimientoServicio.obtenerPorId(id);
        if (movimiento != null) {
            return new ResponseEntity<>(movimiento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: Crear un nuevo movimiento
    @PostMapping
    public Movimientos crearMovimientos(@RequestBody Movimientos movimiento) {
        return movimientoServicio.guardar(movimiento);
    }

    // PUT: Actualizar un movimiento existente
    @PutMapping("/{id}/saldo")
    public ResponseEntity<Movimientos> actualizarMovimientos(
            @PathVariable Long id, @RequestParam Double nuevoSaldo) {
        Movimientos movimientoExistente = movimientoServicio.obtenerPorId(id);
        if (movimientoExistente != null) {
            movimientoExistente.setFecha(LocalDate.now());
            movimientoExistente.setSaldo(movimientoExistente.getSaldo() + nuevoSaldo);
            if(movimientoExistente.getSaldo() <= 0){
                System.out.println("Saldo insuficiente para realziar la transacción...");  
                return null;
            }
            return new ResponseEntity<>(movimientoServicio.actualizarMovimientoSaldo(id, nuevoSaldo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Eliminar un movimiento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimientos(@PathVariable Long id) {
        movimientoServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
