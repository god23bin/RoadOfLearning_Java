package com.bin23.service;

import com.bin23.entity.Link;

import java.util.List;
import java.util.Map;

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
