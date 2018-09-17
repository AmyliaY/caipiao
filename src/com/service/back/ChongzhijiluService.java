package com.service.back;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DingdanDAO;
import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.dao.UserschongzhijiluDAO;
import com.pojo.Dingdan;
import com.pojo.Users;
import com.pojo.Userschongzhijilu;
import com.util.JsonFilter;
import com.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Service
public class ChongzhijiluService {
	
	@Autowired
	private UserschongzhijiluDAO userschongzhijiluDAO;
	@Autowired 
	private HqlDAO dao;
	@Autowired
	private DingdanDAO dingdandao;
	@Autowired
	private UsersDAO usersDAO;
	
	public Map chongzhilisting(int page, int size, String mintime, String maxtime, String id) {
		if(page<1)
			page=1;
		List list1 = new ArrayList();
		StringBuffer buffer = new StringBuffer();
		if(StringUtil.isNotNull(id)&&id.trim().length()>0)
		{
			buffer.append(
				" and id = ?");
			list1.add(new Integer(id));
		}
		if(StringUtil.isNotNull(mintime)&&mintime.trim().length()>0)
		{
			buffer.append(" and time >= ?");
			list1.add(Timestamp.valueOf(mintime+" 00:00:00"));
		}
		if(StringUtil.isNotNull(maxtime)&&maxtime.trim().length()>0)
		{
			buffer.append(" and time <= ?");
			list1.add(Timestamp.valueOf(maxtime +" 23:59:59"));
		}
		String hql1 = "select count(*) from Userschongzhijilu where 1=1";
		int sum = (int) dao.unique(hql1+buffer.toString(),list1.toArray());
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		
		Map map = new HashMap();
		String hql ="from Userschongzhijilu where 1=1";
		List list = dao.pageQuery(hql+buffer.toString(),size,page,list1.toArray());
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		map.put("page",page);
		map.put("size", size);
		map.put("list", list);
		return map;
	}
	
	public void delete(String c) {
		// TODO Auto-generated method stub
		String hql = "delete from Userschongzhijilu where id in ("+c+")";
		dao.bulkUpdate(hql);
	}
	
	public Userschongzhijilu chongzhijilu_bianji(String id) {
		// TODO Auto-generated method stub
		Userschongzhijilu userschongzhijilu = userschongzhijiluDAO.findById(new Integer(id));
		return userschongzhijilu;
	}
	
	public String getdingdanid() {
		// TODO Auto-generated method stub
		List list = dingdandao.findAll();
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list,config).toString();
		return json;
	}
	
	public void bianji(String id ,String time, String phone, String money, String type, String status, String dingdanid) {
		// TODO Auto-generated method stub
		Userschongzhijilu userschongzhijilu = new Userschongzhijilu();
		userschongzhijilu.setId(new Integer(id));
		userschongzhijilu.setTime(Timestamp.valueOf(time));
		Users users = (Users) usersDAO.findByProperty("phone",phone).get(0);
		userschongzhijilu.setUsers(users);
		userschongzhijilu.setMoney(new Double(money));
		userschongzhijilu.setType(new Integer(type));
		userschongzhijilu.setStatus(new Integer(status));
		Dingdan dingdan = dingdandao.findById(dingdanid);
		userschongzhijiluDAO.merge(userschongzhijilu);
	}
	
}
