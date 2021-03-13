package com.bin23.service.impl;

import com.bin23.dao.BlogTypeDao;
import com.bin23.entity.BlogType;
import com.bin23.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeDao blogTypeDao;

    @Override
    public List<BlogType> countList() {
        return blogTypeDao.countList();
    }
}
