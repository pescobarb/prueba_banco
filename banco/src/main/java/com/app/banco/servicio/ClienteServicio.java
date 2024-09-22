package com.app.banco.servicio;

import com.app.banco.entidades.Cliente;
import com.app.banco.repositorio.ClienteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>Servicio para Cliente</b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> obtenerTodos() {
        return clienteRepositorio.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepositorio.findById(id).get();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepositorio.deleteById(id);
    }
}
