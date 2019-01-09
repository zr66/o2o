package com.zrmall.o2o.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrmall.o2o.dto.ImageHolder;
import com.zrmall.o2o.dto.ShopExecution;
import com.zrmall.o2o.entity.Shop;
import com.zrmall.o2o.enums.ShopStateEnum;
import com.zrmall.o2o.exception.ShopOperationException;
import com.zrmall.o2o.interceptor.ShopService;
import com.zrmall.o2o.mapper.ShopMapper;
import com.zrmall.o2o.util.ImageUtil;
import com.zrmall.o2o.util.PathUtil;
@Service
public class ShopServiceImpl implements ShopService {
@Autowired
	private ShopMapper shopMapper;
	@Override
	public int insertShop(Shop shop) {
		
	return	shopMapper.insert(shop);
		
		
		
	}
	@Override
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
		if(shop==null){
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		//给店铺信息赋初始值
		try{
		shop.setEnableStatus(0);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		//添加店铺信息
		int effectNum=shopMapper.insert(shop);
		if(effectNum<=0){
			throw new ShopOperationException("店铺创建失败！");
		}else{
			if(thumbnail.getImage()!=null){
				//存储图片
				try{
					addShopImage(shop, thumbnail);
				}catch(Exception e){
					throw new ShopOperationException("addShopImgError:"+e.getMessage());
				}
				//更新店铺的图片地址
				System.out.println("8888888   "+shop.getShopImg());
			effectNum=shopMapper.updateByPrimaryKey(shop);
			System.out.println("9999999   "+effectNum);
			 if(effectNum<=0){
				 throw new ShopOperationException("更新店铺地址失败！");
			 }
				
			}
		}
		}catch(Exception e){
			throw new ShopOperationException("addShopError:"+e.getMessage());
			
		}
		
				
		return new ShopExecution(ShopStateEnum.CHECK,shop);
	}
	public void addShopImage(Shop shop,ImageHolder thumbnail){
		//获得shop图片的相对值地址
		System.out.println("22222222"+shop.getShopId());
		String dest=PathUtil.getShopImagePath(shop.getShopId());
		System.out.println("33333333   "+dest);
		String shopImgAddr=ImageUtil.generateThumbnail(thumbnail, dest);
		System.out.println("44444444   "+shopImgAddr);
		shop.setShopImg(shopImgAddr);
		System.out.println("55555555");
	}
	@Override
	public Shop queryById(long shopId) {
		
		return shopMapper.queryById(shopId);
	}

}
