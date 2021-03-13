package com.bin23.service;

import com.bin23.entity.BlogType;

import java.util.List;

public interface BlogTypeService {
    /**
     * 查询博客类别集合
     * @return
     */
    public List<BlogType> countList();

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    public BlogType findById(Integer id);
}
