package com.webapp.servlets;

import com.google.gson.Gson;
import com.modelo.beans.SolicitudAdopcion;
import com.notificaciones.control.Notificacion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import javax.persistence.*;

/**
 *
 * @author Raul
 */
@WebServlet("/FormularioAdopcion")
public class FormularioAdopcionService extends HttpServlet {

    /**
     * Hackathon 2022
     * @author Raul Barragan 
     * @version 14/05/2022 
     * @param request 
     * @param response 
     * @throws java.io.IOException 
     * @throws javax.servlet.ServletException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json; charset=UTF-8");
        JSONObject respuesta = new JSONObject();
        PrintWriter out = response.getWriter();

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String especie = request.getParameter("especieMascota");
        String motivoCausa = request.getParameter("motivoCausa");

        if (nombre.length() >= 0 && nombre.length() < 51
                && correo.length() >= 0 && correo.length() < 51
                && telefono.length() >= 0 && telefono.length() < 11
                && especie.length() >= 0 && especie.length() < 26
                && motivoCausa.length() >= 0 && motivoCausa.length() < 301) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SolicitudAdopcionPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            //Inicia la transaccion
            tx.begin();
            
            SolicitudAdopcion solicitud = new SolicitudAdopcion(nombre, correo, telefono, especie, motivoCausa);
            em.persist(solicitud);
            
            //terminamos la transaccion
            tx.commit();
                        
            //Finalizamos el EntityManager
            em.close();
            
            
            Notificacion notificacion = new Notificacion(solicitud.getNombre(), solicitud.getCorreo());

        } else {
            respuesta.put("Response", "VERIFICAR");
            respuesta.put("Message", "Un campo se encuentra vacio.");

            out.print(respuesta);
            out.flush();
            response.setStatus(200);
        }

        respuesta.put("Response", "OK");
        respuesta.put("Message", "Solicitud recibida correctamente");
        response.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));

        String json = "";
        if (br != null) {
            json = br.readLine();
        }
        System.out.println(json);
        System.out.println("ok 1");

        System.out.println();

        JSONObject jsonObject = new JSONObject("{nombre:\"Juan\",preferencias:[\"Leer\",\"Cantar\"]}");

        Gson g = new Gson();
        SolicitudAdopcion s = g.fromJson(json, SolicitudAdopcion.class);

        System.out.println(s.toString());

//        JSONObject jsonObj = new JSONObject(json);    //Creating A JSON 
//        
//
//        String codificado = jsonObj.toString();
//        System.out.println(codificado);
        System.out.println("ok 4");

//        JsonParser jsonParser = new JsonParser();
//        JsonObject myJson = (JsonObject) jsonParser.parse(json);
//        
//        System.out.println(myJson.get("nombre"));
//        System.out.println("ok 2");
//        
//        response.setContentType("application/json; charset=UTF-8");
//        System.out.println(request.getParameter("saludo"));
//        String json = "{nombre:\"Juan\",preferencias:[\"Leer\",\"Cantar\"]}";
//        JsonParser jsonParser = new JsonParser();
//        JsonObject myJson = (JsonObject) jsonParser.parse(json);
//
//        System.out.println("Hola x2");
//        
//        
//        System.out.println("Hola4");
//        System.out.println(myJson.get("nombre"));
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SolicitudAdopcionPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        //Inicia la transaccion
//        tx.begin();
////        for (int i = 0; i < 100; i++) {
//        //No se debe especificar el ID de la base de datos
//        SolicitudAdopcion solicitud = new SolicitudAdopcion("Raul Barragan", "uncorreo@gmail.com", "4444", "Tortuga", "Unos problemas");
////        SolicitudAdopcion solicitud = new SolicitudAdopcion();
//
//        //Persistimos el objeto
//        em.persist(solicitud);
////        }
//
//        //terminamos la transaccion
//        tx.commit();
//
//        em.close();
//
//        response.setStatus(200);
//
//        JSONObject peticion = new JSONObject();
//
//        PrintWriter printout = response.getWriter();
//
//        JSONObject JObject = new JSONObject();
//        JObject.put("Response", "OK");
//        JObject.put("Message", "Solicitud recibida");
//
//        printout.print(JObject);
//        printout.flush();
    }

}
