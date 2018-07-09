package com.lpw.hero.utils;

import java.io.Serializable;

/**
 * 基本类
 * @author 
 *
 */
public class BaseBean implements Serializable{
	private Integer start;
	private Integer length;
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
}
