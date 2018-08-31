package com.util;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.oreilly.servlet.Base64Encoder;

public class SendEmail {
	private String host = "smtp.qq.com"; // smtp������
	private String user = ""; // �û���
	private String pwd = ""; // ����
	private String from = ""; // �����˵�ַ
	private String to = ""; // �ռ��˵�ַ
	private String subject = ""; // �ʼ�����
	private String fileName; // ��������
	private File file; // ����

	public void setAddress(String from,String user,String pwd, String to, String subject ,File file,String fileName) {
		this.from = from;
		this.user = user;
		this.pwd = pwd;
		this.to = to;
		this.subject = subject;
		this.file = file;
		this.fileName = fileName;
	}

	public void send(String txt) {
		Properties props = new Properties();
		// ���÷����ʼ����ʼ�����������ԣ�����ʹ�����׵�smtp������
		props.put("mail.qq.host", host);
		// ��Ҫ������Ȩ��Ҳ�����л���������У�飬�������ͨ����֤��һ��Ҫ����һ��
		props.put("mail.qq.auth", "true");
		// �øո����úõ�props���󹹽�һ��session
		Session session = Session.getDefaultInstance(props);
		// ������������ڷ����ʼ��Ĺ������console����ʾ�����Ϣ��������ʹ
		// �ã�������ڿ���̨��console)�Ͽ��������ʼ��Ĺ�̣�
		session.setDebug(true);
		// ��sessionΪ��������Ϣ����
		MimeMessage message = new MimeMessage(session);
		try {
			// ���ط����˵�ַ
			message.setFrom(new InternetAddress(from));
			// �����ռ��˵�ַ
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			// ���ر���
			message.setSubject(subject);
			// ��multipart����������ʼ��ĸ������ݣ���(�ı����ݺ͸���
			Multipart multipart = new MimeMultipart();

			// �����ʼ����ı�����
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setText(txt);
			multipart.addBodyPart(contentPart);

			// ��Ӹ���
			BodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(file);
			// ��Ӹ���������
			messageBodyPart.setDataHandler(new DataHandler(source));
			// ��Ӹ����ı���
			// �������Ҫ��ͨ�������Base64�����ת�����Ա�֤������ĸ����������ڷ���ʱ����������
			messageBodyPart.setFileName("=?GBK?B?"
					+ Base64Encoder.encode(fileName.getBytes()) + "?=");
			multipart.addBodyPart(messageBodyPart);

			// ��multipart����ŵ�message��
			message.setContent(multipart);
			// �����ʼ�
			message.saveChanges();
			// �����ʼ�
			Transport transport = session.getTransport("smtp");
			// l�ӷ����������
			transport.connect(host, user, pwd);
			// ���ʼ����ͳ�ȥ
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
