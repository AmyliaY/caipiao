package com.service.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.pojo.Admin;
import com.util.MD5Util;

@Service
public class AdminloginService {
	
	@Autowired
	private HqlDAO hqlDAO;
	
	public static void main(String[] args) {
		String pwd = MD5Util.getMD5(MD5Util.getMD5("sunjob"+"123456"));
		System.out.println(pwd);
		
	}
	
	public Admin login(String username, String password) {
		String hql="from Admin where username=? and password=?";
		String pwd =MD5Util.getMD5(MD5Util.getMD5("sunjob"+password));
		System.out.println("PWD:"+pwd);
		System.out.println(MD5Util.jiemi("http:127.0.0.1:8080/caipiao-web/admin/login.jsp", pwd));
		List<Admin> list=hqlDAO.pageQuery(hql,1,1, username,pwd);
		if(list.size()>0)
			return list.get(0);
		return null;
	}
}
