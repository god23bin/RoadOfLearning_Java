package com.bin23.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bin23.dao.LinkDao;
import com.bin23.entity.Link;
import com.bin23.service.LinkService;

/**
 * 友情链接service实现
 * @author Administrator
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService{

	@Resource
	private LinkDao linkDao;
	
	
	public List<Link> list(Map<String, Object> map) {
		return linkDao.list(map);
	}

}
