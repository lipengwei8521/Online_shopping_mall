package com.lpw.hero.shopinfo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lpw.hero.shopinfo.bean.Shopinfo;
import com.lpw.hero.utils.PageBean;

/**
 * 商品管理的业务接口
 * @author lpw
 *
 */
public interface ShopInfoService {
	
	/**
	 * 向文件服务器发送file
	 * 
	 * @param file
	 * @return
	 */
	public String doPutToFileServer(MultipartFile file, String url);
	
	/**
	 * 添加商品信息
	 * 
	 * @param shopinfo
	 */
	public void addShopInfo(Shopinfo shopinfo) throws Exception;
	
	/**
	 * 根据条件、分页信息查询商品数据;page=-1时不做分页查询
	 * 
	 * @param userinfo
	 * @param page
	 * @return
	 */
	public PageBean<Shopinfo> getShopInfoList(Shopinfo shopinfo, Integer page);

	/**
	 * 根据条件查询商品种类数量
	 * 
	 * @param userinfo
	 * @return
	 */
	public Long getUserInfoCount(Shopinfo shopinfo);
	
	/**
	 * 更新商品信息
	 * 
	 * @param shopinfo
	 */
	public void updateShopInfo(Shopinfo shopinfo) throws Exception;
	
	/**
	 * 根据主键查询商品信息
	 * 
	 * @param shopInfo
	 * @return
	 */
	public Shopinfo getShopinfoByKey(Shopinfo shopInfo);
	
	/**
	 * 商城首页展示信息
	 * 
	 * @param shopinfo
	 */
	public List<Shopinfo> getFrontShopinfoList(Shopinfo shopinfo);
}
