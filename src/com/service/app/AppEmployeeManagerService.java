package com.service.app;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CaipiandianyuangongDAO;
import com.dao.CaipiaodianDAO;
import com.dao.HqlDAO;
import com.pojo.Caipiandianyuangong;
import com.pojo.Caipiaodian;
import com.util.JsonFilter;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
* @author 全恒
*/
@Service
public class AppEmployeeManagerService {
	
	@Autowired
	private CaipiandianyuangongDAO caipiandianyuangongDAO;
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private CaipiaodianDAO caipiaodianDAO;
	
	/**
	 * 根据彩票店查询对应的员工列表
	 * @param caipiaodian
	 * @return
	 */
	public String findEmployeeList(Caipiaodian caipiaodian) {
		String hql = "from Caipiandianyuangong where caipiaodian.id=?";
		List<Caipiandianyuangong> employeeList = hqlDAO.findByHQL(hql, caipiaodian.getId());
		Map map = new HashMap();
		map.put("employeeList", employeeList);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(map, config);
		String json = jsonObject.toString();
		return json;
	}

	/**
	 * 新增员工
	 * 0离职，1在职
	 * @param tel
	 * @param pwd2
	 * @return
	 */
	public String addEmployee(Caipiaodian caipiaodian, String tel, String pwd2,String name) {
		//安全验证，验证该员工的手机号是否和彩票店的重复
		List list = caipiaodianDAO.findByPhone(tel);
		if(list.size() > 0){
			return "no";
		}
		//验证该员工的手机号是否和其他员工的重复
		List list2 = caipiandianyuangongDAO.findByShoujihao(tel);
		if(list2.size() >0){
			return "no2";
		}
		Caipiandianyuangong employee = new Caipiandianyuangong();
		Timestamp created = new Timestamp(System.currentTimeMillis());
		employee.setCaipiaodian(caipiaodian);
		employee.setName(name);
		employee.setShoujihao(tel);
		employee.setMima(pwd2);
		employee.setChuangjianshijian(created);
		employee.setZhuangtai((Integer)1);//新增完设置为1在职
		caipiandianyuangongDAO.save(employee);
		return "yes";
	}

	/**
	 * 改变员工状态
	 * @param caipiaodian
	 * @return
	 */
	public String changeStatus(Integer empId) {
		Caipiandianyuangong caipiandianyuangong = caipiandianyuangongDAO.findById(empId);
		Integer status = caipiandianyuangong.getZhuangtai();
		caipiandianyuangong.setZhuangtai((Integer)(1-status%2));
		return "yes";
	}

	/**
	 * 编辑员工
	 * @param empId
	 * @param tel
	 * @param pwd2
	 * @return
	 */
	public String editEmployee(Integer empId, String tel, String pwd2) {
		//安全验证，验证该员工的手机号是否和彩票店的重复
		List list = caipiaodianDAO.findByPhone(tel);
		if(list.size() > 0){
			return "no";
		}
		//验证该员工的手机号是否和其他员工的重复
		List list2 = caipiandianyuangongDAO.findByShoujihao(tel);
		if(list2.size() >0){
			return "no2";
		}
		Caipiandianyuangong caipiandianyuangong = caipiandianyuangongDAO.findById(empId);
		caipiandianyuangong.setShoujihao(tel);
		caipiandianyuangong.setMima(pwd2);
		return "yes";
	}
}
