package com.bin23.service;

import com.bin23.entity.Blogger;

/**
 * 博主service
 * @author Administrator
 *
 */
public interface BloggerService {

	/**
	 * 根据用户名查找博主
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);

	/**
	 * 获取博主信息
	 * @return
	 */
	public Blogger find();
}
