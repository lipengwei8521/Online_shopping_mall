package com.lpw.hero.userinfo.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.utils.PageBean;

/**
 * 用户管理的核心业务接口
 * 
 * @author lpw
 *
 */
public interface UserInfoService {
	/**
	 * 根据条件、分页信息查询用户数据;page=-1时不做分页查询
	 * 
	 * @param userinfo
	 * @param page
	 * @return
	 */
	public PageBean<Userinfo> getUserInfoList(Userinfo userinfo, Integer page);

	/**
	 * 根据条件查询用户记录数
	 * 
	 * @param userinfo
	 * @return
	 */
	public Long getUserInfoCount(Userinfo userinfo);

	/**
	 * 解析excel文件，批量添加用户
	 * 
	 * @param users
	 */
	public void addUsers(MultipartFile users) throws Exception;

	/**
	 * 添加用户
	 */
	public void addUser(Userinfo userinfo) throws Exception;

	/**
	 * 生成代下载的excel文件
	 * 
	 * @param users
	 * @return
	 */
	public File creatDownloadFile(List<Userinfo> users) throws Exception;

	/**
	 * 验证用户名是否可用true可用，false不可用
	 * 
	 * @param userinfo
	 * @return
	 */
	public boolean validatorUsername(Userinfo userinfo);

	/**
	 * 加载待修改的用户信息
	 * 
	 * @param userinfo
	 * @return
	 */
	public Userinfo loadUpdateUserInfo(Userinfo userinfo);

	/**
	 * 修改用户信息
	 * 
	 * @param userinfo
	 */
	public void updateUserInfo(Userinfo userinfo) throws Exception;

	/**
	 * 删除用户信息
	 * 
	 * @param userinfo
	 * @throws Exception
	 */
	public void deleteUserInfo(Userinfo userinfo) throws Exception;
	
	/**
	 * 用户登录
	 * 
	 * @param userinfo
	 * @return
	 */
	public Userinfo doLogin(Userinfo userinfo);
}
