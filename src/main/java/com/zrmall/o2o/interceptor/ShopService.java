package com.zrmall.o2o.interceptor;

import com.zrmall.o2o.dto.ImageHolder;
import com.zrmall.o2o.dto.ShopExecution;
import com.zrmall.o2o.entity.Shop;
import com.zrmall.o2o.exception.ShopOperationException;

public interface ShopService {
 int  insertShop(Shop shop);
 /**
  * 注册店铺信息，图片处理
  * 
  * @author Administrator
  * @param shop 
  * @param thumbnail
  * @param
  * @return shopexcution
  * @throw  shopoperationexception
  * 
  * 
  */
 ShopExecution  addShop(Shop shop,ImageHolder thumbnail)throws ShopOperationException;
 Shop queryById(long shopId);
 
 
}
