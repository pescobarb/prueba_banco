package com.app.banco.controlador;

import com.app.banco.entidades.Cuenta;
import com.app.banco.servicio.CuentaServicio;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alba.escobar
 */
@RestController
@RequestMapping("/cuentas")
public class CuentaControlador {

    @Autowired
    private CuentaServicio cuentaServicio;

     // GET: Listar todas las cuentas
    @GetMapping
    public List<Cuenta> listarTodos() {
        return cuentaServicio.obtenerTodos();
    }

    // GET: Obtener un cuenta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerPorId(@PathVariable Long id) {
        Cuenta cuenta = cuentaServicio.obtenerPorId(id);
        if (cuenta != null) {
            return new ResponseEntity<>(cuenta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: Crear un nuevo cuenta
    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaServicio.guardar(cuenta);
    }

    // PUT: Actualizar un cuenta existente
    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        Cuenta cuentaExistente = cuentaServicio.obtenerPorId(id);
        if (cuentaExistente != null) {
            cuenta.setId(id);
            return new ResponseEntity<>(cuentaServicio.guardar(cuenta), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Eliminar un cuenta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        cuentaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
