package com.webapp.Hackathon.resources.mail;

import java.util.Properties;

public class Mail {

    public Mail() {
    }

    public void sendMail(String destinatario, String asunto, String mensaje) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
    }
}
