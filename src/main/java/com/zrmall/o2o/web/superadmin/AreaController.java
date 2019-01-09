package com.zrmall.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrmall.o2o.entity.Area;
import com.zrmall.o2o.interceptor.AreaService;


@Controller
@RequestMapping("/superadmin")
public class AreaController {
	Logger logger=LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> queryArea(){
		logger.info("==start==");
		long startTime=System.currentTimeMillis();
		Map<String,Object> modelMap= new HashMap<>();
		List<Area> areaList= new ArrayList<>();
		try{
			areaList=areaService.queryArea();
			modelMap.put("areaList", areaList);
			modelMap.put("result", "ok");
			
		}catch(Exception e){
			modelMap.put("result", "no");
			
		}
		logger.error("error test");
		long endTime=System.currentTimeMillis();
		logger.debug("costTime:[{}ms]", endTime-startTime);
		logger.info("==end==");
		return modelMap;
		
	}

}

