package com.bin23.service;

import com.bin23.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {
    /**
     * 查询博客集合
     * @return
     */
    public List<Blog> countList();

    /**
     * 获取博客列表
     * @param map
     * @return
     */
    public List<Blog> list(Map<String, Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String, Object> map);
}
