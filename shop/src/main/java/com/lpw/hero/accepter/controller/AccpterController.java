package com.lpw.hero.accepter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lpw.hero.accepter.bean.Accepter;
import com.lpw.hero.accepter.service.AccepterService;

/**
 * 收货人管理控制器
 * 
 * @author ASUS
 *
 */
@Controller
@RequestMapping("/back/accepter")
public class AccpterController {
	
	@Autowired
	private AccepterService accepterService;
	
	/**
	 * 加载收货人管理页面
	 * 
	 * @param accepter
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("loadAccpterList")
	public String loadAccpterList(Accepter accepter,Model model,Integer page) {
		List<Accepter> accepterList = accepterService.getAccepterList(accepter);
		model.addAttribute("accepterList", accepterList);
		
		return "back/accepter/accepter_list";
	}
}
