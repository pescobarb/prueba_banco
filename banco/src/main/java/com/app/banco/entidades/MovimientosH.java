package com.app.banco.entidades;

import javax.persistence.*;

/**
 * <b>Clase para la entidad Movimientos</b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
@Entity
@Table(name = "movimientosh")
public class MovimientosH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idMovimiento;
    private Double valorTransaccion;
    private Double saldoActual;
    
    
    //Getter and Setter

   
    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Double getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(Double valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    
}
