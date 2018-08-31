package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import weixin.popular.bean.AccessToken;
import weixin.popular.bean.SnsToken;
import weixin.popular.client.JsonResponseHandler;

public class OpenIdAPI extends BaseAPI {
	
	/**
	 * 获取用户 openId
	 */
	public AccessToken getOpenId(String appid,String secret,String code){
		
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri("https://api.weixin.qq.com/sns/oauth2/access_token")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.addParameter("code", code)
				.addParameter("grant_type","authorization_code")
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(AccessToken.class));
	}
	public static void main(String[] args) {
		OpenIdAPI openIdAPI = new OpenIdAPI();
		openIdAPI.getOpenId("wx225617f3db0beec0", "189b9553df89662f10d0568d5019396f", "021DQQqk16YlIz0YNmpk1NkRqk1DQQqQ");
	}

}
 