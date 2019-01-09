package com.zrmall.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrmall.o2o.entity.Area;
import com.zrmall.o2o.interceptor.AreaService;
import com.zrmall.o2o.mapper.AreaMapper;
@Service
public class AreaServceImpl implements AreaService {
    @Autowired
	private AreaMapper areaMapper;
	@Override
	public List<Area> queryArea() {
		List<Area> areaList=areaMapper.queryArea();
		
		return areaList;
	}

}
