package com.webapp.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.modelo.beans.DireccionDenuncias;
import com.modelo.beans.SolicitudAdopcion;
import com.modelo.beans.SolicitudDenuncia;
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
@WebServlet("/FormularioDenuncia")
public class FormularioDenunciaService extends HttpServlet {

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
        
        String descripcion = request.getParameter("descripcionHecho");
        String avenida = request.getParameter("avenida");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String cp = request.getParameter("cp");
        String referencia = request.getParameter("referencia");
        

        if (descripcion.length() >= 0 && descripcion.length() < 46
                && avenida.length() >= 0 && avenida.length() < 46
                && ciudad.length() >= 0 && ciudad.length() < 46
                && estado.length() >= 0 && estado.length() < 46
                && cp.length() >= 0 && cp.length() < 6
                && referencia.length() >= 0 && referencia.length() < 301) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SolicitudDenunciaPU");
            EntityManagerFactory emfDireccion = Persistence.createEntityManagerFactory("DireccionDenunciaPU");

            EntityManager em = emf.createEntityManager();
            EntityManager emDireccion = emfDireccion.createEntityManager();
            
            EntityTransaction tx = em.getTransaction();
            EntityTransaction txDireccion = emDireccion.getTransaction();
            //Inicia la transaccion
            tx.begin();
            
            SolicitudDenuncia solicitud = new SolicitudDenuncia(descripcion);
            em.persist(solicitud);
            
            //terminamos la transaccion
            tx.commit();
            int pkDenuncia = solicitud.getPkSolicitud();
            
            
            txDireccion.begin();
            
            DireccionDenuncias direccionDenuncia = new DireccionDenuncias(pkDenuncia,avenida, ciudad, estado, cp, referencia);
            emDireccion.persist(direccionDenuncia);
            
            txDireccion.commit();
            
                        
            //Finalizamos el EntityManager
            em.close();
            emDireccion.close();

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
