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
        EmailSenderService emailSenderService = new EmailSenderService();
        Boolean send = emailSenderService.send("eshmurodovogabek19@gmail.com", "shu", "shu");
        System.out.println(send);
    }

}
