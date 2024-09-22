package com.app.banco.servicio;

import com.app.banco.entidades.Cuenta;
import com.app.banco.repositorio.CuentaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>Servicio para Cuenta</b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
@Service
public class CuentaServicio {

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    public List<Cuenta> obtenerTodos() {
        return cuentaRepositorio.findAll();
    }

    public Cuenta obtenerPorId(Long id) {
        return cuentaRepositorio.findById(id).get();
    }

    public Cuenta guardar(Cuenta producto) {
        return cuentaRepositorio.save(producto);
    }

    public void eliminar(Long id) {
        cuentaRepositorio.deleteById(id);
    }
}
