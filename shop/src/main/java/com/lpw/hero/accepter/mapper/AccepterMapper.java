package com.lpw.hero.accepter.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lpw.hero.accepter.bean.Accepter;
import com.lpw.hero.userinfo.bean.Userinfo;

@Mapper
public interface AccepterMapper {
	/**
	 * 根据分页和条件查询收货人信息 
	 * sql编号 1
	 * 
	 * @param userinfo
	 * @return
	 */
	public List<Accepter> getAccepterList(Accepter accepter);

	/**
	 * 根据条件查询收货人数量
	 * sql编号 2
	 * 
	 * @param userinfo
	 * @return
	 */
	public Long getAccepterCount(Accepter accepter);

	/**
	 * 添加收货人信息
	 * sql编号 3
	 * 
	 * @param userinfo
	 */
	public void addAccepter(Accepter accepter);

	/**
	 * 更新收货人信息
	 * sql编号 5
	 * 
	 * @param userinfo
	 */
	public void updateAccepter(Accepter accepter);

	/**
	 * 删除收货人信息
	 * sql编号 6
	 * 
	 * @param userinfo
	 */
	public void deleteAccepter(Accepter accepter);
}