package com.lpw.hero.shopinfo.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lpw.hero.shopinfo.bean.Shopinfo;
import com.lpw.hero.shopinfo.mapper.ShopinfoMapper;
import com.lpw.hero.shopinfo.service.ShopInfoService;
import com.lpw.hero.utils.Const;
import com.lpw.hero.utils.FileNameCreator;
import com.lpw.hero.utils.PageBean;
import com.lpw.hero.utils.PageUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
@Service
public class ShopInfoServiceImpl implements ShopInfoService {
	
	@Autowired
	private ShopinfoMapper shopinfoMapper;
	
	@Override
	public String doPutToFileServer(MultipartFile file, String url) {

		String fileName = file.getOriginalFilename();
		String uploadUrl = FileNameCreator.creatRandomName(url, fileName);
		Client client = new Client();
		WebResource webResource = client.resource(uploadUrl);
		try {
			byte[] buf = file.getBytes();
			webResource.put(String.class,buf);
			return uploadUrl;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addShopInfo(Shopinfo shopinfo) throws Exception{
		shopinfo.setShopState(Const.SHOPINFO_SHOPSTATE_INIT);
		shopinfoMapper.addShopInfo(shopinfo);
		
	}
	@Cacheable(cacheNames="zj",key="#p0")
	@Override
	public PageBean<Shopinfo> getShopInfoList(Shopinfo shopinfo, Integer page) {
		// 总记录数
		int allRow = getUserInfoCount(shopinfo).intValue();
		// 总页数
		int totalPage = PageUtil.countTotalPage(allRow, Const.PAGE_SIZE);
		// 当前第几页
		int currentPage = PageUtil.countCurrentpage(page);
		// 起始记录数
		int start = PageUtil.countStart(Const.PAGE_SIZE, currentPage);
		if (page >= 0) {
			// 起始记录数
			shopinfo.setStart(start);
			// 每页显示
			shopinfo.setLength(Const.PAGE_SIZE);
		} else {
			// 起始记录数
			shopinfo.setStart(-1);
			// 每页显示
			shopinfo.setLength(-1);
		}

		// 记录
		List<Shopinfo> shops = shopinfoMapper.getShopInfoList(shopinfo);

		PageBean<Shopinfo> pageBean = new PageBean<Shopinfo>();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(shops);
		pageBean.setPageSize(Const.PAGE_SIZE);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public Long getUserInfoCount(Shopinfo shopinfo) {
		return shopinfoMapper.getShopInfoCount(shopinfo);
	}

	@Override
	public void updateShopInfo(Shopinfo shopinfo) throws Exception{
		shopinfoMapper.updateShopInfo(shopinfo);
	}

	@Override
	public Shopinfo getShopinfoByKey(Shopinfo shopInfo) {
		return shopinfoMapper.getShopinfoByKey(shopInfo);
	}

	@Override
	public List<Shopinfo> getFrontShopinfoList(Shopinfo shopinfo) {
		shopinfo.setShopState(Const.SHOPINFO_SHOPSTATE_ONLINE);
		shopinfo.setStart(-1);
		shopinfo.setLength(-1);
		List<Shopinfo> shopinfos = shopinfoMapper.getShopInfoList(shopinfo);
		return shopinfos;
	}

}
