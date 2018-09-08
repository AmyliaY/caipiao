package com.service.app;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CaipiaodianDAO;
import com.dao.CpzchongzhijiluDAO;
import com.dao.CpztixianDAO;
import com.dao.HqlDAO;
import com.dao.UsersDAO;
import com.dao.UserschongzhijiluDAO;
import com.dao.UserstixianDAO;
import com.pojo.Caipiaodian;
import com.pojo.Cpzchongzhijilu;
import com.pojo.Users;
import com.pojo.Userschongzhijilu;

/**
* @author 全恒
* 处理用户和彩票店的充值提现
*/
@Service
public class AppChongzhiTixianService {
	
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private UserschongzhijiluDAO userschongzhijiluDAO;
	@Autowired
	private UserstixianDAO userstixianDAO;
	@Autowired
	private CpzchongzhijiluDAO cpzchongzhijiluDAO;
	@Autowired
	private CpztixianDAO cpztixianDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;

	/**
	 * 新增用户充值订单记录
	 * @param userinfo  用户对象
	 * @param price   用户金额  
	 * @param orderid 订单号
	 * @param prType  支付类型  1支付 宝  2微信  3后台
	 */
	public void addUserChongzhi(Users users, double parseDouble, String orderId, int payType) {
		Userschongzhijilu userschongzhijilu = new Userschongzhijilu();
		userschongzhijilu.setUsers(users);
		userschongzhijilu.setDid(orderId);
		userschongzhijilu.setMoney(parseDouble);
		userschongzhijilu.setStatus(0);
		userschongzhijilu.setType(payType);
		userschongzhijiluDAO.save(userschongzhijilu);
	}

	/**
	 * 用户充值成功，修改用户充值订单状态,修改用户的积分
	 * 
	 * @param outTradeNo
	 * @param parseDouble
	 * @return
	 */
	public boolean changeUserChongzhi(String trade_no, Double money) {
		String hql = "from Userschongzhijilu where did=?";
		List list = hqlDAO.pageQuery(hql, 1, 1, trade_no);
		if (list.size() > 0) {
			Userschongzhijilu userschongzhijilu = (Userschongzhijilu) list.get(0);
			userschongzhijilu.setStatus(1);
			userschongzhijilu.setTime(new Timestamp(System.currentTimeMillis()));
			Users users = userschongzhijilu.getUsers();
			if (users != null) {
				Double oldJifen = users.getJifen();
				if (oldJifen==null)
					oldJifen = 0.0;
				users.setJifen(oldJifen + money);
				usersDAO.merge(users); // 更新用户的积分
			}
			userschongzhijiluDAO.merge(userschongzhijilu);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 新增彩票店充值订单记录
	 * @param userinfo  彩票店对象
	 * @param price   用户金额  
	 * @param orderid 订单号
	 * @param prType  支付类型  1支付 宝  2微信  3后台
	 */
	public void addCpdChongzhi(Caipiaodian caipiaodian, double parseDouble, String orderId, int prType) {
		Cpzchongzhijilu cpzchongzhijilu = new Cpzchongzhijilu();
		cpzchongzhijilu.setCaipiaodian(caipiaodian);
		cpzchongzhijilu.setDid(orderId);
		cpzchongzhijilu.setMoney(parseDouble);
		cpzchongzhijilu.setStatus(0);
		cpzchongzhijilu.setType(prType);
		cpzchongzhijiluDAO.save(cpzchongzhijilu);
	}
	
	/**
	 * 彩票店充值成功，修改彩票店充值订单状态,修改彩票店的积分
	 * 
	 * @param outTradeNo
	 * @param parseDouble
	 * @return
	 */
	public boolean changeCpdChongzhi(String trade_no, Double money) {
		String hql = "from Cpzchongzhijilu where did=?";
		List list = hqlDAO.pageQuery(hql, 1, 1, trade_no);
		if (list.size() > 0) {
			Cpzchongzhijilu cpzchongzhijilu = (Cpzchongzhijilu) list.get(0);
			cpzchongzhijilu.setStatus(1);
			cpzchongzhijilu.setTime(new Timestamp(System.currentTimeMillis()));
			Caipiaodian caipiaodian = cpzchongzhijilu.getCaipiaodian();
			if (caipiaodian != null) {
				Double oldJifen = caipiaodian.getKetixian();
				if (oldJifen==null)
					oldJifen = 0.0;
				caipiaodian.setKetixian(oldJifen + money);
				caipiaodianDAO.merge(caipiaodian); // 更新用户的积分
			}
			cpzchongzhijiluDAO.merge(cpzchongzhijilu);
			return true;
		}
		return false;
	}
}
