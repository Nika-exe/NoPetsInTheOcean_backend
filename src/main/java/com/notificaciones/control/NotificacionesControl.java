package com.notificaciones.control;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

public class NotificacionesControl {
    private final String correoEnvia      = "lauchxback001@gmail.com";
    private final String passwordEnvia    = "launchxbackContra";

    private Properties properties;
    private MimeMessage message;
    private Authenticator authenticator;

    private String correoPara;
    private String[] correosCopia;
    private String asunto;
    private String cuerpoCorreo;

    /**
     * 
     * @author  Raul Barragan
     * @version 01/03/22
     */
    public NotificacionesControl(){
        properties = new Properties();
        properties.setProperty("mail.smtp.host", "package com.notificaciones.control;");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");

        authenticator = new javax.mail.Authenticator(){
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                        correoEnvia, passwordEnvia);
            }
        };

        Session session = Session.getDefaultInstance(properties, authenticator);
        message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(correoEnvia));
        } catch (MessagingException e) {
        }
    }

    /**
     * 
     * @author  Raul Barragan
     * @param correoPara
     * @param correosCopia
     * @param asunto
     * @param cuerpoCorreo
     * @version 03/03/22
     */
    public NotificacionesControl(String correoPara, String[] correosCopia, String asunto, String cuerpoCorreo){
        setCorreoPara(correoPara);
        setCorreosCopia(correosCopia);
        setAsunto(asunto);
        setCuerpoCorreo(cuerpoCorreo);

        properties = new Properties();
        properties.setProperty("mail.smtp.host", "package com.notificaciones.control;");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");

        authenticator = new javax.mail.Authenticator(){
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                        correoEnvia, passwordEnvia);
            }
        };

        Session session = Session.getDefaultInstance(properties, authenticator);
        message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(correoEnvia));
        } catch (MessagingException e) {
        }
    }

    /**
     * Intenta hacer el envio del correo
     * @author Raul Barragan
     * @return true or false
     */
    public Boolean enviarCorreo(){
        try {
            establecerDestinatario();
            establecerDestinatarioCC();
            establecerAsunto();
            establecerCuerpo();

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            return false;
        }

    }

        /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     */
    private void establecerDestinatario(){
        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoPara));
        } catch (MessagingException e) {
        }

    }

    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     */
    private void establecerDestinatarioCC(){
        try {
            for(String correo : getCorreosCopia()){
                message.addRecipient(Message.RecipientType.CC, new InternetAddress(correo));
            }
        } catch (MessagingException e) {
        }
    }

    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     */
    private void establecerAsunto(){
        try {
            message.setSubject(asunto);
        } catch (MessagingException e) {
        }

    }

    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     */
    private void establecerCuerpo(){
        try {
            message.setContent(cuerpoCorreo,"text/html");
        } catch (MessagingException e) {
        }

    }







    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     * @return 
     */
    public String getCuerpoCorreo() {
        return cuerpoCorreo;
    }

    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     * @param cuerpoCorreo
     */
    public void setCuerpoCorreo(String cuerpoCorreo) {
        this.cuerpoCorreo = cuerpoCorreo;
    }

    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     * @return 
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * 
     * @author  Raul Barragan
     * @param asunto
     * @version 02/03/22
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     * @return 
     */
    public String[] getCorreosCopia() {
        return correosCopia;
    }

    /**
     * 
     * @author  Raul Barragan
     * @param correosCopia
     * @version 02/03/22
     */
    public void setCorreosCopia(String[] correosCopia) {
        this.correosCopia = correosCopia;
    }

    /**
     * 
     * @author  Raul Barragan
     * @version 02/03/22
     * @return 
     */
    public String getCorreoPara() {
        return correoPara;
    }

    /**
     * @author  Raul Barragan
     * @param correoPara
     * @version 02/03/22
     */
    public void setCorreoPara(String correoPara) {
        this.correoPara = correoPara;
    }
}