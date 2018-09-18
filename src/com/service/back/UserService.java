package com.service.back;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsersDAO;
import com.pojo.Users;
import com.util.StringUtil;
import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.pojo.Users;

@Service
public class UserService {
	
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private HqlDAO  dao;
	
	public List findByUsername(String name) {
		List list = usersDAO.findByName(name);
		return list;
	}
	


	public List findByMobile(String mobile) {
		System.out.println(mobile);

		List list = usersDAO.findByPhone(mobile);
		return list;
	}

	public void save(String mobile, String pwd, String name, String clientId) {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setPhone(mobile);
		users.setPassword(pwd);
		users.setName(name);
		users.setClientId(clientId);
		usersDAO.save(users);
	}

	public Map findall() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map findall(int page, int size) {
		// TODO Auto-generated method stub
		String hql1="select count(*) from Users";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from Users";
		List list = dao.pageQuery(hql, size, page);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}

	public Users findbyid(String id) {
		// TODO Auto-generated method stub
		Users users = usersDAO.findById(new Integer(id));
		
		return users;
	}

	public Users update(String id,String username, String phone, String pwd, String touxiang, String jifen, String dongjie,
			String yitixian,String bank, String zhanghao, String kaihuren, String tuijian, String shoucang, String time) {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setId(new Integer(id));
		users.setName(username);
		users.setPhone(phone);
		users.setPassword(pwd);
		users.setTouxiang(touxiang);
		users.setJifen(new Double(jifen));
		users.setDongji(new Double(dongjie));
		users.setYitixian(new Double(yitixian));
		users.setBank(bank);
		users.setZhanghao(zhanghao);
		users.setXingming(kaihuren);
		if(StringUtil.isNotNull(tuijian)&&tuijian.trim().length()>0)
		users.setTuijiandianpu(new Integer(tuijian));
		if(StringUtil.isNotNull(shoucang)&&shoucang.trim().length()>0)
		users.setShoucangdianpu(new Integer(shoucang));
		if(StringUtil.isNotNull(time)&&time.trim().length()>0)
		{
			users.setTime(Timestamp.valueOf(time));
		}
		else
		{
			users.setTime(null);
		}
		usersDAO.merge(users);
		return users;
	}
	
}
