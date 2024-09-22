package com.app.banco.repositorio;

import com.app.banco.dto.EstadoCuentaDto;
import com.app.banco.entidades.Movimientos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <b>Repositorio para la entidad Movimientos</b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
public interface MovimientosRepositorio extends JpaRepository<Movimientos, Long> {
    
  @Query("select new com.app.banco.dto.EstadoCuentaDto"
          + "(m.fecha, p.nombre, c.numeroCuenta, c.tipoCuenta, c.saldoInicial,m.valor,m.saldo) "
          + " FROM Movimientos m , Cuenta c, Cliente l, Persona p"
          + " WHERE m.idCuenta=c.id and c.idCliente=l.id and l.idPersona=p.id and "
          + " c.id= :idCuenta and "
          + " m.fecha BETWEEN :fechaInicial AND :fechaFinal")
  List<EstadoCuentaDto> buscarMovimientosPorCuentaFechas(
            @Param("idCuenta") Long idCuenta, 
            @Param("fechaInicial") LocalDate fechaInicial, 
            @Param("fechaFinal") LocalDate fechaFinal);

}
