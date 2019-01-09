package com.zrmall.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrmall.o2o.entity.ShopCategory;
import com.zrmall.o2o.interceptor.ShopCategoryService;
import com.zrmall.o2o.mapper.ShopCategoryMapper;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	@Override
	public List<ShopCategory> queryShopCategory(ShopCategory shopCategoryCondition){
		
		return shopCategoryMapper.queryShopCategory(shopCategoryCondition);
	}

}
