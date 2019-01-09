package com.zrmall.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zrmall.o2o.BaseTest;
import com.zrmall.o2o.entity.ShopCategory;
import com.zrmall.o2o.mapper.ShopCategoryMapper;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
	private ShopCategoryMapper shopCategoryMapper;
	 @Test
    public void queryShopCategory(){
    	List<ShopCategory> shopCategoryList = shopCategoryMapper.queryShopCategory(null);
    	System.out.println(shopCategoryList.size());
    			
    }
	
}
