package com.modelo.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tdirecciones_denuncias")
public class DireccionDenuncias implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TDD_PK")
    private int pkDireccion;
    @Column(name="TDD_FK_DENUNCIA")
    private int fkDenuncia;
    @Column(name="TDD_AVENIDA")
    private String avenida;
    @Column(name="TDD_CIUDAD")
    private String ciudad;
    @Column(name="TDD_ESTADO")
    private String estado;
    @Column(name="TDD_CP")
    private String cp;
    @Column(name="TDD_REFERENCIA")
    private String referencia;
    
    
    
    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     */
    public DireccionDenuncias(){}

    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     * @param pkDireccion 
     */
    public DireccionDenuncias(int pkDireccion) {
        this.pkDireccion = pkDireccion;
    }

    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     * @param fkDenuncia 
     * @param avenida 
     * @param ciudad 
     * @param estado 
     * @param cp 
     * @param referencia 
     */
    public DireccionDenuncias(int fkDenuncia, String avenida, String ciudad, String estado, String cp, String referencia) {
        this.fkDenuncia = fkDenuncia;
        this.avenida = avenida;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cp = cp;
        this.referencia = referencia;
    }

    public int getPkSolicitud() {
        return pkDireccion;
    }

    public void setPkSolicitud(int pkSolicitud) {
        this.pkDireccion = pkSolicitud;
    }

    public int getPkDireccion() {
        return pkDireccion;
    }

    public void setPkDireccion(int pkDireccion) {
        this.pkDireccion = pkDireccion;
    }

    public int getFkDenuncia() {
        return fkDenuncia;
    }

    public void setFkDenuncia(int fkDenuncia) {
        this.fkDenuncia = fkDenuncia;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    @Override
    public String toString() {
        return "SolicitudAdopcion{  " + "pkSolicitud=" + pkDireccion + 
                                    ", fkDenuncia=" + fkDenuncia + 
                                    ", avenida=" + avenida + 
                                    ", ciudad=" + ciudad + 
                                    ", estado=" + estado + 
                                    ", cp=" + cp + 
                                    ", referencia=" + referencia + 
                                '}';
    }
}