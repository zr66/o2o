package com.zrmall.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zrmall.o2o.BaseTest;
import com.zrmall.o2o.dto.ImageHolder;
import com.zrmall.o2o.dto.ShopExecution;
import com.zrmall.o2o.entity.Area;
import com.zrmall.o2o.entity.PersonInfo;
import com.zrmall.o2o.entity.Shop;
import com.zrmall.o2o.entity.ShopCategory;
import com.zrmall.o2o.enums.ShopStateEnum;
import com.zrmall.o2o.interceptor.ShopService;

public class ShopServiceTest extends BaseTest {
@Autowired
	private ShopService shopService;
@Test
public void shopServiceTest() throws FileNotFoundException{
	Shop shop = new Shop();
	PersonInfo owner = new PersonInfo();
	Area area = new Area();
	ShopCategory shopCategory = new ShopCategory();
	owner.setUserId(1L);
	area.setAreaId(2);
	shopCategory.setShopCategoryId(10L);
	shop.setOwner(owner);
	shop.setArea(area);
	shop.setShopCategory(shopCategory);
	shop.setShopName("测试的店铺3");
	shop.setShopDesc("test3");
	shop.setShopAddr("test3");
	shop.setPhone("test3");
	shop.setCreateTime(new Date());
	shop.setEnableStatus(ShopStateEnum.CHECK.getState());
	shop.setAdvice("审核中");
    File shopImg= new File("d://a.jpg");
    InputStream is= new FileInputStream(shopImg);
    ImageHolder imageHolder= new ImageHolder(shopImg.getName(), is);
    ShopExecution shopExecution=shopService.addShop(shop, imageHolder);
    assertEquals(ShopStateEnum.CHECK.getState(), shopExecution.getState());
}
	
}
