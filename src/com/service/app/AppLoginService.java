package com.service.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.pojo.Appversion;
import com.pojo.Users;

@Service
public class AppLoginService {
	
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private UsersDAO usersdao;
	
	public Users applogin(String username, String userpwd) {
		//System.out.println(username);
		//System.out.println(userpwd);
		String hql="from Users where phone=? and password=?";
		List list=hqlDAO.query(hql, username,userpwd);
		//System.out.println(list);
		if(list.size()>0){
			Users users=(Users) list.get(0);
			return users;
		}
		return null;
	}
	
	//查出下载地址
	public List<Appversion> getUrl(){
		List<Appversion> appversions = new ArrayList<Appversion>();
		//查出安卓最后一个
		String hql = "from Appversion t where t.avtype=?";
		//TAppversion appversion = (TAppversion) hqldao.findByHQL(hql,0);
		List<Appversion> l1 = hqlDAO.findByHQL(hql, 0);
		if(l1.size()>0){
			appversions.add(l1.get(0));
		}
		List<Appversion> l2 = hqlDAO.findByHQL(hql, 1);
		if(l2.size()>0){
			appversions.add(l2.get(0));
		}
		return appversions;
	}

	public boolean uploadHeadimg(int id, String touxiang) {
		Users users=usersdao.findById(id);
		if(users!=null){
			users.setTouxiang("/admin/images/tx/"+touxiang);
			System.out.println(users.getTouxiang());
			usersdao.save(users);
			return true;
		}
		return false;
	}
}
