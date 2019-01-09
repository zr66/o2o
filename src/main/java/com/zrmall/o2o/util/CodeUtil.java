package com.zrmall.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
//校验验证码
	public static boolean checkVerifyCode(HttpServletRequest request){
		//从session中获取KaptCha生成的验证码
		String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//从表单中获取用户填写的验证码
				String verifyCodeActual = 
						HttpServletRequestUtil.getString(request,"verifyCodeActual");
				if(verifyCodeActual==null || !verifyCodeActual.equals(verifyCodeExpected)){
					return false;
				}else{
					return true;
				}
	}
}
