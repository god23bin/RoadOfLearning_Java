package com.bin23.controller;

import com.bin23.entity.Blog;
import com.bin23.entity.PageBean;
import com.bin23.service.BlogService;
import com.bin23.util.PageUtil;
import com.bin23.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private BlogService blogService;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value="page",required=false)String page, HttpServletRequest request) {
        if(StringUtil.isEmpty(page)) {
            page="1";
        }
        Map<String,Object> map=new HashMap<String,Object>();
        PageBean pageBean=new PageBean(Integer.parseInt(page),10);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Blog> blogList = blogService.list(map);

        for(Blog blog:blogList) {
            List<String> imageList = blog.getImageList();
            String blogInfo = blog.getContent();
            Document doc = Jsoup.parse(blogInfo);
            Elements jpgs = doc.select("img[src$=.jpg]");
            for(int i=0;i<jpgs.size();i++) {
                Element jpg = jpgs.get(i);
                imageList.add(jpg.toString());
                if(i==2) {
                    break;
                }
            }
        }

        ModelAndView mav=new ModelAndView();

        StringBuffer param=new StringBuffer();

        mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
        mav.addObject("blogList", blogList);
        mav.addObject("mainPage", "/foreground/blog/list.jsp");
        mav.addObject("pageTitle", "个人博客");
        mav.setViewName("mainTemp");
        return mav;
    }
}
