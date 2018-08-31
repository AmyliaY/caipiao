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
public class AppCaipiaodianYewuService {
	
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
	
	
	public String qiangdan(Caipiaodian caipiaodian, String page, String size) {
		//对订单做分页
		String hql = "from Dingdan where status=1";//订单
		List<Dingdan> dingdanList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		/*List<Dingdanxiangqing> ddxqList = new ArrayList<Dingdanxiangqing>();
		for (Dingdan dingdan : dingdanList) {
			String hql2 = "from Dingdanxiangqing where dingdan.id=?";//订单详情
			List<Dingdanxiangqing> list = hqlDAO.findByHQL(hql2, dingdan.getId());
			ddxqList.addAll(list);
		}*/
		Map map = new HashMap();
		map.put("dingdanList", dingdanList);
		//map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"password"});
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 抢单(根据订单id)，将dingdan的caipiaodianByCpzid设置为当前彩票店，并修改订单状态。
	 * @param caipiaodian 
	 */
	public void qiangdanByorderId(String orderid, Caipiaodian caipiaodian) {
		Dingdan dingdan = dingdanDAO.findById(orderid);
		dingdan.setCaipiaodianByCpzid(caipiaodian);
		dingdan.setStatus(2);
		dingdanDAO.merge(dingdan);
	}

	/**
	 * 根据订单id查看订单详情
	 */
	public String orderDescByorderId(String orderid) {
		Dingdan dingdan = dingdanDAO.findById(orderid);
		String hql2 = "from Dingdanxiangqing where dingdan.id=?";//订单详情
		List<Dingdanxiangqing> ddxqList = hqlDAO.findByHQL(hql2, dingdan.getId());
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
	 * 查看当前彩票店抢到的所有订单
	 */
	public String getOrders(Caipiaodian caipiaodian, String page, String size) {
		//对订单做分页
		String hql = "from Dingdan where status=2 and caipiaodianByCpzid.id=?";//订单
		List<Dingdan> dingdanList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), caipiaodian.getId());
		/*List<Dingdanxiangqing> ddxqList = new ArrayList<Dingdanxiangqing>();
		for (Dingdan dingdan : dingdanList) {
			String hql2 = "from Dingdanxiangqing where dingdan.id=?";//订单详情
			List<Dingdanxiangqing> list = hqlDAO.findByHQL(hql2, dingdan.getId());
			ddxqList.addAll(list);
		}*/
		Map map = new HashMap();
		map.put("dingdanList", dingdanList);
		//map.put("ddxqList", ddxqList);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"password"});
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	
	

	
}
