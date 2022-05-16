package com.notificaciones.control;

public class Notificacion {
    
    public Notificacion(String nombre, String correo){
        PlantillaNotificacionesControl plantillaNotificacionesControl = new PlantillaNotificacionesControl(
            PlantillaNotificacionesControl.PLANTILLA_NOTIFICACIONES_ADOPCION,
            nombre
        );

        String [] correosCopia = {};
        
        NotificacionesControl notificacionesControl = new NotificacionesControl(
            correo,
            correosCopia,
            "Notificaci\u00F3n " + " NoPetsInTheOcean",
            plantillaNotificacionesControl.getCuerpoPlantilla()
        );
        notificacionesControl.enviarCorreo();
    }
    
    
    
}
