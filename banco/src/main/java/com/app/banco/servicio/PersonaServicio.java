/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.banco.servicio;

import com.app.banco.entidades.Persona;
import com.app.banco.repositorio.PersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alba.escobar
 */
@Service
public class PersonaServicio {
    
     @Autowired
    private PersonaRepositorio personaRepositorio;

    public List<Persona> obtenerTodos() {
        return personaRepositorio.findAll();
    }

    public Persona obtenerPorId(Long id) {
        return personaRepositorio.findById(id).get();
    }

    public Persona guardar(Persona cliente) {
        return personaRepositorio.save(cliente);
    }

    public void eliminar(Long id) {
        personaRepositorio.deleteById(id);
    }
}
