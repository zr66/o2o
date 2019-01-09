package com.zrmall.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zrmall.o2o.BaseTest;
import com.zrmall.o2o.entity.Area;
import com.zrmall.o2o.interceptor.AreaService;

public class AreaServiceTest extends BaseTest {
    @Autowired
	private AreaService areaService;
    @Test
	public void queryArea(){
		List<Area> areaList=areaService.queryArea();
		for(Area a : areaList){
			System.out.println(a.getAreaName());
		}
	}
}
