package com.action.app;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Dingdanxiangqing;
import com.pojo.Users;
import com.service.app.AppBuyCaipiaoService;

/**
 *  @author 全恒
 */
@Controller
@RequestMapping("/buycaipiao.do")
public class AppBuyCaipiaoAction {

	@Autowired
	private HttpServletRequest request;
	@Autowired 
	private AppBuyCaipiaoService buyCaipiaoService;
	
	/**
	 * 创建双色球订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderBySSQ")
	@ResponseBody
	public String createOrderBySSQ(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取双色球订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrder(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成双色球订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及双色球订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersBySSQ")
	@ResponseBody
	public String confirmOrdersBySSQ(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrders(userid);
		return json;
	}
	
	/**
	 * 创建福彩3D订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderByFC3D")
	@ResponseBody
	public String createOrderByFC3D(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取福彩3D订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderByFC3D(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成双色球订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及福彩3D订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersByFC3D")
	@ResponseBody
	public String confirmOrdersByFC3D(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersByFC3D(userid);
		return json;
	}
	
	/**
	 * 创建七乐彩订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderByQLC")
	@ResponseBody
	public String createOrderByQLC(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		
		//获取七乐彩订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderByQLC(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成七乐彩订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及七乐彩订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersByQLC")
	@ResponseBody
	public String confirmOrdersByQLC(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersByQLC(userid);
		return json;
	}
	
	/**
	 * 创建大乐透订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderByDLT")
	@ResponseBody
	public String createOrderByDLT(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取大乐透订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderByDLT(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成大乐透订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及大乐透订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersByDLT")
	@ResponseBody
	public String confirmOrdersByDLT(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersByDLT(userid);
		return json;
	}
	
	/**
	 * 创建七星彩订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderByQXC")
	@ResponseBody
	public String createOrderByQXC(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取七星彩订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderByQXC(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成七星彩订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及七星彩订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersByQXC")
	@ResponseBody
	public String confirmOrdersByQXC(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersByQXC(userid);
		return json;
	}
	
	/**
	 * 创建排列三订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderByPLS")
	@ResponseBody
	public String createOrderByPLS(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取排列三订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderByPLS(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成排列三订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及双色球订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersByPLS")
	@ResponseBody
	public String confirmOrdersByPLS(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersByPLS(userid);
		return json;
	}
	
	/**
	 * 创建排列五订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderByPLW")
	@ResponseBody
	public String createOrderByPLW(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取排列五订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderByPLW(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成排列五订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及排列五订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersByPLW")
	@ResponseBody
	public String confirmOrdersByPLW(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersByPLW(userid);
		return json;
	}
	
	/**
	 * 创建十一选五订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderBySYXW")
	@ResponseBody
	public String createOrderBySYXW(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取十一选五订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderBySYXW(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成十一选五订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及十一选五订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersBySYXW")
	@ResponseBody
	public String confirmOrdersBySYXW(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersBySYXW(userid);
		return json;
	}
	
	/**
	 * 根据订单id取消订单，将指定的订单status改为-1
	 */
	@RequestMapping(params="p=cancelOrder")
	@ResponseBody
	public String cancelOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String orderId = request.getParameter("orderId");
		String json = buyCaipiaoService.cancelOrder(orderId);
		return json;
	}
	
	/**
	 * 根据当前用户所在的区县，彩票店类型，列出该地区的彩票店，
	 */
	@RequestMapping(params="p=findCaipiaodian")
	@ResponseBody
	public String fingCaippiaodian(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//参数：qu，shi，page，size，isTicai，isFucai
		String isTicai=request.getParameter("isTicai");
		String isFucai=request.getParameter("isFucai");
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("size"));
		String shi = request.getParameter("shi");
		String qu  = request.getParameter("qu");
		String json = buyCaipiaoService.findCipiaodian(isTicai, isFucai, page, size, shi, qu);
		return json;
	}
	
	/**
	 * 根据彩票店id查出彩票店详情
	 */
	@RequestMapping(params="p=findCaipiaodianById")
	@ResponseBody
	public String findCaipiaodianById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Integer cpdId = Integer.parseInt(request.getParameter("cpdId"));
		String json = buyCaipiaoService.findCaipiaodianById(cpdId);
		return json;
	}
	
	/**
	 * 根据所选彩票店的id和对应订单的id选择彩票店
	 * 最多选5个
	 */
	@RequestMapping(params="p=selectCaipiaodian")
	@ResponseBody
	public String selectCaipiaodian(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//如果为空的话，就将cpzid的值设为  null
		String orderid = request.getParameter("orderid");
		String cpzid1 = request.getParameter("cpzid1");
		String cpzid2 = request.getParameter("cpzid2");
		String cpzid3 = request.getParameter("cpzid3");
		String cpzid4 = request.getParameter("cpzid4");
		String cpzid5 = request.getParameter("cpzid5");
		buyCaipiaoService.selectCaipiaodian(orderid, cpzid1, cpzid2, cpzid3, cpzid4, cpzid5);
		return "yes";
	}
	
	/**
	 * 进入支付页面
	 * 查出应付金额和可用金额
	 */
	@RequestMapping(params="p=gotoPay")
	@ResponseBody
	public String gotoPay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String json = buyCaipiaoService.gotoPay(users.getId());
		return json;
	}
	
	/**
	 * 确认支付
	 * 根据用户id和应付金额从用户可用积分中扣除，根据订单id改变相应的订单status为1
	 */
	@RequestMapping(params="p=confirmPay")
	@ResponseBody
	public String confirmPay(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String yingfujine = request.getParameter("yingfujine");
		String orderid = request.getParameter("orderid");
		String result = buyCaipiaoService.confirmPay(users.getId(), yingfujine, orderid);
		return result;//支付成功，result="yes"
	}
	
	/**
	 * 查询caipiaobiao
	 */
	@RequestMapping(params="p=findCaipiaobiao")
	@ResponseBody
	public String findfindCaipiaobiao(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String json = buyCaipiaoService.findCaipiaobiao();
		System.out.println(json);
		return json;
	}
	
	/**
	 * 查询二级彩票类目和订单详情
	 */
	@RequestMapping(params="p=findOrderDesc")
	@ResponseBody
	public String findOrderDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = (Users)request.getSession().getAttribute("users");
		String json = buyCaipiaoService.findOrderDesc(users.getId());
		System.out.println(json);
		return json;
	}
	
	/**
	 * 查出可投注的足球比赛详情
	 */
	@RequestMapping(params="p=findSoccerGameDesc")
	@ResponseBody
	public String findSoccerGameDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String json = buyCaipiaoService.findSoccerGameDesc();
		System.out.println(json);
		return json;
	}
	
	/**
	 * 创建足彩胜负比赛订单
	 * 订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单
	 */
	@RequestMapping(params="p=createOrderByZCSF")
	@ResponseBody
	public String createOrderByZCSF(HttpServletRequest request,HttpServletResponse response)throws IOException{
		Users users = (Users) request.getSession().getAttribute("users");
		//获取订单参数
		Integer userid = users.getId();
		String cpid = request.getParameter("cpid");
		String zhushu = request.getParameter("zhushu");
		String money = request.getParameter("money");
		//获取足彩订单详情参数
		String orderDescJson = request.getParameter("orderDescJson");
		//将json转换成dingdanxiangqing的list集合
		List<Dingdanxiangqing> orderDescList = null;
		buyCaipiaoService.createOrderByZCSF(userid,cpid,zhushu,money,orderDescList);
		//buyCaipiaoService.createOrderDesc();
		//生成排列五订单详情表
		return "yes";
	}
	
	/**
	 * 确认订单，将status为0的订单及排列五订单详情显示出来
	 */
	@RequestMapping(params="p=confirmOrdersByZCSF")
	@ResponseBody
	public String confirmOrdersByZCSF(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//得到用户
		Users users = (Users)request.getSession().getAttribute("users");
		//根据用户id查询订单
		Integer userid = users.getId();
		String json = buyCaipiaoService.confirmOrdersByZCSF(userid);
		return json;
	}
	
}
