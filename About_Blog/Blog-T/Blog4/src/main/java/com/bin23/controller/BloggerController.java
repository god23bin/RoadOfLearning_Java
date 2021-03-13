package com.bin23.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bin23.entity.Blogger;
import com.bin23.service.BloggerService;
import com.bin23.util.CryptographyUtil;

/**
 * 博主controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Resource
	private BloggerService bloggerService;
	
	
	@RequestMapping("/login")
	public String login(Blogger blogger,HttpServletRequest request) {
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "rui1024"));
		try {
			subject.login(token);
			return "redirect:/admin/main.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("blogger",blogger);
			request.setAttribute("errorInfo", "用户名或密码错误！");
			return "login";
		}
	}
}
