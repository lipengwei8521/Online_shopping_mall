package com.lpw.hero.back.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.userinfo.service.UserInfoService;

/**
 * 后台管理控制器
 * 
 * @author lpw
 *
 */
@Controller
@RequestMapping("/back")
public class BackController {

	@Autowired
	private UserInfoService userinfoService;

	/**
	 * 加载登录界面
	 * 
	 * @param userinfo
	 * @return
	 */
	@RequestMapping("loadBackLogin")
	public String loadBackLogin() {
		return "back/login";
	}

	/**
	 * 验证卖家用户
	 * 
	 * @param userinfo
	 * @return
	 */
	@RequestMapping("backLogin")
	public String backLogin(Userinfo userinfo, HttpSession session, Model model) {
		Userinfo loginUser = userinfoService.doLogin(userinfo);
		if (loginUser != null) {
			// 判断是否为卖家
			if ("2".equals(loginUser.getUsertype())) {
				session.setAttribute("userinfo", loginUser);
				return loadMain();
			} else {
				model.addAttribute("message", "该用户不是商家……");
			}
		} else {
			model.addAttribute("message", "用户名或密码错误，请重新输入……");
			return "back/login";
		}
		return "";
	}

	/**
	 * 加载主页
	 * 
	 * @return
	 */
	@RequestMapping("loadMian")
	public String loadMain() {
		return "back/home";
	}

}
