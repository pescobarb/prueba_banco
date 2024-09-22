package com.app.banco.entidades;


import java.util.List;
import javax.persistence.*;

/**
 * <b>Clase para la entidad Cliente </b>
 *
 * @author Prisila Escobar
 * @version $Revision: 1.0
 * <p>
 * [$Date: Septiembre 20, 2024 $]
 * </p>
 */
@Entity
@Table(name = "cliente")
public class Cliente {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contrasenia;
    private boolean estado;
    private Long idPersona;
    
       //Getter and Setter
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }
    
    
    
}
