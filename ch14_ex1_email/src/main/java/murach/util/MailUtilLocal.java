/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.util;

import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author ASUS
 */
public class MailUtilLocal {
    public static void sendMail (String to, String from, String subject, String body,
            boolean bodyIsHTML)throws MessagingException 
    {
        // 1 - get a mail session
        Properties props = new Properties();
        props.put ("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", 25);
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        //2 - create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if(bodyIsHTML)
                message.setContent(body, "text/html");
        else
                message.setText(body);
        
        //3 - address the message
        Address fromAddress = new InternetAddress (from);
        Address toAddress = new InternetAddress (to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        //4 send the message
        Transport.send(message);
    }
}
