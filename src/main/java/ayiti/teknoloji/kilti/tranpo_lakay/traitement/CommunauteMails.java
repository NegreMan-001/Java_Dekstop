/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.traitement;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author negre
 */
public class CommunauteMails {
    
//    
//    
//     // Recipient's email ID needs to be mentioned.
//        static String to = "danydaniedany1@gmail.com";
//
//        // Sender's email ID needs to be mentioned
//        static String from = "danydaniedany1@gmail.com";
//
//        // Assuming you are sending email from through gmails smtp
//        static String host = "smtp.gmail.com";
//
//        // Get system properties
//        static Properties properties = System.getProperties();

        public static void methodeVoyeMeyl(){
        // Recipient's email ID needs to be mentioned.
        String to = "danydaniedany1@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "danydaniedany1@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("danydaniedany1@gmail.com", "twnycxkzallwfuks");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
        }
       

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   // static Properties props = new Properties();  
    
    
//    public CommunauteMails(){
//          props.put("mail.smtp.host", "smtp.gmail.com");    
//          props.put("mail.smtp.socketFactory.port", "465");    
//          props.put("mail.smtp.socketFactory.class",    
//                    "javax.net.ssl.SSLSocketFactory");    
//          props.put("mail.smtp.auth", "true");    
//          props.put("mail.smtp.port", "465");
//    }
    
    
    
//    public static void send(final String from,final String password,String to,String sub,String msg){  
//          //get Session   
//          Session session = Session.getDefaultInstance(props,    
//           new javax.mail.Authenticator() {    
//           protected PasswordAuthentication getPasswordAuthentication() {    
//           return new PasswordAuthentication(from,password);  
//           }    
//          });    
//          //compose message    
//          try {    
//           MimeMessage message = new MimeMessage(session);    
//           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
//           message.setSubject(sub);    
//           message.setText(msg);    
//           //send message  
//           Transport.send(message);    
//           System.out.println("message sent successfully");    
//          } catch (MessagingException e) {throw new RuntimeException(e);}    
//             
//    } 
//    
    
    
    
}
