package weixin.popular.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpDownload {

	static HttpClient client = new DefaultHttpClient();
   
	public static boolean download(String url, String filename)
	{
	    try {
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = client.execute(httpGet);
			if (response.getStatusLine().getStatusCode()==200){
			   InputStream is = response.getEntity().getContent();
			   OutputStream out = new FileOutputStream(filename);
			   byte[] b  = new byte[1024];
			   int size = is.read(b);
			   while (size>0){
				   out.write(b,0,size);
				   size = is.read(b);
			   }
			   out.close();
			   is.close();
			}
			httpGet.releaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
}
