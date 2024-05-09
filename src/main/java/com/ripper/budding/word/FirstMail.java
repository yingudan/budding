package com.ripper.budding.word;

/**
 * @author shandowF
 * @date 2017年11月10日
 */
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class FirstMail {

	/**
	 * 发送简单邮件方法
	 * 
	 * @param host
	 *            发送邮件服务器的IP
	 * @param from
	 *            发送人地址
	 * @param to
	 *            接收人地址
	 * @param subject
	 *            邮件主题
	 * @param text
	 *            内容
	 * @param senderUsername
	 *            发送人的账户
	 * @param senderPassword
	 *            发送人的密码 mail.smtp.auth 是否需要身份验证 一般都是需要的
	 */
	public static void sendMail(String host, String from, String to, String subject, String text,
			final String senderUsername, final String senderPassword) {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderUsername, senderPassword);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//kaixinjiuhao2018@qq.com
		String host = "smtp.qq.com";
		String from = "yingudan@vip.qq.com";
		String to = "2191316120@qq.com";
		String subject = "Hello, this is a test email.";
		String text = "测试";
		String senderUsername = "yingudan@vip.qq.com";
		String senderPassword = "lin520!@";
		FirstMail.sendMail(host, from, to, subject, text, senderUsername, senderPassword);
	}
}
