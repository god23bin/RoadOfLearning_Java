package com.bin23.controller;

import com.bin23.entity.Blog;
import com.bin23.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource
	private BlogService blogService;

	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable(value="id")Integer id) {
		ModelAndView mav=new ModelAndView();

		Blog blog = blogService.findById(id);
		mav.addObject("blog", blog);
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);

		mav.addObject("mainPage", "/foreground/blog/view.jsp");
		mav.addObject("pageTitle", blog.getTitle()+"个人博客");
		mav.setViewName("mainTemp");
		return mav;
	}
}
