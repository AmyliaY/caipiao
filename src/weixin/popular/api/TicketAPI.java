package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import weixin.popular.bean.AccessToken;
import weixin.popular.bean.SnsToken;
import weixin.popular.bean.Ticket;
import weixin.popular.client.JsonResponseHandler;

public class TicketAPI extends BaseAPI {
	
	/**
	 * 获取用户 Ticket
	 */
	public Ticket getTicket(String accessToken){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri("https://api.weixin.qq.com/cgi-bin/ticket/getticket")
				.addParameter("access_token", accessToken)
				.addParameter("type", "jsapi")
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(Ticket.class));
	}

}
 