package phdhtl.cntt.common;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import phdhtl.cntt.domain.Email;

public class EmailUtils {
	public static void send(Email email) throws Exception {
		Properties properties = new Properties(); // tạo đối tượng properties
		
		// cấu hình thông số để kết nối server mail
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.prot", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		// tạo đối tượng Session
		// cài đặt tài khoản và mật khẩu gmail để đăng nhập vào server gmail để gửi mail
		Session session = Session.getDefaultInstance(properties,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication () {
				return new PasswordAuthentication(email.getFromAddress(), email.getFromAddressPassword());
			}
		
		});
		
		try {
			
			Message message = new MimeMessage(session); // khởi tạo đối tượng mesage nội dụng mail
			message.setFrom(new InternetAddress(email.getFromAddress())); // thiết lập tài khoản người gửi
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToAddress())); // danh sách người nhận
			message.setSubject(email.getSubject()); // tiêu đề
			message.setContent(email.getContent(),"text/html; charset=utf-8");
			
			Transport.send(message); // tránsport để gửi message
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}
