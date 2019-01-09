package com.zrmall.o2o.mapper;

import com.zrmall.o2o.entity.ProductCategory;
import com.zrmall.o2o.entity.ProductCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryMapper {
    long countByExample(ProductCategoryExample example);

    int deleteByExample(ProductCategoryExample example);

    int deleteByPrimaryKey(Integer productCategoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExample(ProductCategoryExample example);

    ProductCategory selectByPrimaryKey(Integer productCategoryId);

    int updateByExampleSelective(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByExample(@Param("record") ProductCategory record, @Param("example") ProductCategoryExample example);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
    
    /**
     * 根据shopId查店铺商品类别
     * @param long 
     * @return List<ProductCategory> 
     */
    List<ProductCategory> productCategoryList(long shopId);
    /**
     * 批量新增商品类别
     * @param productCategoryList
     * @return effectedNum
     */
    int insertProductCategoryList(List<ProductCategory> productCategoryList);
    
    /**
     * 删除指定商品的指定商品类别Id的商品类别
     * @param productCategoryId
     * @param shopId
     * @return effectedNum
     */
    int deleteProductCategoryByShopId(@Param("productCategoryId")long productCategoryId,@Param("shopId")long shopId);
    
}