package com.lpw.hero.userinfo.mapper;

import com.lpw.hero.userinfo.bean.Userinfo;
import com.lpw.hero.userinfo.bean.UserinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息管理的核心DAO
 * 
 * @author ASUS
 *
 */
@Mapper
public interface UserinfoMapper {

	/**
	 * 根据分页和条件查询用户信息 
	 * sql编号 1
	 * 
	 * @param userinfo
	 * @return
	 */
	public List<Userinfo> getUserInfoList(Userinfo userinfo);

	/**
	 * 根据条件查询用户数量
	 * sql编号 2
	 * 
	 * @param userinfo
	 * @return
	 */
	public Long getUserInfoCount(Userinfo userinfo);

	/**
	 * 添加用户信息
	 * sql编号 3
	 * 
	 * @param userinfo
	 */
	public void adduserInfo(Userinfo userinfo);

	/**
	 * 根据条件查询用户信息
	 * sql编号 4
	 * 
	 * @param userinfo
	 */
	public Userinfo getUserInfo(Userinfo userinfo);

	/**
	 * 更新用户信息
	 * sql编号 5
	 * 
	 * @param userinfo
	 */
	public void updateUserInfo(Userinfo userinfo);

	/**
	 * 删除用户信息
	 * sql编号 6
	 * 
	 * @param userinfo
	 */
	public void deleteUserInfo(Userinfo userinfo);
}