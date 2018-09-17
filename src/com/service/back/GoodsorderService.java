package com.service.back;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CaipiaodianDAO;
import com.dao.DingdanDAO;
import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.pojo.Caipiaodian;
import com.pojo.Dingdan;
import com.pojo.Users;
import com.util.JsonFilter;
import com.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Service
public class GoodsorderService {
	
	@Autowired
	private HqlDAO hqldao;
	@Autowired
	private DingdanDAO dao;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;
	@Autowired
	private UsersDAO usersDAO;
	
	public Map goodsorderlisting(String id,String mintime,String maxtime,String status) {
		StringBuffer sb = new StringBuffer();
		List listparam = new ArrayList();
		sb.append(" where 1=1 ");

		if (StringUtil.isNotNull(id) && id.trim().length() > 0) {
			sb.append(" and id like ?");
			listparam.add("%" + id + "%");
		}
		if (mintime != null&&mintime.trim().length()>0) {
			sb.append(" and time>=?");
			
			listparam.add(Timestamp.valueOf(mintime+" 00:00:00"));
		}
		if (maxtime != null&&maxtime.trim().length()>0) {
			sb.append(" and time<=?");
			listparam.add(Timestamp.valueOf(maxtime+" 23:59:59"));
		}
		if (StringUtil.isNotNull(status)&&status.trim().length()>0) {
			sb.append(" and status=?");
			listparam.add(new Integer(status));
		}
		String sumHQL = "select count(*) from Dingdan" + sb.toString();
		List sumList = hqldao.query(sumHQL, listparam.toArray());

		Object obj = sumList.get(0);
		int sum = Integer.parseInt(obj.toString());

		if (sum < 1)
			return new HashMap();

		// int count = sum%size==0 ? sum/size : sum/size+1;
		//
		// //越界检查
		// if(page<1) page=1;
		// if(page>count) page=count;

		String hql = "from Dingdan" + sb.toString() + " order by id desc";
		List list = hqldao.query(hql, listparam.toArray());

		Map map = new HashMap();
		// map.put("size", size);
		// map.put("page", page);
		// map.put("count", count);
		map.put("sum", sum);
		map.put("list", list);
		return map;
	}
	
	public void delete(String c) {
		// TODO Auto-generated method stub
		String hql = "delete from Dingdan where id in ("+c+")";
		hqldao.bulkUpdate(hql);
	}
	
	public Dingdan getgoodsorderById(String id) {
		// TODO Auto-generated method stub
		Dingdan dingdan = dao.findById(id);
		return dingdan;
	}
	
	public String getjiedancpdid() {
		// TODO Auto-generated method stub
		List list = caipiaodianDAO.findAll();
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list,config).toString();
		return json;
	}
	
	public void bianji(String id, String time, String phone, String money, String begintime, String endtime, String num,
			String status,
			String jiedancpd1, String jiedancpd2, String jiedancpd3, String jiedancpd4, String jiedancpd5,
			String shijizhongbiaocpd) {
		// TODO Auto-generated method stub
		Dingdan dingdan = new Dingdan();
		dingdan.setId(id);
		dingdan.setTime(Timestamp.valueOf(time));
		Users users = (Users) usersDAO.findByProperty("phone", phone).get(0);
		dingdan.setUsers(users);
		dingdan.setMoney(new Double(money));
		dingdan.setBegintime(Timestamp.valueOf(begintime));
		dingdan.setEndtime(Timestamp.valueOf(endtime));
		dingdan.setNum(new Integer(num));
		dingdan.setStatus(new Integer(status));
		Caipiaodian caipiaodian1 = caipiaodianDAO.findById(new Integer(jiedancpd1));
		Caipiaodian caipiaodian2 = caipiaodianDAO.findById(new Integer(jiedancpd2));
		Caipiaodian caipiaodian3 = caipiaodianDAO.findById(new Integer(jiedancpd3));
		Caipiaodian caipiaodian4 = caipiaodianDAO.findById(new Integer(jiedancpd4));
		Caipiaodian caipiaodian5 = caipiaodianDAO.findById(new Integer(jiedancpd5));
		Caipiaodian caipiaodian6 = caipiaodianDAO.findById(new Integer(shijizhongbiaocpd));
		dingdan.setCaipiaodianByCpzid1(caipiaodian1);
		dingdan.setCaipiaodianByCpzid2(caipiaodian2);
		dingdan.setCaipiaodianByCpzid3(caipiaodian3);
		dingdan.setCaipiaodianByCpzid4(caipiaodian4);
		dingdan.setCaipiaodianByCpzid5(caipiaodian5);
		dingdan.setCaipiaodianByCpzid(caipiaodian6);
		dao.merge(dingdan);
	}
}
