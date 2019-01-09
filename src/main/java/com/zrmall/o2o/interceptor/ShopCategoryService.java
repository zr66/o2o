package com.zrmall.o2o.interceptor;

import java.util.List;

import com.zrmall.o2o.entity.ShopCategory;

public interface ShopCategoryService {
 public static final String SCLISTKEY = "shopcategorylist";
 /**根据查询条件查找shopcategory
  * 
  */
 List<ShopCategory> queryShopCategory(ShopCategory shopCategoryCondition);
}
