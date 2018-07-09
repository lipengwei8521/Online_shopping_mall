package com.lpw.hero.shopinfo.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lpw.hero.shopinfo.bean.Shopinfo;
import com.lpw.hero.shopinfo.service.ShopInfoService;
import com.lpw.hero.utils.PageBean;

/**
 * 商品管理控制器
 * 
 * @author lpw
 *
 */
@Controller
@RequestMapping("/back/shopinfo/")
public class ShopInfoController {
	/**
	 * 文件服务器地址
	 */
	@Value("${FILE_SERVER_URL}")
	private String FILE_SERVER_URL;

	@Autowired
	private ShopInfoService shopInfoService;

	/**
	 * 加载商品添加页面
	 * 
	 * @return
	 */
	@RequestMapping("loadShopInfoAdd")
	public String loadadd() {
		return "back/shopinfo/shopinfo_add";
	}

	/**
	 * 上传商品预览图片
	 * 
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("uploadImg")
	@ResponseBody
	public String uploadImg(@RequestParam MultipartFile shopUrl) throws IOException {
		String url = shopInfoService.doPutToFileServer(shopUrl, FILE_SERVER_URL);
		return url;
	}
	
	/**
	 * 富文本编辑器上传图片
	 * 
	 * @param uploadfile
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("uploadFile")
	public void uploadFile(@RequestParam("upload") MultipartFile uploadfile,HttpServletRequest request,HttpServletResponse response) throws IOException {
		try {
			// 图片所存的路径
			String url = shopInfoService.doPutToFileServer(uploadfile, FILE_SERVER_URL);
			String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
			PrintWriter out = response.getWriter();
			// 对页面返回这个，才会实现图片的预览
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction("
                    + CKEditorFuncNum + ",'" + url + "','')");
            out.println("</script>");
            out.flush();
            out.close();
            return;
        } catch (Exception e) {
           e.printStackTrace();
        }
	}
	
	/**
	 * 添加商品信息
	 * 
	 * @param shopInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("addShopInfo")
	public String addShopInfo(Shopinfo shopinfo,Model model) {
		
		try {
			shopInfoService.addShopInfo(shopinfo);
			model.addAttribute("result", "添加商品成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("result", "添加商品失败");
		}
		return "/back/shopinfo/shopinfo_info";
	}
	
	/**
	 * 加载商品信息页面
	 * 
	 * @param shopinfo
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("loadShopinfoList")
	public String loadShopInfoList(Shopinfo shopinfo, Model model, Integer page) {
		PageBean<Shopinfo> pageBean = shopInfoService.getShopInfoList(shopinfo, page);
		model.addAttribute("pageBean", pageBean);
		// 保存查询条件供页面的分页标签使用
		model.addAttribute("shopinfo", shopinfo);
		return "back/shopinfo/shopinfo_list";
	}
	
	/**
	 * 加载商品休息修改页面
	 * 
	 * @return
	 */
	@RequestMapping("loadShopInfoUpdate")
	public String loadShopInfoUpdate(Shopinfo shopinfo,Model model) {
		Shopinfo shopinfo1 = shopInfoService.getShopinfoByKey(shopinfo);
		model.addAttribute("shopinfo", shopinfo1);
		return "back/shopinfo/shopinfo_update";
	}
	
	/**
	 * 更新商品信息
	 * 
	 * @param shopinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("updateShopInfo")
	public String updateShopInfo(Shopinfo shopinfo,Model model) {
		try {
			shopInfoService.updateShopInfo(shopinfo);
			model.addAttribute("result", "商品信息更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "商品信息更新失败");
		}
		return "back/shopinfo/shopinfo_info";
	}
	
	/**
	 * 商品上架
	 * 
	 * @param shopinfo
	 * @return
	 */
	@RequestMapping("putawayShopInfo")
	public String putawayShopInfo(Shopinfo shopinfo,Model model) {
		try {
			shopinfo.setShopState("2");
			shopInfoService.updateShopInfo(shopinfo);
			model.addAttribute("result", "商品上架成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "商品上架失败");
		}
		return "back/shopinfo/shopinfo_info";
	}
	
	/**
	 * 商品下架
	 * 
	 * @param shopinfo
	 * @return
	 */
	@RequestMapping("soldoutShopInfo")
	public String soldoutShopInfo(Shopinfo shopinfo,Model model) {
		try {
			shopinfo.setShopState("3");
			shopInfoService.updateShopInfo(shopinfo);
			model.addAttribute("result", "商品下架成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "商品下架失败");
		}
		return "back/shopinfo/shopinfo_info";
	}
	
}
