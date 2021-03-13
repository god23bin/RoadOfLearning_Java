package com.bin23.dao;

import com.bin23.entity.Blogger;

/**
 * ����dao
 * @author Administrator
 *
 */
public interface BloggerDao {

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
