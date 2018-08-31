package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pojo.Users;
//二级缓存测试类
public class Test {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Users users = (Users) session.get(Users.class, 1);
		System.out.println(users.getPhone());
		session.close();
		Session session1 = sessionFactory.openSession();
		Users users1 = (Users) session1.get(Users.class, 1);
		System.out.println(users1.getPhone());
	}
}
