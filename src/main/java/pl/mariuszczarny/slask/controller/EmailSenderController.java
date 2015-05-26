/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author jacek
 */
@ManagedBean(name = "emailSenderController")
@SessionScoped
public class EmailSenderController implements Serializable{
    
    private static final long serialVersionUID = 1L;
	
    private String address;
    private String title;
    private String message;
    
    final String userName = "slaskManager@gmail.com";
    final String password = "JMslask123";
    // Sender's email ID needs to be mentioned later change to techSupport...@gmail.com
    Properties props = new Properties();
		
    Session session;

        
    public EmailSenderController(){
        address="";
        title="";
        message="";
        
        props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
        session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		  });
    }
    
    public void sendMail(){
        try{
        Message mail = new MimeMessage(session);
	mail.setFrom(new InternetAddress(userName));
	mail.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(address));

         // Set Subject: header field
         mail.setSubject(title);

         // Now set the actual message
         mail.setText(message);

         // Send message
         Transport.send(mail);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
