package com.service.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AreaDAO;
import com.dao.CaipiaodianDAO;
import com.dao.CaipiaodianshenqingDAO;
import com.dao.CpztixianDAO;
import com.dao.HqlDAO;
import com.pojo.Appversion;
import com.pojo.Caipiandianyuangong;
import com.pojo.Caipiaodian;
import com.pojo.Caipiaodianshenqing;
import com.pojo.Collections;
import com.pojo.Cpzchongzhijilu;
import com.pojo.Cpztixian;
import com.pojo.Dingdan;
import com.pojo.Dingdanxiangqing;
import com.pojo.Users;
import com.pojo.Userschongzhijilu;
import com.pojo.Userstixian;
import com.util.JsonFilter;
import com.util.StringUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
* @author 全恒
*/
@Service
public class AppCaipiaodianCenterService {

	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;
	@Autowired
	private CaipiaodianshenqingDAO caipiaodianshenqingDAO;
	@Autowired
	private AreaDAO areaDAO;
	@Autowired
	private CpztixianDAO cpztixianDAO;
	
	/**
	 * 彩票店登陆
	 * 彩票站状态，-1未进行商户验证，0未审核，1审核通过，2审核未通过
	 * 登陆的判断标准：既可用彩票店的手机号和密码登陆，也可用员工的手机号和密码登陆
	 * 做一个标记放在json中，用来标记当前登陆者是店长还是店员
	 * @param username
	 * @param userpwd
	 * @return
	 */
	public Caipiaodian applogin(String username, String userpwd) {
		//用彩票店的手机号和密码登陆
		String hql="from Caipiaodian where status=1 and phone=? and password=?";
		List list=hqlDAO.pageQuery(hql, 1, 1, username,userpwd);
		if(list.size()>0){
			Caipiaodian caipiaodian=(Caipiaodian) list.get(0);
			return caipiaodian;
		}
		return null;
	}
	public ArrayList applogin2(String username, String userpwd) {
		//用员工的手机号和密码登陆
		String hql2 = "from Caipiandianyuangong where shoujihao=? and mima=?";
		List list2 = hqlDAO.pageQuery(hql2, 1, 1, username, userpwd);
		ArrayList arrayList = new ArrayList();
		if(list2.size() > 0){
			Caipiandianyuangong caipiandianyuangong = (Caipiandianyuangong)list2.get(0);
			//判断该员工所在的彩票店是否已关闭
			Caipiaodian caipiaodian = caipiandianyuangong.getCaipiaodian();
			if(caipiaodian.getStatus() == 1){
				arrayList.add(caipiaodian);
				arrayList.add(caipiandianyuangong);
				return arrayList;
			}
		}
		return null;
	}
	
	/**
	 * 进入业务管理页面
	 * 显示营业额和订单数
	 * @param caipiaodian
	 * @return
	 */
	public String gotoOperationManager(Caipiaodian caipiaodian, boolean flag) {//flag，用来标记登陆的用户是商家还是店员，true指商家，false指店员
		//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单，3订单完成
		//订单数,2商家已接单 和 3订单完成
		String hql = "select count(*) from Dingdan where (status=2 or status=3) and caipiaodianByCpzid.id=?";
		String sumOrder = (int)hqlDAO.unique(hql, caipiaodian.getId())+"";
		//营业额：根据该彩票店完成的订单来算，3订单完成
		String hql2 = "select count(money) from Dingdan where status=3 and caipiaodianByCpzid.id=?";
		String turnover = hqlDAO.unique(hql2, caipiaodian.getId())+"";
		Map map = new HashMap();
		if(flag){
			map.put("shenfen", "shangjia");
		} else {
			map.put("shenfen", "dianyuan");
		}
		map.put("sumOrder", sumOrder);
		map.put("turnover", turnover);
		map.put("id", caipiaodian.getId());
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 上传头像
	 * @param id
	 * @param touxiang
	 * @return
	 */
	public boolean uploadHeadimg(int id, String touxiang) {
		Caipiaodian caipiaodian = caipiaodianDAO.findById(id);
		if(caipiaodian != null){
			caipiaodian.setImgid("/admin/images/tx/"+touxiang);
			System.out.println(caipiaodian.getImgid());
			caipiaodianDAO.save(caipiaodian);
			return true;
		}
		return false;
	}

	/**
	 * 根据店铺昵称验证店铺昵称唯一性
	 * @param nickname
	 * @return
	 */
	public List findByCaipiaodianName(String nickname) {
		List<Caipiaodian> caipiaodian = caipiaodianDAO.findByName(nickname);
		return caipiaodian;
	}

	/**
	 * 根据手机号验证手机号唯一性
	 * @param mobile
	 * @return
	 */
	public List findByCaipiaodianMobile(String mobile) {
		List list = caipiaodianDAO.findByPhone(mobile);
		return list;
	}

	/**
	 * 完成初步注册
	 * 将Caipiaodianshenqing表status设置为-1
	 * @param nickname
	 * @param phone
	 * @param password
	 */
	public Caipiaodianshenqing register(String nickname, String phone, String password, String clientId) {
		Caipiaodianshenqing cpdSq = new Caipiaodianshenqing();
		cpdSq.setDianming(nickname);
		cpdSq.setShoujihao(phone);
		cpdSq.setMima(password);
		cpdSq.setClientId(clientId);
		//将Caipiaodianshenqing表status设置为-1
		cpdSq.setZhuangtai((Integer)(-1));
		caipiaodianshenqingDAO.save(cpdSq);
		String hql = "from Caipiaodianshenqing where dianming=? and shoujihao=?";
		List <Caipiaodianshenqing> caipiaodianApplyList = hqlDAO.pageQuery(hql, 1, 1, nickname, phone);
		if(caipiaodianApplyList.size()>0){
			return caipiaodianApplyList.get(0);
		}
		return null;
	}

	/**
	 * 提交最终的身份验证
	 * 完成商户验证后才将Caipiaodianshenqing表status设置为0
	 */
	public void shopConfirmation(Caipiaodianshenqing caipiaodianshenqing, String faren, String shenfenzheng, String sfzFrontImg, 
			String sfzBackImg, String yingyeID, String yingyeName, String yingyeImg, Integer arId, String address
			) {
		System.out.println(caipiaodianshenqing.getId());
		caipiaodianshenqing.setZhenshixingming(faren);
		caipiaodianshenqing.setShenfenzhengbianhao(shenfenzheng);
		caipiaodianshenqing.setZhenmian(sfzFrontImg);
		caipiaodianshenqing.setFanmian(sfzBackImg);
		caipiaodianshenqing.setYinyezhizhao(yingyeID);
		caipiaodianshenqing.setYinyezhizhaomingzi(yingyeName);
		caipiaodianshenqing.setYinyezhizhaoImg(yingyeImg);
		caipiaodianshenqing.setArea(areaDAO.findById(arId));
		caipiaodianshenqing.setXiangxidizhi(address);
		caipiaodianshenqing.setJingdu((double) 1);
		caipiaodianshenqing.setWeidu((double) 1);
		caipiaodianshenqing.setIsticai(true);
		caipiaodianshenqing.setIsfucai(true);
		//完成商户验证后才将Caipiaodianshenqing表status设置为0
		caipiaodianshenqing.setZhuangtai((Integer)0);
		caipiaodianshenqingDAO.merge(caipiaodianshenqing);
	}
	
////////////////////////////////////////////彩票店的信息记录////////////////////////////////////////////////////////////////
	/**
	 * 充值记录
	 * @param id
	 * @param size 
	 * @param page 
	 * @return
	 */
	public String getChongzhijilu(Integer cpdId, String page, String size) {
		String hql = "from Cpzchongzhijilu where caipiaodian.id=?";
		List<Cpzchongzhijilu> czjlList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), cpdId);
		Map map = new HashMap();
		map.put("czjlList", czjlList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		config.setExcludes(new String[]{"password"});
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 提现记录
	 * @param id
	 * @param page 
	 * @param size 
	 * @return
	 */
	public String getTixianjilu(Integer id, String size, String page) {
		String hql = "from Cpztixian where caipiaodian.id=?";
		List<Cpztixian> txList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), id);
		Map map = new HashMap();
		map.put("txList", txList);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"password"});
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 中奖记录
	 * 查询改用户的所有订单详情（双色球，五分彩，足球 and so on）
	 * @param id
	 * @param page 
	 * @param size 
	 * @return
	 */
	public String getZhongjiangjilu(Integer id, String size, String page) {
		//只显示中奖的
		String hql = "from Dingdan where caipiaodianByCpzid.id=?";//订单
		@SuppressWarnings("unchecked")//批注允许您选择性地取消特定代码段（即，类或方法）中的警告。其中的想法是当您看到警告时，您将调查它，如果您确定它不是问题，您就可以添加一个 @SuppressWarnings 批注，以使您不会再看到警告。虽然它听起来似乎会屏蔽潜在的错误，但实际上它将提高代码安全性，因为它将防止您对警告无动于衷 — 您看到的每一个警告都将值得注意。 
		List<Dingdan> dingdanList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), id);
		List<Dingdanxiangqing> ddxqList = new ArrayList<Dingdanxiangqing>();
		for (Dingdan dingdan : dingdanList) {
			//0未中奖，1已中奖
			String hql2 = "from Dingdanxiangqing where isZhongjiang=? and dingdan.id=?";//订单详情
			List<Dingdanxiangqing> list = hqlDAO.findByHQL(hql2, (Integer)1, dingdan.getId());
			ddxqList.addAll(list);
		}
		Map map = new HashMap();
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"password"});
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 进入我要提现页面
	 * 查出：可提现金额（users表的Jifen字段），提现中金额（status=0），已提现金额（status=1）
	 * 状态，0未审核提现中，1通过审核已提现，2被拒绝
	 * @param id
	 * @return
	 */
	public String gotoTixian(Integer id) {
		//可提现金额
		String ketixian = caipiaodianDAO.findById(id).getKetixian()+"";
		
		//提现中金额（status=0），已提现金额（status=1）
		String hql = "select SUM(money) from Cpztixian where status=0 and caipiaodian.id=?";
		String tixianzhong = hqlDAO.unique(hql, id)+"";
		String hql2 = "select SUM(money) from Cpztixian where status=1 and caipiaodian.id=?";
		String yitixian = hqlDAO.unique(hql2, id)+"";
		Map map = new HashMap();
		map.put("ketixian", ketixian);
		map.put("tixianzhong", tixianzhong);
		map.put("yitixian", yitixian);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"password"});
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}
	
	/**
	 * 提现操作
	 * 发起提现申请，新增一条彩票店提现申请记录，等待后台审核
	 * 从彩票店积分中扣除可用积分
	 * @param id
	 * @param parseDouble
	 * @return
	 */
	public String doTixian(Caipiaodian caipiaodian, double txMoney) {
		Cpztixian cpztixian = new Cpztixian();
		cpztixian.setMoney(txMoney);
		cpztixian.setStatus(0);//状态，0未审核提现中，1通过审核已提现，2被拒绝
		cpztixian.setTime(new Timestamp(System.currentTimeMillis()));//申请时间
		cpztixian.setCaipiaodian(caipiaodian);
		cpztixianDAO.save(cpztixian);
		double ketixian = caipiaodian.getKetixian();
		if(ketixian < txMoney){
			return "no";//超额提现
		}
		caipiaodian.setKetixian(ketixian-txMoney);//从彩票店积分中扣除可用积分
		caipiaodianDAO.merge(caipiaodian);
		return "yes";
	}
	
	/**
	 * 修改密码
	 * @param mobile
	 * @param newPwd
	 */
	public void changePwd(String mobile, String newPwd) {
		List<Caipiaodian> list = caipiaodianDAO.findByPhone(mobile);
		if(list.size()>0){
			Caipiaodian caipiaodian = list.get(0);
			caipiaodian.setPassword(newPwd);
			caipiaodianDAO.merge(caipiaodian);
		}
	}
}
