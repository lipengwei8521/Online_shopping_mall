package com.lpw.hero.accepter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpw.hero.accepter.bean.Accepter;
import com.lpw.hero.accepter.mapper.AccepterMapper;
import com.lpw.hero.accepter.service.AccepterService;

/**
 * 收货人的业务管理器
 * 
 * @author lpw
 *
 */
@Service
public class AccepterServiceImpl implements AccepterService{
	
	@Autowired
	private AccepterMapper accepterMapper;
	
	@Override
	public List<Accepter> getAccepterList(Accepter accepter) {
		return accepterMapper.getAccepterList(accepter);
	}
	

}
