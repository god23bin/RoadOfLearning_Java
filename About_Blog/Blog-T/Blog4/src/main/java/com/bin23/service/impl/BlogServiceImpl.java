package com.bin23.service.impl;

import com.bin23.dao.BlogDao;
import com.bin23.entity.Blog;
import com.bin23.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    public List<Blog> countList() {
        return blogDao.countList();
    }

    public List<Blog> list(Map<String, Object> map) {
        return blogDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return blogDao.getTotal(map);
    }

    public Blog findById(Integer id) {
        return blogDao.findById(id);
    }

    public Integer update(Blog blog) {
        return blogDao.update(blog);
    }
}
