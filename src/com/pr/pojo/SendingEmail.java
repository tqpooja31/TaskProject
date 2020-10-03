package com.pr.pojo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {

	public static boolean MailSent(String recvMail, int random_int) {

		String senderEmailId = "kolapepooja95@gmail.com";
		String senderPass = "kolape123";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmailId, senderPass);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recvMail));
			message.setSubject("Email Verification");
			message.setText("Email Verification OTP is - "+random_int);
			// send message
			Transport.send(message);
			System.out.println("Email Sent Successfully");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
			// throw new RuntimeException(e);
		}

	}

}
