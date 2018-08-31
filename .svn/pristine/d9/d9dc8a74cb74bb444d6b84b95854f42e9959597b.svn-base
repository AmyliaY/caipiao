package com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 用于发送jmail邮件 关联java文件 SMTPAuthenticator.java
 * 
 * 
 */
public class JMail {

	/**
	 * 发送jmail
	 * 
	 * @param title
	 *            email标题
	 * @param content
	 *            Email内容
	 * @param hostSmtp
	 *            发件邮箱 smtp地址 如：smtp.163.com
	 * @param hostAddress
	 *            发送邮箱地址 如：myzhijie@163.com
	 * @param hostPwd
	 *            发送邮箱密码
	 * @param toAddress
	 *            接收邮箱地址 如：myzhijie@qq.com
	 */
	public boolean sendMail(String title, String content, String hostSmtp,
			String hostAddress, String hostPwd, String toAddress) {

		try {
			String mail = content;

			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.host", hostSmtp);
			mailProps.put("mail.smtp.auth", "true");

			SMTPAuthenticator smtpAuthenticator = new SMTPAuthenticator(
					hostAddress, hostPwd);
			Session mailSession = Session.getDefaultInstance(mailProps,
					smtpAuthenticator);
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(hostAddress));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					toAddress));
			message.setSubject(title);
			// //("准备发送邮件！！！");
			message.setText(mail, "utf-8", "html");

			/*
			 * MimeMultipart msgMultipart = new MimeMultipart("mixed");
			 * message.setContent(msgMultipart); MimeBodyPart content2 = new
			 * MimeBodyPart(); msgMultipart.addBodyPart(content2);
			 * //设置邮件内容格式为关联内容 MimeMultipart bodyMultipart = new
			 * MimeMultipart("related"); content2.setContent(bodyMultipart);
			 * MimeBodyPart htmlPart = new MimeBodyPart();
			 * bodyMultipart.addBodyPart(htmlPart);
			 */

			Transport transport = mailSession.getTransport("smtp");
			/*
			 * 以smtp方式登录邮箱,第一个参数是发送邮件用的邮件服务器SMTP地 址 第二个参数为用户名，第三个参数为密码
			 */
			transport.connect(hostSmtp, hostAddress, hostPwd);
			// 发送邮件，其中第二个参数是所有已设好的收件人地址
			transport.sendMessage(message, message.getAllRecipients());
			transport.close(); // 关闭与服务器的连接

			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		JMail aa = new JMail();
		boolean f = aa.sendMail("中午一起吃饭.", "内容http://www.gou13.com",
				"smtp.exmail.qq.com", "admin@gou13.com", "DIRcls1433",
				"3815228@qq.com");
		//(f);
	}
}
