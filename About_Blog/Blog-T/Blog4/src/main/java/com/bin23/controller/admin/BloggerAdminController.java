package com.bin23.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bin23.service.BloggerService;

@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Resource
	private BloggerService bloggerService;
}
