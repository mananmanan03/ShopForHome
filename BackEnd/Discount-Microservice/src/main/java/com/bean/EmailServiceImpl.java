package com.bean;


//Java Program to Illustrate Creation Of
//Service implementation class



//Importing required classes

import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	public String sendSimpleMail(EmailDetails details)
	{

		
		String to =details.getRecipient();            // sender email
        String from = "sender@gmail.com";       // receiver email
        String host = "127.0.0.1";                   // mail server host

       Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties); 
        // default session

        try {
            MimeMessage message = new MimeMessage(session);        
            // email message

            message.setFrom(new InternetAddress(from)); 
            // setting header fields
           
            message.addRecipient(Message.RecipientType.TO, 
                               new InternetAddress(to));
            message.setSubject(details.getSubject()); // subject line

            // actual mail body
            message.setText(details.getMsgBody());

            // Send message
            Transport.send(message);
            System.out.println("Email Sent successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		return "mail sent successfully";
	}

	
	
}
