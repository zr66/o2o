package com.zrmall.o2o.mapper;

import com.zrmall.o2o.entity.HeadLine;
import com.zrmall.o2o.entity.HeadLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HeadLineMapper {
    long countByExample(HeadLineExample example);

    int deleteByExample(HeadLineExample example);

    int deleteByPrimaryKey(Integer lineId);

    int insert(HeadLine record);

    int insertSelective(HeadLine record);

    List<HeadLine> selectByExample(HeadLineExample example);

    HeadLine selectByPrimaryKey(Integer lineId);

    int updateByExampleSelective(@Param("record") HeadLine record, @Param("example") HeadLineExample example);

    int updateByExample(@Param("record") HeadLine record, @Param("example") HeadLineExample example);

    int updateByPrimaryKeySelective(HeadLine record);

    int updateByPrimaryKey(HeadLine record);
}