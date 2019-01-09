package com.zrmall.o2o.web.superadmin;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrmall.o2o.dto.ImageHolder;
import com.zrmall.o2o.dto.ShopExecution;
import com.zrmall.o2o.entity.Area;
import com.zrmall.o2o.entity.PersonInfo;
import com.zrmall.o2o.entity.Shop;
import com.zrmall.o2o.entity.ShopCategory;
import com.zrmall.o2o.enums.ShopStateEnum;
import com.zrmall.o2o.exception.ShopOperationException;
import com.zrmall.o2o.interceptor.AreaService;
import com.zrmall.o2o.interceptor.ShopCategoryService;
import com.zrmall.o2o.interceptor.ShopService;
import com.zrmall.o2o.util.CodeUtil;
import com.zrmall.o2o.util.HttpServletRequestUtil;




@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
	private ShopService shopService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private ShopCategoryService shopCategoryService;
	@RequestMapping(value="/getshopinitinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> getShopInitInfo(){
		Map<String,Object> modelMap= new HashMap<String,Object>();
		List<ShopCategory> shopCategoryList= new ArrayList<ShopCategory>();
		List<Area> areaList= new ArrayList<Area>();
		try{
		shopCategoryList=shopCategoryService.queryShopCategory(new ShopCategory());
		areaList=areaService.queryArea();
		modelMap.put("shopCategoryList", shopCategoryList);
		modelMap.put("areaList", areaList);
		modelMap.put("success", true);
		}catch(Exception e){
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;
		
	}
	@RequestMapping(value="/registershop",method=RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request){
		Map<String,Object> modelMap= new HashMap<String,Object>();
		if(!CodeUtil.checkVerifyCode(request)){
			modelMap.put("success", false);
			modelMap.put("errMsg", "验证码输入错误！");
			return modelMap;
		}
		String shopStr=HttpServletRequestUtil.getString(request, "shopStr");
		//ObjectMapper是com.fasterxml.jackson.databind.ObjectMapper;用于json和pojo之间类型
		//的转换
		ObjectMapper mapper= new ObjectMapper();
		Shop shop= null;
		try {
			shop=mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		//接收图片
		CommonsMultipartFile shopImg=null;
		// 从request的上下文对象中取到上传的文件流
		CommonsMultipartResolver cmpr= new CommonsMultipartResolver
				(request.getSession().getServletContext());
		//判断request中是否有文件上传流
		if(cmpr.isMultipart(request)){
			MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
			shopImg=(CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
			
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "上传图片不能为空！");
			return modelMap;
		}
		//店铺注册
		if(shop !=null && shopImg !=null){
			
			PersonInfo owner=(PersonInfo) request.getSession().getAttribute("user");
			//先创建一个user
			owner=new PersonInfo();
			owner.setUserId(8);
			shop.setOwner(owner);
			ShopExecution se;
			try {
				ImageHolder imageHolder= new ImageHolder(shopImg.getOriginalFilename()
						, shopImg.getInputStream());
				se=shopService.addShop(shop, imageHolder);
				if(se.getState()==ShopStateEnum.CHECK.getState()){
					modelMap.put("success", true);
					@SuppressWarnings("unchecked")
					List<Shop> shopList=(List<Shop>) request.getSession().getAttribute("shopList");
					if(shopList==null||shopList.size()==0){
						shopList=new ArrayList<Shop>();
					}
					shopList.add(se.getShop());
					request.getSession().setAttribute("shopList",shopList);
				}else{
					modelMap.put("success", false);
					modelMap.put("errMsg", se.getStateInfo());
				}
			}catch(ShopOperationException e){ 
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			return modelMap;
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺信息");
			return modelMap;
		}
		
	}
}
