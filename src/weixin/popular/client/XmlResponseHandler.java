package weixin.popular.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import weixin.popular.util.XMLConverUtil;

public class XmlResponseHandler{

	public static <T> ResponseHandler<T> createResponseHandler(final Class<T> clazz){
		return new ResponseHandler<T>() {
			public T handleResponse(HttpResponse response)
					throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    String str = EntityUtils.toString(entity);
                    //System.out.println("****"+new String(str.getBytes("iso8859-1"),"utf-8"));
                   return XMLConverUtil.convertToObject(clazz,new String(str.getBytes("iso-8859-1"),"utf-8"));
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }

			}
		};
	}

}
