package com.lpw.hero.userinfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.userinfo.service.UserInfoService;
import com.lpw.hero.utils.PageBean;

/**
 * 后台用户管理的核心控制器
 * 
 * @author lpw
 *
 */
@Controller
@RequestMapping("/back/userinfo/")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	/**
	 * 主页的main
	 * 
	 * @return
	 */
	@RequestMapping("main")
	public String main() {
		return "main";
	}

	/**
	 * 根据条件、分页查询用户信息
	 * 
	 * @param userinfo
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(Userinfo userinfo, Model model, Integer page) {
		PageBean<Userinfo> pageBean = userInfoService.getUserInfoList(userinfo, page);
		model.addAttribute("pageBean", pageBean);
		// 保存查询条件供页面的分页标签使用
		model.addAttribute("userinfo", userinfo);
		return "back/userinfo/userinfo_list";
	}

	/**
	 * 加载新增用户界面
	 * 
	 * @return
	 */
	@RequestMapping("loadAddUser")
	public String loadAddUser() {
		return "/back/userinfo/userinfo_add";
	}

	/**
	 * 增加新用户
	 * 
	 * @param userinfo
	 * @return
	 */
	@RequestMapping("addUser")
	public String addUser(Userinfo userinfo, Model model) {
		if ("".equals(userinfo.getPassword())) {
			userinfo.setPassword("888888");
		}
		try {
			userInfoService.addUser(userinfo);
			model.addAttribute("result", "新增用户成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("result", "新增用户失败");
			e.printStackTrace();
		}
		return "back/userinfo/userinfo_info";
	}

	/**
	 * 批量添加新用户
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping("importUsers")
	public String importUsers(@RequestParam MultipartFile users, Model model) {
		try {
			userInfoService.addUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list(new Userinfo(), model, 1);
	}

	/**
	 * 导出查询出来的数据
	 * 
	 * @param userinfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("exportUsers")
	public String exportUsers(Userinfo userinfo, HttpServletResponse response) {
		// 当page为-1时，不分页
		PageBean<Userinfo> pageBean = userInfoService.getUserInfoList(userinfo, -1);
		List<Userinfo> list = pageBean.getList();
		try {
			File file = userInfoService.creatDownloadFile(list);
			FileInputStream fis = new FileInputStream(file);
			response.setContentType("application/fprce-download");
			response.addHeader("Content-disposition", "attachment;fileName=userinfo-export.xls");
			OutputStream os = response.getOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = fis.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 验证用户名的唯一
	 * 
	 * @return
	 */
	@RequestMapping("validatorUsername")
	@ResponseBody
	public String validatorUsername(Userinfo userinfo) {
		System.out.println("========" + userinfo.getUsername());

		boolean flag = userInfoService.validatorUsername(userinfo);
		if (flag) {
			return "该用户名可以使用";
		} else {
			return "该用户名已被使用";
		}
	}

	/**
	 * 加载待修改的用户信息
	 * 
	 * @param userinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("loadUpdateUserInfo")
	public String loadUpdateUserInfo(Userinfo userinfo, Model model) {
		Userinfo user = userInfoService.loadUpdateUserInfo(userinfo);
		model.addAttribute("user", user);
		return "back/userinfo/userinfo_update";
	}

	/**
	 * 更新用户信息
	 * 
	 * @param userinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("updateUserInfo")
	public String updateUserinfo(Userinfo userinfo, Model model) {
		try {
			userInfoService.updateUserInfo(userinfo);
			model.addAttribute("result", "修改用户信息成功");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("result", "修改用户信息失败");
		}
		return "back/userinfo/userinfo_info";
	}
	
	/**
	 * 用户信息的删除
	 * @return
	 */
	@RequestMapping("deleteUserInfo")
	public String deleteUserInfo(Userinfo userinfo, Model model) {
		try {
			userInfoService.deleteUserInfo(userinfo);
			model.addAttribute("result", "删除用户信息成功");
		} catch (Exception e) {
			model.addAttribute("result", "删除用户信息失败");
		}
		return "back/userinfo/userinfo_info";
		
	}

}
