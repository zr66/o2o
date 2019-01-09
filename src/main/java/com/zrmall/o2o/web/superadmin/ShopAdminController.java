package com.zrmall.o2o.web.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin",method=RequestMethod.GET)
/**
 * 解析路由，转到相应的html页面
 * @author Administrator
 *
 */
public class ShopAdminController {
    @RequestMapping("/shopoperation")
	public String shopOperation(){
		return "shop/shopoperation";
	}
}
