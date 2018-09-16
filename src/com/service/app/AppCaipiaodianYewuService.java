package com.service.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< .mine

=======
>>>>>>> .r2724
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
import com.pojo.Caipiaodian;
import com.pojo.Dingdan;
import com.pojo.Dingdanxiangqing;
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
		String hql = "from Dingdan where status =1 and caipiaodianByCpzid1 =? or caipiaodianByCpzid2 =? or caipiaodianByCpzid3 =? or caipiaodianByCpzid4 =? or caipiaodianByCpzid5 =?";//订单
		List<Dingdan> dingdanList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page),caipiaodian,caipiaodian,caipiaodian,caipiaodian,caipiaodian);
		for (Dingdan dingdan : dingdanList) {
			  long now = System.currentTimeMillis();
			  long startTime = dingdan.getBegintime().getTime();
			  long djs = 3600-(now-startTime)/1000;
			  if (djs<0)
				  djs = 0;
			  dingdan.setDjs_miao(djs);
		}
		Map map = new HashMap();
		map.put("dingdanList", dingdanList);
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
	 * @return 
	 */
	//@Scheduled(fixedRate = 500)
	public Dingdan qiangdanByorderId(String orderid, Caipiaodian caipiaodian) {
		
		Dingdan dingdan = dingdanDAO.findById(orderid);
		if(dingdan.getStatus()==1)
		{
		dingdan.setCaipiaodianByCpzid(caipiaodian);
		dingdan.setStatus(2);
		}
		dingdan = dingdanDAO.merge(dingdan);
		return dingdan;
	}

	/**
	 * 根据订单id查看订单详情
	 */
	public String orderDescByorderId(String orderid) {
		Dingdan dingdan = dingdanDAO.findById(orderid);
		System.out.println(orderid);
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
