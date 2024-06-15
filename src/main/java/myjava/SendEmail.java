package myjava;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import beans.EmailBean;

public class SendEmail {

	public String random() {
		Random rand = new Random();
		int number = rand.nextInt(999999);
		return String.format("%06d", number);
	}

	public boolean sendEmail(EmailBean user) {
		boolean test = false;

		String toEmail = user.getEmail();		String fromEmail="vijaychopra627@gmail.com";		String password="aunp wqnz ygsw tbev";
		
		

		try {
			Properties pr = new Properties();
			pr.put("mail.smtp.auth", "true");
			pr.put("mail.smtp.starttls.enable", "true");
			pr.put("mail.smtp.host", "smtp.gmail.com");
			pr.put("mail.smtp.port", "587");

			// session
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(fromEmail, password);
				}
			});

			Message mess = new MimeMessage(session);
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			mess.setSubject("User Email Verification ");
			mess.setText("Registrated Successfully. Please verify your account using this code  " + user.getCode());

			Transport.send(mess);
			test = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return test;
	}
}
