package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;






import weixin.popular.bean.DataSummary.ArticleSummary;
import weixin.popular.bean.DataSummary.MessageSummary;
import weixin.popular.bean.DataSummary.SummaryDate;
import weixin.popular.bean.DataSummary.InterfaceSummary;
import weixin.popular.bean.DataSummary.UserSummary;
import weixin.popular.client.JsonResponseHandler;
import weixin.popular.util.JsonUtil;

public class DataSummaryAPI extends BaseAPI {
	/**
        数据统计
	 */
	//接口调用数据分析
	
	public InterfaceSummary interfaceSummary(String access_token,String interfacejson,String flag){
		
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/"+flag)
				.addParameter("access_token",access_token)
				.setEntity(new StringEntity(interfacejson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(InterfaceSummary.class));
	}
	
	
	
	public InterfaceSummary interfaceSummary(String access_token,SummaryDate interfaceDate){
		System.out.println( JsonUtil.toJSONString(interfaceDate));
		String str = JsonUtil.toJSONString(interfaceDate);
		return interfaceSummary(access_token, str,"getinterfacesummary");
	}
	            //分时
	public InterfaceSummary interfaceSummaryHour(String access_token,SummaryDate interfaceDate){
		String str = JsonUtil.toJSONString(interfaceDate);
		return interfaceSummary(access_token, str,"getinterfacesummaryhour");
	}
	
	public static void main(String[] args) {
		DataSummaryAPI interfaceSummary = new DataSummaryAPI();
		String begindate = "2016-11-8";
	    String enddate = "2016-11-8";
	    SummaryDate interfaceDate = new SummaryDate();
		interfaceDate.setBegin_date(begindate);
		interfaceDate.setEnd_date(enddate);
		ArticleSummary articleSummary =interfaceSummary.getArticleSummary("osbjWEVnwySPafhxVO61rAkhKWhuy3zEC9Js4G3_Oc0UFKhYklVFnktw0WLXqNO4IcCFXqMxxRt18eVtEk72fcdqpNLBNEGPVFzM0v0_KxicEMogSBYuXX-m6xz9V_grAAEfAGAWWA",interfaceDate);
	   System.out.println(articleSummary.getList()[0].getAdd_to_fav_count());
	}
	
	//用户数据分析
	public UserSummary usersummary(String access_token,String datejson,String flag){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/"+flag)
				.addParameter("access_token",access_token)
				.setEntity(new StringEntity(datejson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(UserSummary.class));
	}
	
	public UserSummary getUserSummary(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return usersummary(access_token, str,"getusersummary");
	}
	
	public UserSummary getUserCumulate(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return usersummary(access_token, str,"getusercumulate");
	}
	
	//消息接口数据分析
	
	public MessageSummary messageSummary(String access_token,String datejson,String flag){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/"+flag)
				.addParameter("access_token",access_token)
				.setEntity(new StringEntity(datejson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(MessageSummary.class));
	}
	
	public MessageSummary getUpStreammsg(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return messageSummary(access_token, str,"getusercumulate");
	}
	
	public MessageSummary getUpStreammsgHour(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return messageSummary(access_token, str,"getupstreammsghour");
	}
	
	public MessageSummary getUpStreammsgWeek(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return messageSummary(access_token, str,"getupstreammsgweek");
	}
	
	public MessageSummary getUpStreammsgMonth(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return messageSummary(access_token, str,"getupstreammsgmonth");
	}
	
	public MessageSummary getUpStreammsgDist(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return messageSummary(access_token, str,"getupstreammsgdist");
	}
	
	public MessageSummary getUpStreammsgDistWeek(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return messageSummary(access_token, str,"getupstreammsgdistweek");
	}
	
	public MessageSummary getUpStreammsgDistMonth(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return messageSummary(access_token, str,"getupstreammsgdistmonth");
	}
	
	//图文接口数据分析
	
	public ArticleSummary articleSummary(String access_token,String datejson,String flag){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/"+flag)
				.addParameter("access_token",access_token)
				.setEntity(new StringEntity(datejson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(ArticleSummary.class));
	}
	
	public ArticleSummary getArticleSummary(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return articleSummary(access_token, str,"getarticlesummary");
	}
	
	public ArticleSummary getArticleTotal(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return articleSummary(access_token, str,"getarticletotal");
	}
	public ArticleSummary getUserRead(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return articleSummary(access_token, str,"getuserread");
	}
	
	public ArticleSummary getUserReadHour(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return articleSummary(access_token, str,"getuserreadhour");
	}
	
	public ArticleSummary getUserShare(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return articleSummary(access_token, str,"getusershare");
	}
	public ArticleSummary getUserShareHour(String access_token,SummaryDate summaryDateDate){
		String str = JsonUtil.toJSONString(summaryDateDate);
		return articleSummary(access_token, str,"getusersharehour");
	}
	

	

}
