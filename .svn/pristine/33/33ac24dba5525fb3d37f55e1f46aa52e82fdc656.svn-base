package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

/**
 * 水果的
 * @author Administrator
 *
 */
public class FileUtil {
	
	/**
	 * 
	 * @param request
	 * @param srcDir        源文件所在目录(虚拟路径,/开头)
	 * @param srcFileName   源文件文件名
	 * @param desdir        目标目录(虚拟路径,/开头)
	 */
	public static void copy(HttpServletRequest request, String srcDir,String srcFileName, String desdir)
	{
		String _srcDir = request.getSession().getServletContext().getRealPath(srcDir);
		String _desDir = request.getSession().getServletContext().getRealPath(desdir);
		try {
			System.out.println("原文件:"+_srcDir+"/"+srcFileName);
			//D:\java_work\xm\.metadata\.me_tcat\webapps\shuiguoshop\admin\back_WeixinProfile\news_image
			//D:\java_work\xm\.metadata\.me_tcat\webapps\shuiguoshop\admin\back_companyProfile\news_image\1517485808712.png
			InputStream is = new FileInputStream(_srcDir+"/"+srcFileName);
			OutputStream out = new FileOutputStream(_desDir+"/"+srcFileName);
			byte[] b= new byte[10240];
			int size = is.read(b);
			while (size>0)
			{
				out.write(b,0,size);
				size = is.read(b);
			}
			out.close();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
