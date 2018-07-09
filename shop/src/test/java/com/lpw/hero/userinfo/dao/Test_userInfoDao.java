package com.lpw.hero.userinfo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.userinfo.mapper.UserinfoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_userInfoDao {
	
	@Autowired
	private UserinfoMapper userinfoMapper;
	
	@Test
	public void getUserInfoList() {
		Userinfo userinfo = new Userinfo();
		userinfo.setStart(0);
		userinfo.setLength(2);
		userinfo.setUsername("张");
		List<Userinfo> list = userinfoMapper.getUserInfoList(userinfo);
		for (Userinfo userinfo2 : list) {
			System.out.println("u.uname ========================================================= "+userinfo2.getUsername());
		}
	}
}
