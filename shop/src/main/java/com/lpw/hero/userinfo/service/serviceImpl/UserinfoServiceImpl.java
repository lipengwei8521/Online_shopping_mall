package com.lpw.hero.userinfo.service.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.userinfo.mapper.UserinfoMapper;
import com.lpw.hero.userinfo.service.UserInfoService;
import com.lpw.hero.utils.Const;
import com.lpw.hero.utils.PageBean;
import com.lpw.hero.utils.PageUtil;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Service
public class UserinfoServiceImpl implements UserInfoService {

	@Autowired
	private UserinfoMapper userinfoMapper;
	
	@Cacheable(cacheNames="zj",key="#p0")
	@Override
	public PageBean<Userinfo> getUserInfoList(Userinfo userinfo, Integer page) {
		// 总记录数
		int allRow = getUserInfoCount(userinfo).intValue();
		// 总页数
		int totalPage = PageUtil.countTotalPage(allRow, Const.PAGE_SIZE);
		// 当前第几页
		int currentPage = PageUtil.countCurrentpage(page);
		// 起始记录数
		int start = PageUtil.countStart(Const.PAGE_SIZE, currentPage);
		if (page >= 0) {
			// 起始记录数
			userinfo.setStart(start);
			// 每页显示
			userinfo.setLength(Const.PAGE_SIZE);
		} else {
			// 起始记录数
			userinfo.setStart(-1);
			// 每页显示
			userinfo.setLength(-1);
		}

		// 记录
		List<Userinfo> users = userinfoMapper.getUserInfoList(userinfo);

		PageBean<Userinfo> pageBean = new PageBean<Userinfo>();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(users);
		pageBean.setPageSize(Const.PAGE_SIZE);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public Long getUserInfoCount(Userinfo userinfo) {
		return userinfoMapper.getUserInfoCount(userinfo);
	}
	
	@CacheEvict(cacheNames="zj",allEntries=true)
	@Override
	public void addUsers(MultipartFile users) throws Exception {
		// 从文件的输入流获取excel文件
		Workbook workbook = Workbook.getWorkbook(users.getInputStream());
		// 获取第0个sheet
		Sheet sheet = workbook.getSheet(0);
		System.out.println("rows:" + sheet.getRows());
		System.out.println("cols:" + sheet.getColumns());
		// 每一行舍弃表头
		for (int i = 1; i < sheet.getRows(); i++) {
			Userinfo userinfo = new Userinfo();

			// 姓名,(列，行)
			Cell usernameCell = sheet.getCell(0, i);
			String username = usernameCell.getContents();
			userinfo.setUsername(username);

			// 性别,(列，行)
			Cell sexCell = sheet.getCell(1, i);
			String sex = sexCell.getContents();
			userinfo.setSex(sex);

			// 手机号,(列，行)
			Cell mobilephoneCell = sheet.getCell(2, i);
			String mobilephone = mobilephoneCell.getContents();
			userinfo.setMobilephone(mobilephone);

			// 用户类型,(列，行)
			Cell typeCell = sheet.getCell(3, i);
			String type = typeCell.getContents();
			userinfo.setUsertype(type);

			// 名字,(列，行)
			Cell nameCell = sheet.getCell(4, i);
			String name = nameCell.getContents();
			userinfo.setName(name);

			// 设置密码，密码为默认
			userinfo.setPassword("888888");
			userinfoMapper.adduserInfo(userinfo);
		}
		workbook.close();
	}
	@CacheEvict(cacheNames="zj",allEntries=true)
	@Override
	public void addUser(Userinfo userinfo) throws Exception {
		userinfoMapper.adduserInfo(userinfo);
	}

	@Override
	public File creatDownloadFile(List<Userinfo> users) throws Exception {
		// 生成一个临时文件
		File file = File.createTempFile("tempausers", ".xls");
		// 生成一个可写的excel
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// 生成一个可写的sheet
		WritableSheet sheet = workbook.createSheet("sheet", 0);
		// 标题
		String[] titles = { "用户名", "密码", "名字", "性别", "手机号", "用户类型" };
		// 把表弟放入第一行
		for (int i = 0; i < titles.length; i++) {
			// 第0行第i列
			Label label = new Label(i, 0, titles[i]);
			sheet.addCell(label);
		}
		for (int i = 0; i < users.size(); i++) {
			// 用户名
			sheet.addCell(new Label(0, i + 1, users.get(i).getUsername()));
			// 密码
			sheet.addCell(new Label(1, i + 1, users.get(i).getPassword()));
			// 名字
			sheet.addCell(new Label(2, i + 1, users.get(i).getName()));
			// 性别
			sheet.addCell(new Label(3, i + 1, users.get(i).getSex()));
			// 手机号
			sheet.addCell(new Label(4, i + 1, users.get(i).getMobilephone()));
			// 用户类型
			sheet.addCell(new Label(5, i + 1, users.get(i).getUsertype()));
		}

		workbook.write();
		workbook.close();

		return file;
	}

	@Override
	public boolean validatorUsername(Userinfo userinfo) {
		Userinfo puser = userinfoMapper.getUserInfo(userinfo);
		if(puser == null) {
			return true;
		}else {
			return false;
		}
	}
	
	@CacheEvict(cacheNames="zj",allEntries=true)
	@Override
	public Userinfo loadUpdateUserInfo(Userinfo userinfo) {
		return userinfoMapper.getUserInfo(userinfo);
	}
	
	@CacheEvict(cacheNames="zj",allEntries=true)
	@Override
	public void updateUserInfo(Userinfo userinfo) throws Exception {
		userinfoMapper.updateUserInfo(userinfo);
	}
	
	@CacheEvict(cacheNames="zj",allEntries=true)
	@Override
	public void deleteUserInfo(Userinfo userinfo) throws Exception {
		userinfoMapper.deleteUserInfo(userinfo);
	}

	@Override
	public Userinfo doLogin(Userinfo userinfo) {
		return userinfoMapper.getUserInfo(userinfo);
	}

}
