package com.lpw.hero.front.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lpw.hero.accepter.bean.Accepter;
import com.lpw.hero.accepter.service.AccepterService;
import com.lpw.hero.orderinfo.bean.Orderinfo;
import com.lpw.hero.shopinfo.bean.Shopinfo;
import com.lpw.hero.userinfo.bean.Userinfo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AccepterService accepterService;
	
	/**
	 * 结算订单
	 * 
	 * @param keys
	 * @param number
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("orderCheck")
	public String orderCheck(String[] keys, Integer[] num, HttpSession session, Model model) {
		Map<String, Shopinfo> cart = (Map<String, Shopinfo>) session.getAttribute("cart");

		// 总价
		String sum = "0";

		List<Orderinfo> orderinfoList = new ArrayList<Orderinfo>();
		for (int i = 0; i < num.length; i++) {
			// 订单项
			Orderinfo orderinfo = new Orderinfo();
			Shopinfo shopinfo = cart.get(keys[i]);
			orderinfo.setShopId(shopinfo.getShopId());
			orderinfo.setShopPrice(Double.valueOf(shopinfo.getPrice()));
			orderinfo.setShopName(shopinfo.getShopName());
			orderinfo.setOrderShopimg(shopinfo.getShopImg());
			System.out.println("========="+orderinfo.getOrderShopimg());
			
			orderinfo.setShopNum(num[i]);
			orderinfoList.add(orderinfo);
			sum = num[i] * Integer.parseInt(shopinfo.getPrice()) + "";
		}

		// 购买商品的总数量

		int number = 0;
		for (int i = 0; i < num.length; i++) {
			number = number + num[i];
			System.out.println("+++++++===="+number);
		}

		model.addAttribute("list", orderinfoList);
		model.addAttribute("sum", sum);
		model.addAttribute("number", number);
		
		Accepter accepter = new Accepter();
		Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
		accepter.setUserId(userinfo.getUserId());
		List<Accepter> accepterList = accepterService.getAccepterList(accepter);
		model.addAttribute("accepterList", accepterList);
		return "front/orderinfo";
	}
}
