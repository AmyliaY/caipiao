package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PXUtil{
	
    /**
     * 排序算法
     * @param list2 需要排序的Object[]对象集合
     * @param n 按第几个元素的大小排序
     * @return 降序排列的Object[]对象集合
     * lgz 2016/11/20
     */
	public static List sort(List list2,int n){
			Object[] k = null;
			Object[] t=null;
			Object[] min=new Object[n+1];
			for (int i = 0; i <=n; i++) {
				if(i==n)
					min[i]=99999999;
				else
					min[i]=1;
			}
	      
			List<Object[]> data=new ArrayList();
			List list=new ArrayList();
			for (int i = 0; i < list2.size(); i++) {
				Object[] obj=(Object[]) list2.get(i);
				list.add(obj);
			}		
			if(list.size()>1){
				for (int i = 1; i <=list2.size(); i++) {
					for(int j=0;j<list2.size()-i;j++){
						Object[] obj=(Object[]) list.get(j);
						Object[] ob=(Object[]) list.get(j+1);
						if(Integer.parseInt(ob[n].toString())<Integer.parseInt(obj[n].toString())){
							t=obj;
							obj=ob;
							ob=t;
						}
						k=obj;
						if(Integer.parseInt(obj[n].toString())<Integer.parseInt(min[n].toString())){
							min=obj;
						}
					}
					//System.out.println("min:"+min[n]);
					for (int j = 0; j <list.size(); j++) {
						Object[] obj=(Object[]) list.get(j);
						//System.out.println(obj[n]+"   "+k[n]);
						if(list.size()==1){
							data.add(obj);
							list.remove(j);
							break;
						}
						if(obj[n].toString().equals(k[n].toString())){
							//System.out.println("remove:"+obj[n]);
							data.add(obj);
							list.remove(j);
							break;
						}						
					}
				}
				List<Object[]> data2=new ArrayList();
				for (int i=data.size()-1;i>=0;i--) {
					data2.add(data.get(i));
				}
				return data2;
			}
		
		
		
		return list2;
	}
	
}
