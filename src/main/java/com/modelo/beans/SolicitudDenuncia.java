package com.modelo.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tsolicitudes_denuncias")
public class SolicitudDenuncia implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TSD_PK")
    private int pkSolicitud;
    @Column(name="TSD_DESCRIPCION_HECHO")
    private String descripcion;
    
    
    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     */
    public SolicitudDenuncia(){}

    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     * @param pkSolicitud 
     */
    public SolicitudDenuncia(int pkSolicitud) {
        this.pkSolicitud = pkSolicitud;
    }

    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     * @param descripcion 
     */
    public SolicitudDenuncia(String descripcion) {
        this.descripcion = descripcion;
        
    }

    public int getPkSolicitud() {
        return pkSolicitud;
    }

    public void setPkSolicitud(int pkSolicitud) {
        this.pkSolicitud = pkSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "SolicitudAdopcion{  " + "pkSolicitud=" + pkSolicitud + 
                                    ", descripcion=" + descripcion + 
                                '}';
    }
}