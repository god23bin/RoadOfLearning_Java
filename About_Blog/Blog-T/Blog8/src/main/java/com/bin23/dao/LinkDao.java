package com.bin23.dao;

import com.bin23.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * 友情链接dao接口
 * @author Administrator
 *
 */
public interface LinkDao {

	/**
	 * 按条件查询友情链接
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object> map);
}
