package com.lpw.hero.shopinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lpw.hero.shopinfo.bean.Shopinfo;
import com.lpw.hero.userinfo.bean.Userinfo;

@Mapper
public interface ShopinfoMapper {

	/**
	 * 添加商品信息
	 * sql 编号 1
	 * 
	 * @param shopInfo
	 */
	public void addShopInfo(Shopinfo shopInfo);
	
	/**
	 * 根据分页和条件查询商品信息 
	 * sql编号 2
	 * 
	 * @param userinfo
	 * @return
	 */
	public List<Shopinfo> getShopInfoList(Shopinfo shopInfo);

	/**
	 * 根据条件查询商品数量
	 * sql编号 3
	 * 
	 * @param userinfo
	 * @return
	 */
	public Long getShopInfoCount(Shopinfo shopInfo);
	
	/**
	 * 更新商品信息
	 * sql编号 4
	 * 
	 * @param userinfo
	 */
	public void updateShopInfo(Shopinfo shopInfo);
	
	/**
	 * 根据主键查询商品信息
	 * sql编号 5
	 * 
	 * @param key
	 * @return
	 */
	public Shopinfo getShopinfoByKey(Shopinfo shopInfo);

}