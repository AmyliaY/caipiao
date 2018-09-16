package com.service.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CaipiaodianDAO;
import com.dao.CollectionsDAO;
import com.dao.DingdanDAO;
import com.dao.DingdanxiangqingDAO;
import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.dao.UserschongzhijiluDAO;
import com.dao.UserstixianDAO;
import com.pojo.Caipiaodian;
import com.pojo.Collections;
import com.pojo.Dingdan;
import com.pojo.Dingdanxiangqing;
import com.pojo.Users;
import com.pojo.Userschongzhijilu;
import com.pojo.Userstixian;
import com.util.JsonFilter;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
* @author 全恒
*/
@Service
public class AppPersonCenterService {
	
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private DingdanDAO dingdanDAO;//订单
	@Autowired
	private DingdanxiangqingDAO dingdanxiangqingDAO;//双色球订单详情
	@Autowired
	private UserschongzhijiluDAO userschongzhijiluDAO;//用户充值记录
	@Autowired
	private UserstixianDAO userstixianDAO;//用户提现记录
	@Autowired
	private CollectionsDAO collectionsDAO;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;
	
	/**
	 * 订单和订单详情（目前只有双色球）
	 * @param id
	 * @param size 
	 * @param page 
	 * @return
	 */
	public String getOrders(Users users, String page, String size) {
		//对订单做分页
		String hql = "from Dingdan where users.id=?";//订单
		List<Dingdan> dingdanList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), users.getId());
		List<Dingdanxiangqing> ddxqList = new ArrayList<Dingdanxiangqing>();
		for (Dingdan dingdan : dingdanList) {
			String hql2 = "from Dingdanxiangqing where dingdan.id=?";//订单详情
			List<Dingdanxiangqing> list = hqlDAO.findByHQL(hql2, dingdan.getId());
			ddxqList.addAll(list);
		}
		Map map = new HashMap();
		map.put("dingdanList", dingdanList);
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
	 * 根据订单id查出订单及订单详情
	 * @param orderid
	 * @return
	 */
	public String getOrderById(String orderid) {
		Dingdan dingdan = dingdanDAO.findById(orderid);
		String hql = "from Dingdanxiangqing where dingdan.id=?";
		List<Dingdanxiangqing> ddxqList = hqlDAO.findByHQL(hql, orderid);
		Map map = new HashMap();
		map.put("dingdan", dingdan);
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
	 * 充值记录
	 * @param id
	 * @param size 
	 * @param page 
	 * @return
	 */
	public String getChongzhijilu(Integer id, String page, String size) {
		String hql = "from Userschongzhijilu where users.id=?";
		List<Userschongzhijilu> czjlList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), id);
		Map map = new HashMap();
		map.put("czjlList", czjlList);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"password"});
		JsonFilter.ignoredSet(config);
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
		String hql = "from Userstixian where users.id=?";
		List<Userstixian> txList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), id);
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
		String hql = "from Dingdan where users.id=?";//订单
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
	 * 我收藏的彩票店
	 * @param page 
	 * @param size 
	 */
	public String getCollections(Integer id, String size, String page) {
		String hql ="from Collections where users.id=?";
		List<Collections> coList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), id);
		//根据coList查出所有的彩票店
		List<Caipiaodian> cpdList = new ArrayList<Caipiaodian>();
		for (Collections collections : coList) {
			cpdList.add(collections.getCaipiaodian());
		}
		Map map = new HashMap();
		map.put("cpdList", cpdList);
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
		//可提现金额（users表的Jifen字段）
		Double ketixian = usersDAO.findById(id).getJifen();
		//提现中金额（status=0），已提现金额（status=1）
		String hql = "select SUM(money) from Userstixian where status=0 and users.id=?";
		String tixianzhong = hqlDAO.unique(hql, id)+"";
		String hql2 = "select SUM(money) from Userstixian where status=1 and users.id=?";
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
	 * 根据彩票店id收藏彩票店
	 * @param id
	 * @param cpdId
	 * @return
	 */
	public String collectById(Integer id, String cpdId) {
		Collections collection = new Collections();
		Users users = usersDAO.findById(id);
		Caipiaodian caipiaodian = caipiaodianDAO.findById(Integer.parseInt(cpdId));
		collection.setUsers(users);
		collection.setCaipiaodian(caipiaodian);
		collection.setCoTime(new Timestamp(System.currentTimeMillis()));
		collectionsDAO.save(collection);
		return "yes";
	}

	/**
	 * 根据彩票店id取消收藏
	 * @param id
	 * @param cpdId
	 */
	public void removeCollectById(Integer id, String cpdId) {
		String hql = "from Collections where users.id=? and caipiaodian.id=?";
		List<Collections> list = hqlDAO	.findByHQL(hql, id, cpdId);
		if(list.size() > 0){
			Collections collections = list.get(0);
			collectionsDAO.delete(collections);
		}
	}

	/**
	 * 提现操作
	 * 发起提现申请，新增一条用户提现申请记录，等待后台审核
	 * 从用户积分中扣除可用积分
	 * @param id
	 * @param parseDouble
	 * @return
	 */
	public String doTixian(Users users, double txMoney) {
		Userstixian userstixian = new Userstixian();
		userstixian.setMoney(txMoney);
		userstixian.setStatus(0);//状态，0未审核提现中，1通过审核已提现，2被拒绝
		userstixian.setTime(new Timestamp(System.currentTimeMillis()));//申请时间
		userstixian.setUsers(users);
		userstixianDAO.save(userstixian);
		double jifen = users.getJifen();
		if(jifen < txMoney){
			return "no";//超额提现
		}
		users.setJifen(jifen-txMoney);//从用户积分中扣除可用积分
		usersDAO.merge(users);
		return "yes";
	}

	public List findMemberMobile(String mobile) {
		List list = usersDAO.findByPhone(mobile);
		return list;
	}

	/**
	 * 修改密码
	 * @param newPwd
	 * @param newPwd2 
	 */
	public void changePwd(String mobile, String newPwd) {
		List<Users> list = usersDAO.findByPhone(mobile);
		if(list.size()>0){
			Users users = list.get(0);
			users.setPassword(newPwd);
			usersDAO.merge(users);
		}
	}
}
