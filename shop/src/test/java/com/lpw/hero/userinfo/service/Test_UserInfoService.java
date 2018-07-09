package com.lpw.hero.userinfo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lpw.hero.shopinfo.service.ShopInfoService;
import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.utils.Const;
import com.lpw.hero.utils.PageBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_UserInfoService {
	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void getUserInfoListTest() {
		Userinfo userinfo = new Userinfo();
		int page = 0;
		
		PageBean<Userinfo> pageBean = userInfoService.getUserInfoList(userinfo, page);
		System.out.println("当前共有"+pageBean.getAllRow() +"条数据");
		System.out.println("当前是第"+pageBean.getCurrentPage() +"页");
		System.out.println("总共有"+pageBean.getTotalPage() +"页");
		
		List<Userinfo> users = pageBean.getList();
		for (Userinfo userinfo2 : users) {
			System.out.println("userinfo.name ="+userinfo2.getUsername());
		}
	}
}
