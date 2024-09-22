package com.app.banco.servicio;

import com.app.banco.entidades.MovimientosH;
import com.app.banco.repositorio.MovimientosHRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>Servicio para MovimientosH</b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
@Service
public class MovimientosHServicio {

    @Autowired
    private MovimientosHRepositorio movimientosHRepositorio;

    public List<MovimientosH> obtenerTodos() {
        return movimientosHRepositorio.findAll();
    }

    public MovimientosH guardar(MovimientosH producto) {
        return movimientosHRepositorio.save(producto);
    }

    public void eliminar(Long id) {
        movimientosHRepositorio.deleteById(id);
    }

}
