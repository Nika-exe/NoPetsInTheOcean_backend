package com.notificaciones.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PlantillaNotificacionesControl {
    public static String PLANTILLA_NOTIFICACIONES_ADOPCION = "notificacion_adopcion.html";






    private String  cuerpoPlantilla;
    private InputStream input = null;
    private BufferedReader buffered = null;

    /**
     * 
     * @author  Raul Barragan
     * @version 03/03/22
     * @param nombrePlantilla
     */
    public PlantillaNotificacionesControl(String nombrePlantilla){
        String cuerpoAux = "";

        try {

            input = getClass().getResourceAsStream("/Web Pages/plantillas/" + nombrePlantilla); 
            buffered =  new BufferedReader(new InputStreamReader(input));

            while(buffered.ready()){
                cuerpoAux += buffered.readLine();
            }
            

        } catch (IOException e) {
        } /* finally{
            objeto.close();
        } */

        setCuerpoPlantilla(cuerpoAux);
    }

    /**
     * @author  Raul Barragan
     * @param nombrePlantilla
     * @param elementos
     * @version 03/03/22
     */
    public PlantillaNotificacionesControl(String nombrePlantilla, Object... elementos){
        String cuerpoAux = "";

//        try {
//            input = getClass().getResourceAsStream("./Web Pages/plantillas/" + nombrePlantilla); 
//            System.out.println(input);
//            buffered =  new BufferedReader(new InputStreamReader(input));
//
//            while(buffered.ready()){
//                cuerpoAux += buffered.readLine();
//            }
//            
//
//        } catch (IOException e) {
//        } /* finally{
//            objeto.close();
//        } */

        cuerpoAux = String.format("HOLA %s ", elementos);
        setCuerpoPlantilla(cuerpoAux);
    }

    /**
     * Se formatea el cuerpo de la plantilla con los elementos que se asignaran
     * @author Raul Barragan
     * @param elementos
     * @version 03/03/2022
     */
    public void formatoCuerpoPlantilla(Object... elementos){
        String cuerpoAux = String.format(getCuerpoPlantilla(), elementos);

        setCuerpoPlantilla(cuerpoAux);
    }

    /**
     * 
     * @author Raul Barragan
     * @version 03/03/22
     * @return cuerpoPlantilla
     */
    public String getCuerpoPlantilla() {
        return cuerpoPlantilla;
    }

    /**
     * @author Raul Barragan
     * @param cuerpoPlantilla
     * @version 03/03/22
     */
    public void setCuerpoPlantilla(String cuerpoPlantilla) {
        this.cuerpoPlantilla = cuerpoPlantilla;
    }
}
