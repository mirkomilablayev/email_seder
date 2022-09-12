package com.example.java_mail_sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SpringBootApplication
public class JavaMailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMailSenderApplication.class, args);
        //receiver email
        String receiverEmail = "eshmurodovogabek19@gmail.com";
        //sender email
        String senderEmail = "mirkomilablayev777@gmail.com";
        //get system properties
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //get session object // add pass and username
        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(senderEmail, "zcvjudmyagoeoova");
            }
        });

        // used to debug smtp  issues
        session.setDebug(true);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));

            message.setSubject("Lets make it easier");

            message.setText("Ishlar qale");

            System.out.println("Sending.......");

            Transport.send(message);

            System.out.println("Send message is successfully......");


        }catch (MessagingException mex){
            mex.printStackTrace();
        }
    }

}
