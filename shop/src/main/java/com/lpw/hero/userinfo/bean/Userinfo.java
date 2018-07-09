package com.lpw.hero.userinfo.bean;

import java.io.Serializable;

import com.lpw.hero.utils.BaseBean;

/**
 * 用户信息
 * @author lpw
 *
 */
public class Userinfo extends BaseBean implements Serializable{
	// 用户id
    private Integer userId;
    // 用户名
    private String username;
    // 性别
    private String sex;
    // 手机号
    private String mobilephone;
    // 密码
    private String password;
    // 用户类型（1为买家。2为卖家）
    private String usertype;
    // 姓名
    private String name;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}