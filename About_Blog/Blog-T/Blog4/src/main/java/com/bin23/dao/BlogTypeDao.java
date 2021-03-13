package com.bin23.dao;

import com.bin23.entity.BlogType;

import java.util.List;

public interface BlogTypeDao {

    /**
     * 查询博客类别集合
     * @return
     */
    List<BlogType> countList();

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    public BlogType findById(Integer id);
}
