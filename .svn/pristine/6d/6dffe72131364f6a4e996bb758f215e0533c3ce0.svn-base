package com.weixin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ParseXmlUtil {
    public static Map<String,String> readStringXmlOut(String xml) {  
	       Map<String,String> map = new HashMap<String,String>();  
	        Document doc = null;  
	     try {  
	            doc = DocumentHelper.parseText(xml); 
	            Element rootElt = doc.getRootElement(); 
	            List<Element> list = rootElt.elements(); 
	           for (Element element : list) {  
      map.put(element.getName(), element.getText());   
	         }  
	      } catch (DocumentException e) {  
	          e.printStackTrace();  
	       } catch (Exception e) {  
      e.printStackTrace();  
}  
	      return map;  
	    }
}
