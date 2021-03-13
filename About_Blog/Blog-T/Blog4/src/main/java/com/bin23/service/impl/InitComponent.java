package com.bin23.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bin23.entity.Blog;
import com.bin23.entity.BlogType;
import com.bin23.service.BlogService;
import com.bin23.service.BlogTypeService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.bin23.entity.Blogger;
import com.bin23.entity.Link;
import com.bin23.service.BloggerService;
import com.bin23.service.LinkService;

@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		BloggerService bloggerService=(BloggerService) applicationContext.getBean("bloggerService");
		Blogger blogger=bloggerService.find();
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);
		
		LinkService linkService=(LinkService) applicationContext.getBean("linkService");
		List<Link> linkList=linkService.list(null);
		application.setAttribute("linkList", linkList);

		BlogTypeService blogTypeService=(BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeCountList=blogTypeService.countList();
		application.setAttribute("blogTypeCountList", blogTypeCountList);

		BlogService blogService=(BlogService) applicationContext.getBean("blogService");
		List<Blog> blogCountList=blogService.countList();
		application.setAttribute("blogCountList", blogCountList);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
