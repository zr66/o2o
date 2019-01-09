package com.zrmall.o2o.web.superadmin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrmall.o2o.entity.PersonInfo;
import com.zrmall.o2o.entity.Shop;
import com.zrmall.o2o.interceptor.ShopService;
import com.zrmall.o2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/shop")
public class ShopController {
@Autowired
	private ShopService shopService;
@RequestMapping(value="/insert",method=RequestMethod.POST)
@ResponseBody
public Map<String,Object> insert(){
	Map<String,Object> modelMap= new HashMap<String,Object>();
	Shop shop= new Shop();
	PersonInfo ower= new PersonInfo();
	ower.setUserId(1);
	shop.setOwner(ower);
	shop.setEnableStatus(0);
	shop.setShopName("zrshop");
	try{
		shopService.insertShop(shop);
		modelMap.put("success", "添加成功！");
	}catch (Exception e) {
		modelMap.put("error", "添加出错！");
	}
	
	return modelMap;
}
@RequestMapping(value="/queryshop",method=RequestMethod.GET)
@ResponseBody
public Map<String,Object> select(HttpServletRequest request){
	Map<String,Object> modelMap =new HashMap<>();
	String shopId=HttpServletRequestUtil.getString(request, "shopId");
	System.out.println(shopId);
	Shop shop= shopService.queryById(Long.parseLong(shopId));
	modelMap.put("success", shop);
	return modelMap;
}
	
}
