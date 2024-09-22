package com.app.banco.controlador;


import com.app.banco.entidades.Persona;
import com.app.banco.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author alba.escobar
 */
@RestController
@RequestMapping("/persona")
public class PersonaControlador{

    @Autowired
    private PersonaServicio personaServicio;

    // GET: Listar todos los clientes
    @GetMapping
    public List<Persona> listarTodos() {
        return personaServicio.obtenerTodos();
    }

    // GET: Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPorId(@PathVariable Long id) {
        Persona cliente = personaServicio.obtenerPorId(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: Crear un nuevo cliente
    @PostMapping
    public Persona crearPersona(@RequestBody Persona cliente) {
        return personaServicio.guardar(cliente);
    }

    // PUT: Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona cliente) {
        Persona clienteExistente = personaServicio.obtenerPorId(id);
        if (clienteExistente != null) {
            cliente.setId(id);
            return new ResponseEntity<>(personaServicio.guardar(cliente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        personaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
