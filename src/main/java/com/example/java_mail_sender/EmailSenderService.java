package com.example.java_mail_sender;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private static final String senderEmail = "mirkomilablayev777@gmail.com";

    private static final String passwordEmail = "zcvjudmyagoeoova";

    public Boolean send(String receiver, String subjectText, String messageText) {
        System.out.println(senderEmail);
        System.out.println(passwordEmail);
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, passwordEmail);
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(subjectText);
            message.setText(messageText);
            System.out.println("Sending an email");
            Transport.send(message);
            System.out.println("message is successfully sent.");
            return true;
        } catch (MessagingException mex) {
            return false;
        }
    }
}
