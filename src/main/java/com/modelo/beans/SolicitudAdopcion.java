package com.modelo.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tsolicitudes_adopcion")
public class SolicitudAdopcion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TSA_PK")
    private int pkSolicitud;
    @Column(name="TSA_NOMBRE")
    private String nombre;
    @Column(name="TSA_CORREO")
    private String correo;
    @Column(name="TSA_TELEFONO")
    private String telefono;
    @Column(name="TSA_ESPECIE_MASCOTA")
    private String especieMascota;
    @Column(name="TSA_MOTIVO")
    private String motivoCausa;
    
    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     */
    public SolicitudAdopcion(){}

    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     * @param pkSolicitud 
     */
    public SolicitudAdopcion(int pkSolicitud) {
        this.pkSolicitud = pkSolicitud;
    }

    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     * @param nombre 
     * @param correo 
     * @param telefono 
     * @param especieMascota 
     * @param motivoCausa 
     */
    public SolicitudAdopcion(String nombre, String correo, String telefono, String especieMascota, String motivoCausa) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.especieMascota = especieMascota;
        this.motivoCausa = motivoCausa;
    }

    public int getPkSolicitud() {
        return pkSolicitud;
    }

    public void setPkSolicitud(int pkSolicitud) {
        this.pkSolicitud = pkSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecieMascota() {
        return especieMascota;
    }

    public void setEspecieMascota(String especieMascota) {
        this.especieMascota = especieMascota;
    }

    public String getMotivoCausa() {
        return motivoCausa;
    }

    public void setMotivoCausa(String motivoCausa) {
        this.motivoCausa = motivoCausa;
    }

    @Override
    public String toString() {
        return "SolicitudAdopcion{  " + "pkSolicitud=" + pkSolicitud + 
                                    ", nombre=" + nombre + 
                                    ", correo=" + correo + 
                                    ", telefono=" + telefono + 
                                    ", especieMascota=" + especieMascota + 
                                    ", motivoCausa=" + motivoCausa +
                                '}';
    }
}