package com.app.banco.repositorio;

import com.app.banco.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <b>Repositorio para la entidad Cliente</b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    
}
