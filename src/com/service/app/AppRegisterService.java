package com.service.app;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.ShoujiduanxiaoxiDAO;
import com.pojo.Shoujiduanxiaoxi;

@Service
public class AppRegisterService {

	@Autowired
	private ShoujiduanxiaoxiDAO shoujiduanxiaoxiDAO;
	@Autowired
	private HqlDAO hqldao;

	/**
	 * 保存验证码
	 * @param code 驗證碼
	 * @param mobile手機號
	 */
	public void saveCode(String code, String mobile) {
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		Shoujiduanxiaoxi shoujiduanxiaoxi = new Shoujiduanxiaoxi();
		shoujiduanxiaoxi.setMessage(code);
		shoujiduanxiaoxi.setPhone(mobile);
		shoujiduanxiaoxi.setTime(time);
		shoujiduanxiaoxiDAO.save(shoujiduanxiaoxi);
	}

	/**
	 * 
	 * @param mobile
	 * @param code
	 * @return
	 */
	public List findJihuoma(String mobile, String code) {
		String hql = "from Shoujiduanxiaoxi  where message=? and phone=?";
		List list = hqldao.findByHQL(hql, code, mobile);
		return list;
	}
}
