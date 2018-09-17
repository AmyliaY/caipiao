package com.service.back;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AreaDAO;
import com.dao.CaipiaoLeixingDAO;
import com.dao.CaipiaobiaoDAO;
import com.dao.CaipiaobiaoDescDAO;
import com.dao.CaipiaodianDAO;
import com.dao.CaipiaodianshenqingDAO;
import com.dao.CityDAO;
import com.dao.HqlDAO;
import com.dao.ProviceDAO;
import com.pojo.Area;
import com.pojo.CaipiaoLeixing;
import com.pojo.Caipiaobiao;
import com.pojo.CaipiaobiaoDesc;
import com.pojo.Caipiaodian;
import com.pojo.Caipiaodianshenqing;
import com.pojo.Provice;
import com.util.StringUtil;

@Service
public class CaiPiaoDianShenHe {
	
	@Autowired
	private HqlDAO dao;
	@Autowired
	private CaipiaodianshenqingDAO caipiaodianshenqingDAO;
	@Autowired
	private CaipiaodianDAO caipiaodiandao;
	@Autowired
	private ProviceDAO proviceDAO;
	@Autowired
	private CityDAO cityDAO;
	@Autowired
	private AreaDAO areaDAO;
	@Autowired
	private CaipiaoLeixingDAO caipiaoLeixingDAO;
	@Autowired
	private CaipiaobiaoDAO caipiaobiaoDAO;
	@Autowired
	private CaipiaobiaoDescDAO caipiaobiaoDescDAO;
	
	public Map shenhelisting(int page, int size) {
		// TODO Auto-generated method stub
		String hql1="select count(*) from Caipiaodianshenqing where zhuangtai=0";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from Caipiaodianshenqing where zhuangtai=0";
		List list = dao.pageQuery(hql, size, page);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}
	
	public void shenheupdate(String zhuangtai, String id) {
		// TODO Auto-generated method stub
		System.out.println(zhuangtai);
		Integer id1 = new Integer(id);
		Integer zhuangtai1 = new Integer(zhuangtai);
		Caipiaodianshenqing caipiaodianshenqing = caipiaodianshenqingDAO.findById(id1);
		caipiaodianshenqing.setZhuangtai(zhuangtai1);
		caipiaodianshenqingDAO.merge(caipiaodianshenqing);
		Caipiaodian caipiaodian = new Caipiaodian();
		caipiaodian.setArea(caipiaodianshenqing.getArea());
		caipiaodian.setAddress(caipiaodianshenqing.getXiangxidizhi());
		caipiaodian.setPhone(caipiaodianshenqing.getShoujihao());
		caipiaodian.setPassword(caipiaodianshenqing.getMima());
		caipiaodian.setJingdu(caipiaodianshenqing.getJingdu());
		caipiaodian.setWeidu(caipiaodianshenqing.getWeidu());
		
		caipiaodian.setTime(new Timestamp(new Date().getTime()));
		if(caipiaodianshenqing.getIsfucai()==true)
		caipiaodian.setIsfucai(1);
		if(caipiaodianshenqing.getIsfucai()==false)
			caipiaodian.setIsfucai(0);
		if(caipiaodianshenqing.getIsticai()==true)
		caipiaodian.setIsticai(1);
		if(caipiaodianshenqing.getIsticai()==false)
			caipiaodian.setIsticai(0);
		caipiaodiandao.save(caipiaodian);
	}
	
	public Map shenhelistingjvjue(int page, int size) {
		String hql1="select count(*) from Caipiaodianshenqing where zhuangtai=2";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from Caipiaodianshenqing where zhuangtai=2";
		List list = dao.pageQuery(hql, size, page);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}
	
	public void shenhejvjue(String zhuangtai, String id, String liyou) {
		// TODO Auto-generated method stub
		System.out.println(zhuangtai);
		Integer id1 = new Integer(id);
		Integer zhuangtai1 = new Integer(zhuangtai);
		Caipiaodianshenqing caipiaodianshenqing = caipiaodianshenqingDAO.findById(id1);
		caipiaodianshenqing.setZhuangtai(zhuangtai1);
		caipiaodianshenqing.setJujueliyou(liyou);
		caipiaodianshenqingDAO.merge(caipiaodianshenqing);
		
	}
	
	public Map findcaipiaodianlisting(int page, int size) {
		// TODO Auto-generated method stub
		String hql1="select count(*) from Caipiaodian where isticai=0 and isfucai=0";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from Caipiaodian where isticai=0 and isfucai=0";
		List list = dao.pageQuery(hql, size, page);
		List list1 = new ArrayList();
		list1.add(page);
		list1.add(size);
		list1.add(sum);
		list1.add(pagecount);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("list1", list1);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}
	
	public Caipiaodian dianlisting(String id) {
		// TODO Auto-generated method stub
		Integer id1 = new Integer(id);
		Caipiaodian caipiaodian = caipiaodiandao.findById(id1);
		return caipiaodian;
	}
	
	public List arealisting() {
		// TODO Auto-generated method stub
		List list = proviceDAO.findAll();
		return list;
	}
	
	public List citylisting(String id) {
		// TODO Auto-generated method stub
		Integer id1 = new Integer(id);
		List list =cityDAO.findByProperty("provice.prId", id1);
		return list;
	}
	
	public List qulisting(String id) {
		// TODO Auto-generated method stub
		Integer id1 = new Integer(id);
		List list = areaDAO.findByProperty("city.ctId", id1);
		return list;
	}
	
	public void dianlistingupdate(String id, String shoujihao, String password, String stores, String qu,
			String address, String jingdu, String weidu, String isfucai, String isticai, String tixian, String begintime, String endtime, String time) {
		// TODO Auto-generated method stub
		Integer id1 = new Integer(id);
		Integer qu1 = new Integer(qu);
		Double jingdu1 = new Double(jingdu);
		Double weidu1 = new Double(weidu);
		Integer isfucai1 = new Integer(isfucai);
		Integer isticai1 = new Integer(isticai);
		Double tixian1 = null;
		if(StringUtil.isNotNull(tixian)&&tixian.trim().length()>0)
		tixian1 = new Double(tixian);
		Caipiaodian caipiaodian = caipiaodiandao.findById(id1);
		caipiaodian.setAddress(address);
		caipiaodian.setPhone(shoujihao);
		caipiaodian.setPassword(password);
		caipiaodian.setName(stores);
		Area area = areaDAO.findById(qu1);
		caipiaodian.setArea(area);
		caipiaodian.setJingdu(jingdu1);
		caipiaodian.setWeidu(weidu1);
		caipiaodian.setIsfucai(isfucai1);
		caipiaodian.setIsticai(isticai1);
		caipiaodian.setKetixian(tixian1);
		System.out.println(begintime);
		System.out.println(endtime);
		caipiaodian.setBegingtime(begintime);
		caipiaodian.setEndtime(endtime);
		caipiaodian.setTime(Timestamp.valueOf(time));
		caipiaodiandao.merge(caipiaodian);
	}
	
	public Map caipiaolisting(int page, int size) {
		// TODO Auto-generated method stub
		String hql1="select count(*) from Caipiaobiao";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from Caipiaobiao";
		List<Caipiaobiao> list = dao.pageQuery(hql, size, page);
		for (Caipiaobiao caipiaobiao : list) {
			Set<CaipiaobiaoDesc> set = caipiaobiao.getCaipiaobiaoDescs();
			for (CaipiaobiaoDesc caipiaobiaoDesc : set) {
				System.out.println(caipiaobiaoDesc.getName());
			}
		}
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}
	
	public Map caipiao_leixinglisting(int page, int size) {
		// TODO Auto-generated method stub
		String hql1="select count(*) from CaipiaoLeixing";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from CaipiaoLeixing";
		List list = dao.pageQuery(hql, size, page);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}
	
	public void caipiao_leixing_add(String caipiao_leixing, String status) {
		// TODO Auto-generated method stub
		System.out.println(status);
		Integer status1 = new Integer(status);
		CaipiaoLeixing caipiaoLeixing = new CaipiaoLeixing();
		caipiaoLeixing.setMingcheng(caipiao_leixing);
		caipiaoLeixing.setStatus(status1);
		caipiaoLeixingDAO.save(caipiaoLeixing);
	}
	
	public CaipiaoLeixing caipiaoleixinglistingjson(String id) {
		// TODO Auto-generated method stub
		Integer id1 = new Integer(id);
		CaipiaoLeixing caipiaoleixing = caipiaoLeixingDAO.findById(id1);
		return caipiaoleixing;
	}
	
	public void addcaipiaolisting(String name, String type, String price, String begintime, String endtime,
			String status, String kaijiangtime, String jiangchi) {
		// TODO Auto-generated method stub
		Integer status1 = new Integer(status);
		Double price1 = new Double(price);
		Double jiangchi1 = new Double(jiangchi);
		Caipiaobiao caipiaobiao = new Caipiaobiao();
		caipiaobiao.setName(name);
		CaipiaoLeixing caipiaoLeixing = (CaipiaoLeixing) caipiaoLeixingDAO.findByProperty("mingcheng", type).get(0);
		caipiaobiao.setCaipiaoLeixing(caipiaoLeixing);
		caipiaobiao.setStatus(status1);
		caipiaobiaoDAO.save(caipiaobiao);
	}
	
	public void caipiao_leixing_bianji(String id,String caipiao_leixing, String status ) {
		// TODO Auto-generated method stub
		Integer id1 = new Integer(id);
		CaipiaoLeixing caipiaoLeixing = caipiaoLeixingDAO.findById(id1);
		caipiaoLeixing.setMingcheng(caipiao_leixing);
		caipiaoLeixing.setStatus(new Integer(status));
		caipiaoLeixingDAO.merge(caipiaoLeixing);
	}
	
	public List caipiaobiaofindall() {
		// TODO Auto-generated method stub
		List list = caipiaoLeixingDAO.findAll();
		return list;
	}
	
	public CaipiaobiaoDesc caiopiao_biji_data(String id) {
		// TODO Auto-generated method stub
		CaipiaobiaoDesc caipiaobiaoDesc = caipiaobiaoDescDAO.findById(new Integer(id));
		return caipiaobiaoDesc;
	}
	
	public void caipiao_biji_insert(String id,String name, String type, String type2,String price, String begintime, String endtime,
			String status, String kaijiangtime, String jiangchi) {
		// TODO Auto-generated method stub
		CaipiaobiaoDesc caipiaobiaoDescs = caipiaobiaoDescDAO.findById(Integer.valueOf(id));
		caipiaobiaoDescs.setName(name);
		//caipiaobiaoDescs.setCaipiaobiao(caipiaobiao);
		if(StringUtil.isNotNull(begintime) && begintime.trim().length()>0)
		caipiaobiaoDescs.setBegintime(Timestamp.valueOf(begintime));
		if(StringUtil.isNotNull(endtime) && endtime.trim().length()>0)
		caipiaobiaoDescs.setEndtime(Timestamp.valueOf(endtime));
		if(StringUtil.isNotNull(kaijiangtime) && kaijiangtime.trim().length()>0)
		caipiaobiaoDescs.setKaijiangtime(Timestamp.valueOf(kaijiangtime));
		if(StringUtil.isNotNull(jiangchi) && jiangchi.trim().length()>0)
		caipiaobiaoDescs.setJiangchi(Double.valueOf(jiangchi));
		if(StringUtil.isNotNull(price) && price.trim().length()>0)
			caipiaobiaoDescs.setJiangchi(Double.valueOf(price));
		//caipiaobiao.getCaipiaobiaoDescs().add(caipiaobiaoDescs);
		Integer status1 = new Integer(status);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.valueOf(type2));
		caipiaobiao.setStatus(status1);
		caipiaobiaoDescs.setCaipiaobiao(caipiaobiao);
		
		CaipiaoLeixing caipiaoLeixing = caipiaoLeixingDAO.findById(Integer.valueOf(type));
		caipiaobiao.setCaipiaoLeixing(caipiaoLeixing);
		
//		caipiaoLeixingDAO.merge(caipiaoLeixing);
//		caipiaobiaoDAO.merge(caipiaobiao);
		caipiaobiaoDescDAO.merge(caipiaobiaoDescs);
	}
	
	public Map findcaipiaodianlisting1(int page, int size)
	{
		String hql1="select count(*) from Caipiaodian where isticai =1";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from Caipiaodian where isticai =1";
		List<Caipiaodian> list = dao.pageQuery(hql, size, page);
		List list1 = new ArrayList();
		list1.add(page);
		list1.add(size);
		list1.add(sum);
		list1.add(pagecount);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		map.put("list1", list1);
		return map;
	}
	
	public Map findcaipiaodianlisting2(int page, int size) {
		String hql1="select count(*) from Caipiaodian where isfucai = 1";
		int sum = (int) dao.unique(hql1);
		if(page<1)
			page=1;
		int pagecount = sum%size==0 ? sum/size : sum/size+1;
		if(page>pagecount)
			page=pagecount;
		String hql = "from Caipiaodian where isfucai = 1";
		List<Caipiaodian> list = dao.pageQuery(hql, size, page);
		List list1 = new ArrayList();
		list1.add(page);
		list1.add(size);
		list1.add(sum);
		list1.add(pagecount);
		Map map = new HashMap();
		map.put("page", page);
		map.put("size", size);
		map.put("list", list);
		map.put("list1", list1);
		map.put("sum", sum);
		map.put("pagecount", pagecount);
		return map;
	}
	
	public List caipiaobiaofindall2() {
		// TODO Auto-generated method stub
		List list = caipiaobiaoDAO.findAll();
		return list;
	}
}
