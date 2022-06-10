package com.zrl.d605;

import com.mysql.cj.jdbc.interceptors.SessionAssociationInterceptor;
import com.zrl.d530.zrlDao;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileReader;
import java.util.Properties;


public class javaMailTest {
	private static String USER_NAME;
	private static String PASSWORD;

	static {
		FileReader fr = null;
		Properties pro = null;
		try {
			String filename = "D:\\javacode\\jcd\\out\\production\\jcd\\com\\zrl\\d530\\Dao.properties";
			System.out.println(filename);
			fr = new FileReader(filename);
			pro = new Properties();
			pro.load(fr);
			USER_NAME = pro.getProperty("zrlMailAddr");
			PASSWORD = pro.getProperty("zrlMailPass");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {

		}
	}


	public static void sentMail(String to,String Title,String Text) {

		String host = "smtp.office365.com";
		String mailStoreType = "smtp";
		String popPort = "587";

		final Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.store.protocol", mailStoreType);
		props.put("mail.smtp.port", popPort);
		//开启SSL
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.port", popPort);
		props.put("mail.smtp.socketFactory.fallback", "false");

		try {
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USER_NAME, PASSWORD);
				}
			});

			session.setDebug(true);

			MimeMessage message = new MimeMessage(session);
			InternetAddress from = new InternetAddress(USER_NAME);
			message.setFrom(from);
			InternetAddress toAdd = new InternetAddress(to);
			message.setRecipients(Message.RecipientType.TO, String.valueOf(toAdd));

			message.setSubject(Title);
			message.setText(Text);

			Transport.send(message);
			System.out.println("发送完毕....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
