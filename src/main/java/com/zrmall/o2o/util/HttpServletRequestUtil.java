package com.zrmall.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
//把前台接收的数据进行格式转换，转换成需要的类型
	public static int getInt(HttpServletRequest request,String key){
		try{
			return Integer.decode(request.getParameter(key));
		}catch(Exception e){
			return -1;
		}
		
	}
	public static long getLong(HttpServletRequest request,String key){
		try{
			return Long.valueOf(request.getParameter(key));
		}catch(Exception e){
			return -1;
		}
	}
	public static double getDouble(HttpServletRequest request,String key){
		try{
			return Double.valueOf(request.getParameter(key));
		}catch(Exception e){
			return -1d;
		}
	}
	public static boolean getBoolean(HttpServletRequest request,String key){
		try{
			return Boolean.valueOf(request.getParameter(key));
		}catch(Exception e){
			return false;
		}
	}
	//将接收到的字符串进行去空处理
	public static String getString(HttpServletRequest request,String key){
		try{
			String result= request.getParameter(key);
			if(result != null){
				result= result.trim();
			}
			if("".equals(result)){
				result=null;
			}
			return result;
		}catch(Exception e){
			return null;
		}
	}
}
