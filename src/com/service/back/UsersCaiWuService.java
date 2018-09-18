package com.service.back;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CaipiaodianDAO;
import com.dao.DingdanDAO;
import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.dao.UserschongzhijiluDAO;
import com.pojo.Caipiaodian;
import com.pojo.Dingdan;
import com.pojo.Users;
import com.pojo.Userschongzhijilu;
import com.util.JsonFilter;
import com.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * @author marisheng 财务管理业务层
 */
@Service
public class UsersCaiWuService {
	
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private HqlDAO dao;
	@Autowired
	private UserschongzhijiluDAO userschongzhijiluDAO;
	@Autowired
	private DingdanDAO dingdanDAO;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;
	
	public Map userscaiwu(int page, int size) {
		// TODO Auto-generated method stub
		String hql1 = "select count(*) from Users";
		int sum = (int) dao.unique(hql1);
		if (page < 1)
			page = 1;
		int pagecount = sum % size == 0 ? sum / size : sum / size + 1;
		if (page > pagecount)
			page = pagecount;
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

	public void tijiao(String id, String usersname, String phone, String touxiang, String jifen, String dongjie,
			String yitixian) {
		// TODO Auto-generated method stub
		Integer id1 = null;
		Double jifen1 = null;
		Double dongjie1 = null;
		Double yitixian1 = null;
		if (StringUtil.isNotNull(id) && id.trim().length() > 0) {
			id1 = new Integer(id);
		}
		if (StringUtil.isNotNull(jifen) && jifen.trim().length() > 0) {
			jifen1 = new Double(jifen);
		}
		if (StringUtil.isNotNull(dongjie) && dongjie.trim().length() > 0) {
			dongjie1 = new Double(dongjie);
		}
		if (StringUtil.isNotNull(yitixian) && yitixian.trim().length() > 0) {
			yitixian1 = new Double(yitixian);
		}
		Users users = usersDAO.findById(id1);
		users.setId(id1);
		users.setName(usersname);
		users.setJifen(jifen1);
		users.setDongji(dongjie1);
		users.setYitixian(yitixian1);
		usersDAO.merge(users);
	}

	public String bianji_json(String id) {
		// TODO Auto-generated method stub
		Integer id1 = null;
		if (StringUtil.isNotNull(id) && id.trim().length() > 0) {
			id1 = new Integer(id);
		}
		Users users = usersDAO.findById(id1);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONObject.fromObject(users, config).toString();
		return json;
	}

	public Map userschongzhi(int page, int size) {
		// TODO Auto-generated method stub
		String hql1 = "select count(*) from Userschongzhijilu where status = 1";
		int sum = (int) dao.unique(hql1);
		if (page < 1)
			page = 1;
		int pagecount = sum % size == 0 ? sum / size : sum / size + 1;
		if (page > pagecount)
			page = pagecount;
		String hql = "from Userschongzhijilu where status = 1";
		List list = dao.pageQuery(hql, size, page);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}

	public Userschongzhijilu chongzhibianji(String id) {
		// TODO Auto-generated method stub
		Integer id1 = null;
		if (StringUtil.isNotNull(id) && id.trim().length() > 0) {

			id1 = new Integer(id);
		}
		Userschongzhijilu userschongzhijilu = userschongzhijiluDAO.findById(id1);
		return userschongzhijilu;
	}

	public String usersjson() {
		// TODO Auto-generated method stub
		List list = usersDAO.findAll();
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list, config).toString();
		return json;
	}

	public void chongZhiTiJiao(String id, String phone, String money, String time, String type) {
		// TODO Auto-generated method stub
		Integer phone1 = null;
		Integer id1 = null;
		Double money1 = null;
		Timestamp time2 = null;
		Integer type2 = null;
		if (StringUtil.isNotNull(phone) && phone.trim().length() > 0) {
			phone1 = new Integer(phone);
		}
		if (StringUtil.isNotNull(id) && id.trim().length() > 0) {
			id1 = new Integer(id);
		}
		if (StringUtil.isNotNull(money) && money.trim().length() > 0) {
			money1 = new Double(money);
		}
		if (StringUtil.isNotNull(time) && time.trim().length() > 0) {
			time2 = Timestamp.valueOf(time);
		}
		if (StringUtil.isNotNull(type) && type.trim().length() > 0) {
			type2 = new Integer(type);
		}
		Userschongzhijilu userschongzhijilu = userschongzhijiluDAO.findById(id1);
		Users users = usersDAO.findById(phone1);
		userschongzhijilu.setUsers(users);
		userschongzhijilu.setMoney(money1);
		userschongzhijilu.setTime(time2);
		userschongzhijilu.setType(type2);
		userschongzhijiluDAO.merge(userschongzhijilu);
	}

	public Map usersxiaofei(int page, int size) {
		// TODO Auto-generated method stub
		String hql1 = "select count(*) from Dingdan where status >= 1";
		int sum = (int) dao.unique(hql1);
		if (page < 1)
			page = 1;
		int pagecount = sum % size == 0 ? sum / size : sum / size + 1;
		if (page > pagecount)
			page = pagecount;
		String hql = "from Dingdan where status >= 1";
		List list = dao.pageQuery(hql, size, page);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}

	public Dingdan usersxiaofei_bianji(String id) {
		// TODO Auto-generated method stub
		Dingdan dingdan = dingdanDAO.findById(id);
		return dingdan;
	}

	public void tijiao(String id, String phone, String num, String money) {
		// TODO Auto-generated method stub
		Dingdan dingdan = dingdanDAO.findById(id);
		Users users = usersDAO.findById(Integer.valueOf(phone));
		dingdan.setUsers(users);
		dingdan.setNum(Integer.valueOf(num));
		dingdan.setMoney(Double.valueOf(money));
		dingdanDAO.merge(dingdan);
	}

	public Map storescaiwu(int page, int size) {
		// TODO Auto-generated method stub
		String hql1 = "select count(*) from Caipiaodian";
		int sum = (int) dao.unique(hql1);
		if (page < 1)
			page = 1;
		int pagecount = sum % size == 0 ? sum / size : sum / size + 1;
		if (page > pagecount)
			page = pagecount;
		String hql = "from Caipiaodian";
		List list = dao.pageQuery(hql, size, page);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}

	public Caipiaodian storescaiwu_bianji(String id) {
		// TODO Auto-generated method stub
		Caipiaodian caipiaodian = caipiaodianDAO.findById(Integer.valueOf(id));
		return caipiaodian;
	}

	public void storescaiwutijiao(String id, String phone, String ketixian, String dongji, String yitixian) {
		// TODO Auto-generated method stub
		Caipiaodian caipiaodian = caipiaodianDAO.findById(Integer.valueOf(id));
		caipiaodian.setPhone(phone);
		caipiaodian.setKetixian(Double.valueOf(ketixian));
		caipiaodian.setDongjie(Double.valueOf(dongji));
		caipiaodian.setYitixian(Double.valueOf(yitixian));
		caipiaodianDAO.merge(caipiaodian);
	}
}
