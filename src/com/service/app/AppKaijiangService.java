package com.service.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.pojo.DaletouKjgg;
import com.pojo.Fucai3dKjgg;
import com.pojo.PailiesanKjgg;
import com.pojo.PailiewuKjgg;
import com.pojo.QilecaiKjgg;
import com.pojo.QixingcaiKjgg;
import com.pojo.ShiyixuanwuKjgg;
import com.pojo.ShuangseqiuKjgg;
import com.pojo.ZucaishengfuKjgg;
import com.util.JsonFilter;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
* @author 全恒
*/
@Service
public class AppKaijiangService {

	@Autowired
	private HqlDAO hqlDAO;

	/**
	 * 查询出每种彩票的最新一条数据
	 * @return
	 */
	public String gotoKaijiang() {
		Map map = new HashMap();
		DaletouKjgg daletouKjgg = new DaletouKjgg();
		String hql1 = "from DaletouKjgg order by kaijiangTime desc";
		List<DaletouKjgg> list1 = hqlDAO.pageQuery(hql1, 1, 1);
		if(list1.size() > 0){
			daletouKjgg = list1.get(0);
		}
		map.put("daletouKjgg", daletouKjgg);
		Fucai3dKjgg fucai3dKjgg = new Fucai3dKjgg();
		String hql2 = "from Fucai3dKjgg order by kaijiangTime desc";
		List<Fucai3dKjgg> list2 = hqlDAO.pageQuery(hql2, 1, 1);
		if(list2.size() > 0){
			fucai3dKjgg = list2.get(0);
		}
		map.put("fucai3dKjgg", fucai3dKjgg);
		PailiesanKjgg pailiesanKjgg = new PailiesanKjgg();
		String hql3 = "from PailiesanKjgg order by kaijiangTime desc";
		List<PailiesanKjgg> list3 = hqlDAO.pageQuery(hql3, 1, 1);
		if(list3.size() > 0){
			pailiesanKjgg = list3.get(0);
		}
		map.put("pailiesanKjgg", pailiesanKjgg);
		PailiewuKjgg pailiewuKjgg = new PailiewuKjgg();
		String hql4 = "from PailiewuKjgg order by kaijiangTime desc";
		List<PailiewuKjgg> list4 = hqlDAO.pageQuery(hql4, 1, 1);
		if(list4.size() > 0){
			pailiewuKjgg = list4.get(0);
		}
		map.put("pailiewuKjgg", pailiewuKjgg);
		QilecaiKjgg qilecaiKjgg = new QilecaiKjgg();
		String hql5 = "from QilecaiKjgg order by kaijiangTime desc";
		List<QilecaiKjgg> list5 = hqlDAO.pageQuery(hql5, 1, 1);
		if(list5.size() > 0){
			qilecaiKjgg = list5.get(0);
		}
		map.put("qilecaiKjgg", qilecaiKjgg);
		QixingcaiKjgg qixingcaiKjgg = new QixingcaiKjgg();
		String hql6 = "from QixingcaiKjgg order by kaijiangTime desc";
		List<QixingcaiKjgg> list6 = hqlDAO.pageQuery(hql6, 1, 1);
		if(list6.size() > 0){
			qixingcaiKjgg = list6.get(0);
		}
		map.put("qixingcaiKjgg", qixingcaiKjgg);
		ShiyixuanwuKjgg shiyixuanwuKjgg = new ShiyixuanwuKjgg();
		String hql7 = "from ShiyixuanwuKjgg order by kaijiangTime desc";
		List<ShiyixuanwuKjgg> list7 = hqlDAO.pageQuery(hql7, 1, 1);
		if(list7.size() > 0){
			shiyixuanwuKjgg = list7.get(0);
		}
		map.put("shiyixuanwuKjgg", shiyixuanwuKjgg);
		ShuangseqiuKjgg shuangseqiuKjgg = new ShuangseqiuKjgg();
		String hql8 = "from ShuangseqiuKjgg order by kaijiangTime desc";
		List<ShuangseqiuKjgg> list8 = hqlDAO.pageQuery(hql8, 1, 1);
		if(list8.size() > 0){
			shuangseqiuKjgg = list8.get(0);
		}
		map.put("shuangseqiuKjgg", shuangseqiuKjgg);
		ZucaishengfuKjgg zucaishengfuKjgg = new ZucaishengfuKjgg();
		String hql9 = "from ZucaishengfuKjgg order by kaijiangTime desc";
		List<ZucaishengfuKjgg> list9 = hqlDAO.pageQuery(hql9, 1, 1);
		if(list9.size() > 0){
			zucaishengfuKjgg = list9.get(0);
		}
		map.put("zucaishengfuKjgg", zucaishengfuKjgg);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getShuangseqiuKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from ShuangseqiuKjgg order by kaijiangTime desc";
		List<ShuangseqiuKjgg> shuangseqiuKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("shuangseqiuKjggList", shuangseqiuKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getFucai3dKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from Fucai3dKjgg order by kaijiangTime desc";
		List<Fucai3dKjgg> fucai3dKjggKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("fucai3dKjggKjggList", fucai3dKjggKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getQilecaiKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from QilecaiKjgg order by kaijiangTime desc";
		List<QilecaiKjgg> qilecaiKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("qilecaiKjggList", qilecaiKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getDaletouKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from DaletouKjgg order by kaijiangTime desc";
		List<DaletouKjgg> daletouKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("daletouKjggList", daletouKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getQixingcaiKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from QixingcaiKjgg order by kaijiangTime desc";
		List<QixingcaiKjgg> qixingcaiKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("qixingcaiKjggList", qixingcaiKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getZuqiushengfuKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from ZucaishengfuKjgg order by kaijiangTime desc";
		List<ZucaishengfuKjgg> zucaishengfuKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("zucaishengfuKjggList", zucaishengfuKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getPailiesanKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from PailiesanKjgg order by kaijiangTime desc";
		List<PailiesanKjgg> pailiesanKjggKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("pailiesanKjggKjggList", pailiesanKjggKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getPailiewuKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from PailiewuKjgg order by kaijiangTime desc";
		List<PailiewuKjgg> pailiewuKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("pailiewuKjggList", pailiewuKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	public String getShiyixuanwuKjgg(String size, String page) {
		Map map = new HashMap();
		String hql = "from ShiyixuanwuKjgg order by kaijiangTime desc";
		List<ShiyixuanwuKjgg> shiyixuanwuKjggList = hqlDAO.pageQuery(hql, Integer.parseInt(size), Integer.parseInt(page));
		map.put("shiyixuanwuKjggList", shiyixuanwuKjggList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}
}
