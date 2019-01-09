package com.zrmall.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zrmall.o2o.BaseTest;
import com.zrmall.o2o.entity.Area;
import com.zrmall.o2o.mapper.AreaMapper;

public class AreaDaoTest extends BaseTest {
@Autowired
 private AreaMapper areaMapper;
@Test
 public void testQueryArea(){
	 List<Area> areaList= areaMapper.queryArea();
	 for(Area  a: areaList){
		 System.out.println(a.getAreaName());
	 }
	 System.out.println(areaList.size());
 }
}
