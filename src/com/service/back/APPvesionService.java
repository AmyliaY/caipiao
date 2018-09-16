package com.service.back;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AppversionDAO;
import com.dao.HqlDAO;
import com.pojo.Appversion;

@Service
public class APPvesionService {
	
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private AppversionDAO appversionDAO;
	
	public Map applisting(int size, int page) {
		String hqlsum="select count(*) from Appversion";
		int sum = (int) hqlDAO.unique(hqlsum);
		int count = sum%size==0 ? sum/size : sum/size+1;
		if(page<1) page=1;
		if(page>count) page=count;
		String hql="from Appversion order by avtime desc";
		List list=hqlDAO.pageQuery(hql, size, page);
		Map map=new HashMap();
		map.put("sum", sum);
		map.put("count", count);
		map.put("list", list);
		map.put("page", page);
		map.put("size", size);
		return map;
	}
	
	public void AppfileUpload(String appEdition, String avtype, String file) {
		Appversion appversion=new Appversion();
		appversion.setAversion(appEdition);//Avversion
		appversion.setAvtype(Integer.parseInt(avtype));
		String url = "appdownload/android/"+file;
		if ("1".equals(avtype))
			url = "appdownload/ios/"+file;
		appversion.setAvurl(url);
		appversion.setAvtime(new Timestamp(System.currentTimeMillis()));
		appversionDAO.save(appversion);
	}
	
	public boolean deleteapp(int avid) {
		Appversion app=appversionDAO.findById(avid);
		if(app!=null){
			appversionDAO.delete(app);
			return true;
		}
		return false;
	}
}
