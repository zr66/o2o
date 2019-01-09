package com.zrmall.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zrmall.o2o.BaseTest;
import com.zrmall.o2o.entity.ShopCategory;
import com.zrmall.o2o.interceptor.ShopCategoryService;

public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
	private ShopCategoryService shopCategoryService;
    @Test
    public void queryShopCategory(){
    	List<ShopCategory> list=shopCategoryService.queryShopCategory(null);
    	System.out.println(list.size());
    }
}
