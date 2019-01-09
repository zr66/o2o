package com.zrmall.o2o.mapper;

import com.zrmall.o2o.entity.ShopCategory;
import com.zrmall.o2o.entity.ShopCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCategoryMapper {
	/**
	 * 根据输入的条件查询商品类别列表
	 * @param example
	 * @return
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory shopCategoryCondition);
    long countByExample(ShopCategoryExample example);

    int deleteByExample(ShopCategoryExample example);

    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    List<ShopCategory> selectByExample(ShopCategoryExample example);

    ShopCategory selectByPrimaryKey(Integer shopCategoryId);

    int updateByExampleSelective(@Param("record") ShopCategory record, @Param("example") ShopCategoryExample example);

    int updateByExample(@Param("record") ShopCategory record, @Param("example") ShopCategoryExample example);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);
}