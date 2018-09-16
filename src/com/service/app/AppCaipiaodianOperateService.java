package com.service.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CaipiaodianDAO;
import com.dao.DingdanDAO;
import com.dao.HqlDAO;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.pojo.Caipiaodian;
import com.pojo.Dingdan;
import com.pojo.Dingdanxiangqing;
import com.util.AppMessageSend;
import com.util.JsonFilter;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
* @author 全恒
*/
@Service
public class AppCaipiaodianOperateService {
	
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private DingdanDAO dingdanDAO;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;
	
	/**
	 * 订单和订单详情（目前只有双色球）
	 * @param id
	 * @param size 
	 * @param page 
	 * @return
	 */
	public String getOrders(Integer id, String page, String size) {
		//对订单做分页
		String hql = "from Dingdan where caipiaodianByCpzid.id=?";//订单
		List<Dingdan> dingdanList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page), id);
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
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 查出可抢订单
	 * @return
	 */
	public String qiangdanList(Caipiaodian caipiaodian) {
		String hql = "from Dingdan where status=1 and (caipiaodianByCpzid1=? or caipiaodianByCpzid2=? or caipiaodianByCpzid3=? or caipiaodianByCpzid4=? or caipiaodianByCpzid5=?)";
		List qiangdanList = hqlDAO.findByHQL(hql, caipiaodian.getId(), caipiaodian.getId(), caipiaodian.getId(), caipiaodian.getId(), caipiaodian.getId());
		Map map = new HashMap();
		map.put("qiangdanList", qiangdanList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 执行抢单操作
	 */
	public String qiangdan(String orderid, Caipiaodian caipiaodian) {
		Dingdan dingdan = dingdanDAO.findById(orderid);
		//判断该订单的状态
		if(dingdan.getStatus() == 1){
			//设置接单的商家和状态
			dingdan.setCaipiaodianByCpzid(caipiaodian);
			dingdan.setStatus((Integer)2);
		}
		return "yes";
	}

	/**
	 * 蓝牙打印
	 * @param caipiaodian
	 * @return
	 */
	public String lanyaDayinList(Caipiaodian caipiaodian) {
		String hql = "from Dingdan where status=2 and caipiaodianByCpzid=?";
		List lanyaDayinList = hqlDAO.findByHQL(hql, caipiaodian.getId());
		
		/**
		 * 对订单进行蓝牙打印
		 */
		
		return null;
	}

	/**
	 * 彩票店打印
	 * @param caipiaodian
	 */
	public void caipiaojiDayinList(Caipiaodian caipiaodian) {
		String hql = "from Dingdan where status=2 and caipiaodianByCpzid=?";
		List<Dingdan> lanyaDayinList = hqlDAO.findByHQL(hql, caipiaodian.getId());
		/**
		 * 对订单进行彩票店打印
		 */
		
		//打印完成后给用户发送通知
		NotificationTemplate template = new NotificationTemplate();
		template.setTransmissionType(1); //理解启动应用
		template.setTransmissionContent("测试消息");
		 
		Style0 style = new Style0(); // 设置通知栏标题与内容 
		style.setTitle("请输入通知栏标题"); 
		style.setText("请输入通知栏内容"); // 配置通知栏图标
		style.setLogo("icon.png"); // 配置通知栏网络图标
		style.setLogoUrl(""); 
		style.setRing(true); style.setVibrate(true); style.setClearable(true); // 设置通知是否响铃，震动，或者可清除
		template.setStyle(style);
		List list = new ArrayList();
		//打印完成后，将订单状态改为3（已完成），将积分打到彩票店账户上
		for (Dingdan dingdan : lanyaDayinList) {
			dingdan.setStatus((Integer)3);
			Double jifen = dingdan.getMoney();
			Double ketixian = caipiaodian.getKetixian();
			caipiaodian.setKetixian(ketixian+jifen);
			list.add(dingdan.getUsers().getClientId());
			dingdanDAO.merge(dingdan);
			caipiaodianDAO.merge(caipiaodian);
		}
		String ret = AppMessageSend.sendMessage(template, list);
	}

	/**
	 * 查询出当前可接的订单数
	 * @param caipiaodian
	 * @return
	 */
	public String kejieOrderNum(Caipiaodian caipiaodian) {
		String hql = "select NUM(*) from Dingdan where status=1 and (caipiaodianByCpzid1=? or caipiaodianByCpzid2=? or caipiaodianByCpzid3=? or caipiaodianByCpzid4=? or caipiaodianByCpzid5=?)";
		int num = (int)hqlDAO.unique(hql, caipiaodian, caipiaodian, caipiaodian, caipiaodian, caipiaodian);
		String numStr = num+"";
		return numStr;
	}

	public void cpjDayinById(String orderid) {
		// TODO Auto-generated method stub
		
	}
}
