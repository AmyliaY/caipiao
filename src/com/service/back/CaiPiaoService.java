package com.service.back;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.ShuangseqiuKjggDAO;
import com.pojo.ShuangseqiuKjgg;

@Service
public class CaiPiaoService {
	
	@Autowired
	private HqlDAO hqldao;
	@Autowired
	private ShuangseqiuKjggDAO shuangseqiuqishuDAO;
	
	public Map getAllkaijiang(String kjQishu, Timestamp mintime, Timestamp maxtime) {
		StringBuffer sb = new StringBuffer();
		List listparam = new ArrayList();
		sb.append(" where 1=1 ");
		if (kjQishu != null && kjQishu.trim().length() > 0) {
			sb.append("and time like ?");
			listparam.add("%" + kjQishu + "%");
		}
		if (mintime != null) {
			sb.append("and time>=?");
			listparam.add(mintime);
		}
		if (maxtime != null) {
			sb.append(" and time<=?");
			listparam.add(maxtime);
		}
		String sumHQL = "select count(*) from ShuangseqiuKjgg" + sb.toString();
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

		String hql = "from ShuangseqiuKjgg" + sb.toString() + " order by id desc";
		List list = hqldao.query(hql, listparam.toArray());

		Map map = new HashMap();
		// map.put("size", size);
		// map.put("page", page);
		// map.put("count", count);
		map.put("sum", sum);
		map.put("list", list);
		return map;
	}

	public List getMaxQishu() {
		String hql = "select max(s.qihao) from ShuangseqiuKjgg s";
		List list = hqldao.query(hql);
		return list;
	}
	
	public void updateKaiJiang(String blue, String oneRed, String twoRed, String threeRed, String fourRed,
			String fiveRed, String sixRed, String qishu) {
		// TODO Auto-generated method stub
		ShuangseqiuKjgg shuangseqiuqishu = new ShuangseqiuKjgg();
		shuangseqiuqishu.setQihao(qishu);
		shuangseqiuqishu.setHongqiu1(oneRed);
		shuangseqiuqishu.setHongqiu2(twoRed);
		shuangseqiuqishu.setHongqiu3(threeRed);
		shuangseqiuqishu.setHongqiu4(fourRed);
		shuangseqiuqishu.setHongqiu5(fiveRed);
		shuangseqiuqishu.setHongqiu6(sixRed);
		shuangseqiuqishu.setLanqiu(blue);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		shuangseqiuqishu.setKaijiangTime(timestamp);
		shuangseqiuqishuDAO.merge(shuangseqiuqishu);
	}

	public void delete(String kjId) {
		// TODO Auto-generated method stub
		String hql = "delete from ShuangseqiuKjgg where id in ("+kjId+")";
		hqldao.bulkUpdate(hql);
	}

	public List getKaiJiangById(int id) {
		String hql = "from ShuangseqiuKjgg where id = ?";
		List list=hqldao.findByHQL(hql, id);
		return list;
	}

	public void updateKaiJiang1(ShuangseqiuKjgg shuangseqiuqishu) {
		// TODO Auto-generated method stub
		shuangseqiuqishuDAO.merge(shuangseqiuqishu);
	}
}
