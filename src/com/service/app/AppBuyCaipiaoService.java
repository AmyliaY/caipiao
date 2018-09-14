package com.service.app;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CaipiaobiaoDAO;
import com.dao.CaipiaobiaoDescDAO;
import com.dao.CaipiaodianDAO;
import com.dao.DaletouDdxqDAO;
import com.dao.DingdanDAO;
import com.dao.DingdanxiangqingDAO;
import com.dao.Fucai3dDdxqDAO;
import com.dao.HqlDAO;
import com.dao.PailiesanDdxqDAO;
import com.dao.PailiewuDdxqDAO;
import com.dao.QilecaiDdxqDAO;
import com.dao.QixingcaiDdxqDAO;
import com.dao.ShiyixuanwuDdxqDAO;
import com.dao.SoccerGameDAO;
import com.dao.UsersDAO;
import com.dao.ZucaishengfuDdxqDAO;
import com.pojo.Caipiaobiao;
import com.pojo.CaipiaobiaoDesc;
import com.pojo.Caipiaodian;
import com.pojo.DaletouDdxq;
import com.pojo.Dingdan;
import com.pojo.Dingdanxiangqing;
import com.pojo.Fucai3dDdxq;
import com.pojo.PailiesanDdxq;
import com.pojo.PailiewuDdxq;
import com.pojo.QilecaiDdxq;
import com.pojo.QixingcaiDdxq;
import com.pojo.ShiyixuanwuDdxq;
import com.pojo.SoccerGame;
import com.pojo.Users;
import com.pojo.ZucaishengfuDdxq;
import com.util.JsonFilter;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
* @author 全恒
*/
@Service
public class AppBuyCaipiaoService {
	
	@Autowired
	private DingdanDAO dingdanDAO;
	@Autowired
	private DingdanxiangqingDAO dingdanxiangqingDAO;
	@Autowired
	private Fucai3dDdxqDAO fucai3dDdxqDAO;
	@Autowired
	private QilecaiDdxqDAO qilecaiDdxqDAO;
	@Autowired
	private DaletouDdxqDAO daletouDdxqDAO;
	@Autowired
	private QixingcaiDdxqDAO qixingcaiDdxqDAO;
	@Autowired
	private PailiesanDdxqDAO pailiesanDdxqDAO;
	@Autowired
	private PailiewuDdxqDAO pailiewuDdxqDAO;
	@Autowired
	private ShiyixuanwuDdxqDAO shiyixuanwuDdxqDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private CaipiaobiaoDAO caipiaobiaoDAO;
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private CaipiaobiaoDescDAO caipiaobiaoDescDAO;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;
	@Autowired
	private SoccerGameDAO soccerGameDAO;
	@Autowired
	private ZucaishengfuDdxqDAO zucaishengfuDdxqDAO;

	/**
	 * 创建订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 * @param userid
	 * @param cpid
	 * @param zhushu
	 * @param money
	 * @param orderDescList 
	 */
	public void createOrder(Integer userid, String cpid, String zhushu, String money, List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}

	}
	
	/**
	 * 确认订单
	 * 查询已下单未付款的订单及订单详情
	 * @param userid
	 * @return
	 */
	public String confirmOrders(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<Dingdanxiangqing> ddxqList = new ArrayList<Dingdanxiangqing>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from Dingdanxiangqing where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}
	
	/**
	 * 取消订单
	 * @param orderId
	 * @return
	 */
	public String cancelOrder(String orderId) {
		Dingdan dingdan = dingdanDAO.findById(orderId);
		dingdan.setStatus((Integer)(-1));
		dingdanDAO.save(dingdan);
		return null;
	}
	
	/**
	 * 根据当前用户所在的区县，列出该地区的彩票店，分页
	 * @param qu 
	 * @param shi 
	 * @param size 
	 * @param isFucai 0不是，1是
	 * @param isTicai 0不是，1是
	 */
	public String findCipiaodian(String isTicai, String isFucai, int page, int size, String shi, String qu) {
		StringBuffer sb=new StringBuffer("where 1=1 ");
		List paramlist=new ArrayList();
		if(isTicai != null && isTicai.length()>0 && "null".equals(isTicai)==false){
			sb.append(" and isticai=? ");
			Integer isticai;
			if("yes".equals(isTicai)){
				isticai = (Integer)1;
			}else{
				isticai = (Integer)0;
			}
			paramlist.add(isticai);
		}
		if(isFucai != null && isFucai.length()>0 && "null".equals(isFucai)){
			sb.append(" and isfucai=?");
			Integer isfucai;
			if("yes".equals(isFucai)){
				isfucai = (Integer)1;
			}else{
				isfucai = (Integer)0;
			}
			paramlist.add(isfucai);
		}
		if (qu!=null && qu.length()>0 && "null".equals(qu)==false)
		{
			sb.append(" and area.arName like  ?");
			paramlist.add("%"+qu+"%");
		}
		else if (shi!=null && shi.length()>0 && "null".equals(shi)==false && "全城".equals(shi)==false && "地区".equals(shi)==false)
		{
			sb.append(" and area.city.ctName like ? ");
			System.out.println("市:"+shi);
			paramlist.add("%"+shi.trim()+"%");
		}
		String hql="from Caipiaodian "+sb;
		System.out.println(hql);
		List caipiaodianList=hqlDAO.pageQuery(hql, size, page, paramlist.toArray());
		System.out.println("page:"+page+"/t"+"size:"+size);
		JsonConfig config=new JsonConfig();
		JsonFilter.ignoredSet(config);
		Map map =new HashMap();
		map.put("caipiaodianList", caipiaodianList);
		JSONObject obj=new JSONObject();
		obj.putAll(map, config);
		String json=obj.toString();
		return json;
	}

	/**
	 * 根据彩票店id查询彩票店详情
	 * @param cpdId
	 * @return
	 */
	public String findCaipiaodianById(Integer cpdId) {
		Caipiaodian caipiaodian = caipiaodianDAO.findById(cpdId);
		Map map = new HashMap();
		map.put("caipiaodianDesc", caipiaodian);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}
	
	/**
	 * 根据所选彩票店的id选择彩票店
	 * 最多选5个
	 * @param cpzid1
	 * @param cpzid2
	 * @param cpzid3
	 * @param cpzid4
	 * @param cpzid5
	 * @return
	 */
	public void selectCaipiaodian(String orderId, String cpzid1, String cpzid2, String cpzid3, String cpzid4, String cpzid5) {
		Dingdan dingdan = dingdanDAO.findById(orderId);
		//如果为空的话，就将cpzid的值设为  null
		if("null".equals(cpzid1)==false){
			Caipiaodian caipiaodian1 = caipiaodianDAO.findById(Integer.parseInt(cpzid1));
			dingdan.setCaipiaodianByCpzid1(caipiaodian1);
		}
		if("null".equals(cpzid2)==false){
			Caipiaodian caipiaodian2 = caipiaodianDAO.findById(Integer.parseInt(cpzid2));
			dingdan.setCaipiaodianByCpzid2(caipiaodian2);
		}
		if("null".equals(cpzid3)==false){
			Caipiaodian caipiaodian3 = caipiaodianDAO.findById(Integer.parseInt(cpzid3));
			dingdan.setCaipiaodianByCpzid3(caipiaodian3);
		}
		if("null".equals(cpzid4)==false){
			Caipiaodian caipiaodian4 = caipiaodianDAO.findById(Integer.parseInt(cpzid4));
			dingdan.setCaipiaodianByCpzid4(caipiaodian4);
		}
		if("null".equals(cpzid5)==false){
			Caipiaodian caipiaodian5 = caipiaodianDAO.findById(Integer.parseInt(cpzid5));
			dingdan.setCaipiaodianByCpzid5(caipiaodian5);
		}
		dingdanDAO.save(dingdan);
	}
	
	/**
	 * 进入支付页面
	 * 查出应付金额和可用金额
	 * 应付金额，dingdan表中，status=0的记录中，money的和
	 * 可用金额，Users表的jifen字段
	 */
	public String gotoPay(Integer id) {
		Users users = usersDAO.findById(id);
		String keyongjine = users.getJifen()+"";
		//应付金额
		String hql = "select SUM(money) from Dindan where status=0 and users.id=?";
		String yingfujine = hqlDAO.unique(hql, id)+"";
		Map map = new HashMap();
		map.put("yingfujine", yingfujine);
		map.put("keyongjine", keyongjine);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}
	
	/**
	 * 确认支付
	 * 根据用户id和应付金额从用户可用积分中扣除，根据订单id改变相应的订单status为1
	 * @param id
	 * @param yingfujine
	 * @param ordersJson
	 * @return
	 */
	public String confirmPay(Integer userid, String yingfujine, final String orderid) {
		Users users = usersDAO.findById(userid);
		Double jifen = users.getJifen();
		users.setJifen(jifen-Double.parseDouble(yingfujine));
		String hql = "from Dingdan where status=0 and users.id=?";
		List<Dingdan> list = hqlDAO.findByHQL(hql, userid);
		for (Dingdan dingdan : list) {
			dingdan.setStatus((Integer)1);
			dingdanDAO.save(dingdan);
		}
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				//如果6分钟内无店铺接单，则系统选择第一家
				Dingdan dingdan = dingdanDAO.findById(orderid);
				if(dingdan.getCaipiaodianByCpzid() == null){
					Caipiaodian caipiaodian1 = dingdan.getCaipiaodianByCpzid1();
					dingdan.setCaipiaodianByCpzid(caipiaodian1);
				}
			}
		};
		timer.schedule(timerTask, 1000*60*6);
		return "yes";
	}

	/**
	 * 查询所有的caipiaobiao
	 * @return
	 */
	public String findCaipiaobiao() {
		List<Caipiaobiao> caipiaobiaolist = caipiaobiaoDAO.findAll();
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		Map map = new HashMap();
		map.put("caipiaobiaolist", caipiaobiaolist);
		JSONObject obj = new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	/**
	 * 查询订单详情（已下单未付款）
	 * @param id
	 * @return
	 */
	public String findOrderDesc(Integer userid) {
		/*
		 * 先根据userid和status查出所有的dingdanxiangqing
		 * 再根据caipiaoStyle查出所有的三级类目
		 * 在根据三级类目查出所有的二级类目
		 */
		String hql = "from Dingdanxiangqing where dingdan.status=0 and dingdan.users.id=?";
		List<Dingdanxiangqing> list1 = hqlDAO.findByHQL(hql, userid);
		List<CaipiaobiaoDesc> list2 = new ArrayList<CaipiaobiaoDesc>();
		List<Caipiaobiao> list3 = new ArrayList<Caipiaobiao>();
		for (Dingdanxiangqing dingdanxiangqing : list1) {
			CaipiaobiaoDesc caipiaobiaoDesc = caipiaobiaoDescDAO.findById(dingdanxiangqing.getCaipiaobiaoDesc().getId());
			if(!list2.contains(caipiaobiaoDesc)){
				list2.add(caipiaobiaoDesc);
			}
		}
		for (CaipiaobiaoDesc caipiaobiaoDesc : list2) {
			Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(caipiaobiaoDesc.getCaipiaobiao().getId());
			if(!list3.contains(caipiaobiao)){
				list3.add(caipiaobiao);
			}
		}
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"users"});
		JsonFilter.ignoredSet(config);
		JSONObject jobject = new JSONObject();
		Map map = new HashMap();
		map.put("orderdesc", list1);
		//map.put("threetype", list2);
		map.put("twotype", list3);
		jobject.putAll(map,config);
		String json = jobject.toString();
		return json;
	}

	/**
	 * 福彩3D创建订单
	 * @param userid
	 * @param cpid
	 * @param zhushu
	 * @param money
	 * @param orderDescList
	 */
	public void createOrderByFC3D(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	public String confirmOrdersByFC3D(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<Fucai3dDdxq> ddxqList = new ArrayList<Fucai3dDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from Fucai3dDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	public void createOrderByQLC(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	public String confirmOrdersByQLC(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<QilecaiDdxq> ddxqList = new ArrayList<QilecaiDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from QilecaiDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	public void createOrderByDLT(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	public String confirmOrdersByDLT(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<DaletouDdxq> ddxqList = new ArrayList<DaletouDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from DaletouDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	public void createOrderByQXC(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	public String confirmOrdersByQXC(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<QixingcaiDdxq> ddxqList = new ArrayList<QixingcaiDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from QixingcaiDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	public void createOrderByPLS(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	public String confirmOrdersByPLS(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<PailiesanDdxq> ddxqList = new ArrayList<PailiesanDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from PailiesanDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	public void createOrderByPLW(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	public String confirmOrdersByPLW(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<PailiewuDdxq> ddxqList = new ArrayList<PailiewuDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from PailiewuDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	public void createOrderBySYXW(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	public String confirmOrdersBySYXW(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<ShiyixuanwuDdxq> ddxqList = new ArrayList<ShiyixuanwuDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from ShiyixuanwuDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}

	/**
	 * 查出可投注的足球比赛详情
	 * @return
	 */
	public String findSoccerGameDesc() {
		//根据截止日期判断是否可投注
		//得到当前日期
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		//根据当前日期去数据库查询大于当前日期的比赛
		String sql = "from SoccerGame where closingDate > ?";//时间可以直接拿来比！！！！！
		List<SoccerGame> soccerGameList = hqlDAO.findByHQL(sql, currentTime);
		Map map = new HashMap();
		map.put("soccerGameList", soccerGameList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 创建足彩胜负订单
	 * @param userid
	 * @param cpid
	 * @param zhushu
	 * @param money
	 * @param orderDescList
	 */
	public void createOrderByZCSF(Integer userid, String cpid, String zhushu, String money,
		List<Dingdanxiangqing> orderDescList) {
		//创建订单
		Dingdan dingdan = new Dingdan();
		String orderid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		Users users = usersDAO.findById(userid);
		Caipiaobiao caipiaobiao = caipiaobiaoDAO.findById(Integer.parseInt(cpid));//彩票二级类目
		Integer num = Integer.parseInt(zhushu);//倍数
		Timestamp beginTime = new Timestamp(System.currentTimeMillis());//订单创建时间
		Double moneys = Double.parseDouble(money);
		Integer status = (Integer)0;//订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
		dingdan.setId(orderid);
		dingdan.setUsers(users);
		dingdan.setCaipiaobiao(caipiaobiao);
		dingdan.setNum(num);
		dingdan.setBegintime(beginTime);
		dingdan.setMoney(moneys);
		dingdan.setStatus(status);
		dingdanDAO.save(dingdan);
		//创建订单详情
		for (Dingdanxiangqing dingdanxiangqing : orderDescList) {
			dingdanxiangqing.setDingdan(dingdan);
			dingdanxiangqingDAO.save(dingdanxiangqing);
		}
	}

	/**
	 * 确认足彩胜负订单
	 * @param userid
	 * @return
	 */
	public String confirmOrdersByZCSF(Integer userid) {
		//-1已取消订单，0已下单未付款，1已付款，2商家已接单
		String hql = "from Dingdan where status=0 and users.id = ?";
		List<Dingdan> dingdanlist = hqlDAO.findByHQL(hql, userid);
		List<ZucaishengfuDdxq> ddxqList = new ArrayList<ZucaishengfuDdxq>();
		for (Dingdan dingdan : dingdanlist) {
			String hql2 = "from ZucaishengfuDdxq where dingdan.id=?";
			List list = hqlDAO.findByHQL(hql2, dingdan.getId());
			if(list.size()>0){
				ddxqList.addAll(list);
			}
		}
		Map map = new HashMap();
		map.put("dingdanlist", dingdanlist);
		map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject obj= new JSONObject();
		obj.putAll(map, config);
		String json = obj.toString();
		return json;
	}
}
