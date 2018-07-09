package com.lpw.hero.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lpw.hero.shopinfo.bean.Shopinfo;
import com.lpw.hero.shopinfo.service.ShopInfoService;
import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.userinfo.service.UserInfoService;

@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired
	private ShopInfoService shopinfoService;
	
	@Autowired
	private UserInfoService userinfoService;
	/**
	 * 加载前台界面
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index(Model model) {
		List<Shopinfo> shopinfos = shopinfoService.getFrontShopinfoList(new Shopinfo());
		model.addAttribute("shopinfos",shopinfos );
		return "front/index";
	}
	
	/**
	 * 加载详情页面
	 * 
	 * @param shopId
	 * @param model
	 * @return
	 */
	@RequestMapping("shopinfo/{shopId}")
	public String getShopInfo(@PathVariable Integer shopId,Model model) {
		Shopinfo selectShopinfo = new Shopinfo();
		selectShopinfo.setShopId(shopId);
		Shopinfo shopinfo = shopinfoService.getShopinfoByKey(selectShopinfo);
		model.addAttribute("shopinfo", shopinfo);
		return "front/shopinfo_detail";
	}
	
	/**
	 * 加载购物车页面
	 * 
	 * @return
	 */
	@RequestMapping("loadShoppingcart")
	public String loadShoppingcart() {
		return "front/shoppingcart";
	}
	
	
	/**
	 * 商品加入购物车
	 * 
	 * @return
	 */
	@RequestMapping("addToCat/{shopId}")
	public String addToCat(@PathVariable Integer shopId, Model model, HttpSession session) {
		Map<String, Shopinfo> cart = (Map<String, Shopinfo>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<String, Shopinfo>();
			session.setAttribute("cart", cart);
		}
		Shopinfo shopinfo = new Shopinfo();
		shopinfo.setShopId(shopId);
		shopinfo = shopinfoService.getShopinfoByKey(shopinfo);
		
		cart.put(shopId+shopinfo.getShopName(), shopinfo);
		return "front/shoppingcart";
	}

	/**
	 * 删除选中的商品
	 * 
	 * @param keys
	 * @param session
	 * @return
	 */
	@RequestMapping("cart/deleteShop")
	public String cartDelete(String[] keys, HttpSession session) {
		Map<String, Shopinfo> cart = (Map<String, Shopinfo>) session.getAttribute("cart");
		if (keys != null) {
			for (String key : keys) {
				cart.remove(key);
			}
		}
		return "front/shoppingcart";
	}
	
	/**
	 * 加载登录页面
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "front/login";
	}
	
	/**
	 * 用户登录
	 * 
	 * @param userinfo
	 * @return
	 */
	@RequestMapping("doLogin")
	public String doLogin(Userinfo userinfo,HttpSession session,Model model) {
		Userinfo loginUser = userinfoService.doLogin(userinfo);
		if(loginUser != null) {
			session.setAttribute("userinfo", loginUser);
			return index(model);
		}else {
			return "front/login";
		}
	}
	
	/**
	 * 注销用户
	 * @param userinfo
	 * @return
	 */
	@RequestMapping("loginOut")
	public String loginOut(@RequestParam("username") String username,HttpSession session) {
		session.removeAttribute("userinfo");
		return "front/login";
	}
	
}
