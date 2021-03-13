package com.bin23.service;

import java.util.List;
import java.util.Map;

import com.bin23.entity.Link;

/**
 * ��������service�ӿ�
 * @author Administrator
 *
 */
public interface LinkService {

	/**
	 * ��������ѯ��������
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String, Object> map);
}
