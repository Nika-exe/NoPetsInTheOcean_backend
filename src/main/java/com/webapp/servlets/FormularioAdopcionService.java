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

}
