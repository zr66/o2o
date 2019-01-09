package com.zrmall.o2o.mapper;

import java.util.List;

import com.zrmall.o2o.entity.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    /**
	 * 查询区域列表
	 * @return
	 */
    List<Area> queryArea();
}