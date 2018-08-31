package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.InterfaceDate;
import weixin.popular.client.JsonResponseHandler;
import weixin.popular.util.JsonUtil;

public class InterfaceSummary extends BaseAPI {
	
	public InterfaceSummary interfaceSummary(String access_token,String interfacejson,String flag){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/"+flag)
				.addParameter("access_token",access_token)
				.setEntity(new StringEntity(interfacejson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(InterfaceSummary.class));
	}
	
	
	
	public InterfaceSummary interfaceSummary(String access_token,InterfaceDate interfaceDate){
		String str = JsonUtil.toJSONString(interfaceDate);
		return interfaceSummary(access_token, str,"getinterfacesummary");
	}
	//分时
	public InterfaceSummary interfaceSummaryHour(String access_token,InterfaceDate interfaceDate){
		String str = JsonUtil.toJSONString(interfaceDate);
		return interfaceSummary(access_token, str,"getinterfacesummaryhour");
	}
	
	public static void main(String[] args) {
		InterfaceSummary interfaceSummary = new InterfaceSummary();
		String begindate = "2016-11-6";
	    String enddate = "2016-11-7";
		InterfaceDate interfaceDate = new InterfaceDate();
		interfaceDate.setBegin_date(begindate);
		interfaceDate.setEnd_date(enddate);
		interfaceSummary.interfaceSummary("BaiH9xMBKzQtuZJ9cWKrE3jerudJ_CPEfgTddcvkok1km9su5zPsMvWoCOluscsxAd0ofZNlPpx2a8OTiGFQN3fFNtKBS8HhLHqwZ89phdoPGgfk-XB0DYIw_wp1BGztHSSbAJAVGG",interfaceDate);
	}

}
