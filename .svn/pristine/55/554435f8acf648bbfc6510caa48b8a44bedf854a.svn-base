package com.service.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.pojo.Users;
import com.util.JsonFilter;
import com.util.StringUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 
 * @author marisheng
 * 财务管理业务层
 */
@Service
public class UsersCaiWuService {
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private HqlDAO dao;
	public Map userscaiwu(int page, int size) {
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
	public List usercaiwu_bianji(String id) {
		// TODO Auto-generated method stub
		List list = usersDAO.findAll();
		return list;
	}
	public void tijiao(String id, String usersname,String phone, String touxiang, String jifen, String dongjie, String yitixian) {
		// TODO Auto-generated method stub
		Integer id1=null;
		Double jifen1 = null;
		Double dongjie1 = null;
		Double yitixian1 = null;
		if(StringUtil.isNotNull(id)&&id.trim().length()>0)
		{
			id1 = new Integer(id);
		}
		if(StringUtil.isNotNull(jifen)&&jifen.trim().length()>0)
		{
			jifen1 = new Double(jifen);
		}
		if(StringUtil.isNotNull(dongjie)&&dongjie.trim().length()>0)
		{
			dongjie1 = new Double(dongjie);
		}
		if(StringUtil.isNotNull(yitixian)&&yitixian.trim().length()>0)
		{
			yitixian1 = new Double(yitixian);
		}
		Users users = usersDAO.findById(id1);
		users.setId(id1);
		users.setName(usersname);
		users.setJifen(jifen1);
		users.setDongji(dongjie1);
		users.setYitixian(yitixian1);
		//users是持久态，事务提交后自动保存它的更改,并修改与它关联的数据库
		//所以此处不需merge
		//usersDAO.merge(users);
	}
	public String bianji_json(String id) {
		// TODO Auto-generated method stub
		Integer id1=null;
		if(StringUtil.isNotNull(id)&&id.trim().length()>0)
		{
			id1 = new Integer(id);
		}
		Users users = usersDAO.findById(id1);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONObject.fromObject(users,config).toString();
		return json;
	}
	

}
