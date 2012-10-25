package com.model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Activation {

	public static boolean sendActivationMail (String recepient, String activationmessage) {
		try{
			final String username = "harmishrulz@gmail.com";
			final String password = "@hrs30160187@";
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			Authenticator authenticator = new Authenticator() {
	        	protected PasswordAuthentication getPasswordAuthentication() {
	        		
	        		return new PasswordAuthentication(username, password);
	        	}
	        };
	        Session session = Session.getDefaultInstance(props, authenticator);
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
	        message.setSubject("SurpriseMe activation link");
	        message.setText(activationmessage);
	        
	        Transport.send(message);
	        return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
}
