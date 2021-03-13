package com.bin23.service.impl;

import com.bin23.dao.BloggerDao;
import com.bin23.entity.Blogger;
import com.bin23.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService{
	
	@Resource
	private BloggerDao bloggerDao;

	public Blogger getByUserName(String userName) {
		return bloggerDao.getByUserName(userName);
	}

	public Blogger find() {
		return bloggerDao.find();
	}

}
