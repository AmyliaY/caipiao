package com.service.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminDAO;
import com.dao.HqlDAO;
import com.pojo.Admin;

@Service
public class AdminListingService {
	
	@Autowired
	private AdminDAO admindao;
	@Autowired
	private HqlDAO dao;
	
	public Map adminlisting(int page, int size)
	{
		if(page<1)
			page=1;
		String hql1 = "select count(*) from Admin";
		int sum = (int) dao.unique(hql1);
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		
		Map map = new HashMap();
		String hql ="from Admin";
		List list = dao.pageQuery(hql, size, page);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		map.put("page",page);
		map.put("size", size);
		map.put("list", list);
		return map;
	}
	
	public void addadmin(String name, String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setName(name);
		admin.setUsername(username);
		admin.setPassword(password);
		admindao.save(admin);
		
	}
	
	public void editpwd(String id) {
		// TODO Auto-generated method stub
		Admin admin = admindao.findById(new Integer(id));
		admin.setPassword("5A54707451EEDFAFA37FD41532DF6CF7");
		admindao.merge(admin);
	}
}
