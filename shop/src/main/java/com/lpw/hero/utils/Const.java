package com.lpw.hero.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * 常量类
 * 
 * @author lpw
 *
 */
public class Const {
	/**
	 * 每页展示的数据个数
	 */
	public static final int PAGE_SIZE = 2;
	
	/**
	 * 用户类型：顾客
	 */
	public static final int USER_TYPE_CUSTOMER = 1;
	
	/**
	 * 用户类型：卖家
	 */
	public static final int USER_TYPE_ADMIN = 2;
	
	/**
	 * 用户性别：男
	 */
	public static final String USER_SEX_NAN = "1";
	
	/**
	 * 用户性别：女
	 */
	public static final String USER_SEX_NV = "0";
	
	/**
	 * 商品初始化状态
	 */
	public static final String SHOPINFO_SHOPSTATE_INIT = "1";
	
	/**
	 * 商品状态：上架
	 */
	public static final String SHOPINFO_SHOPSTATE_ONLINE = "2";
	
	/**
	 * 商品状态：下架
	 */
	public static final String SHOPINFO_SHOPSTATE_OFF = "3";
}
