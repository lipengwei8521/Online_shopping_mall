package com.lpw.hero.accepter.service;

import java.util.List;

import com.lpw.hero.accepter.bean.Accepter;

public interface AccepterService {
	
	/**
	 * 查询收货人信息
	 * 
	 * @param accepter
	 * @return
	 */
	public List<Accepter> getAccepterList(Accepter accepter);
}
