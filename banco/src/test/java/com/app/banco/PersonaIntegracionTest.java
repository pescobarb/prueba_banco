package com.app.banco;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonaIntegracionTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearPersona() throws Exception {
        String nuevoPersonaJson = 
                "{\n" +
"    \"nombre\": \"Rolando Escobar\",\n" +
"    \"genero\":\"Masculino\",\n" +
"    \"edad\":47,\n" +
"    \"identificacion\":\"0201952824\",\n" +
"    \"direccion\":\"Sangolqui\",\n" +
"    \"telefono\":\"0990132999\"\n" +
"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/persona")
                .contentType(MediaType.APPLICATION_JSON)
                .content(nuevoPersonaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Rolando Escobar"))
                ;
    }

    @Test
    public void testObtenerTodasPersonas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/persona")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}

