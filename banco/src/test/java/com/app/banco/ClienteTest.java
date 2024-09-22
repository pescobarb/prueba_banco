package com.app.banco;

import com.app.banco.entidades.Cliente;
import com.app.banco.entidades.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setContrasenia("12347890.");
        cliente.setEstado(true);
    }

    // Prueba para verificar el getter del ID
    @Test
    public void testGetId() {
        assertEquals(1L, cliente.getId());
    }

    // Prueba para verificar el setter del ID
    @Test
    public void testSetId() {
        cliente.setId(2L);
        assertEquals(2L, cliente.getId());
    }

    // Prueba para verificar el getter del nombre
    @Test
    public void testGetContrasenia() {
        assertEquals("12347890.", cliente.getContrasenia());
    }

    // Prueba para verificar el setter del nombre
    @Test
    public void testSetContrasenia() {
        cliente.setContrasenia("12347890..");
        assertEquals("12347890..", cliente.getContrasenia());
    }

    // Prueba para verificar el getter del email
    @Test
    public void testGetEstado() {
        assertEquals(true, cliente.isEstado());
    }

    // Prueba para verificar el setter del email
    @Test
    public void testSetEstado() {
        cliente.setEstado(false);
        assertEquals(false, cliente.isEstado());
    }
}
