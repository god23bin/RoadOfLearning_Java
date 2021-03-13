package com.bin23.service.impl;

import com.bin23.dao.LinkDao;
import com.bin23.entity.Link;
import com.bin23.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
