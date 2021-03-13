package com.bin23.controller;

import com.bin23.entity.Blog;
import com.bin23.entity.Blogger;
import com.bin23.service.BlogService;
import com.bin23.service.BloggerService;
import com.bin23.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
