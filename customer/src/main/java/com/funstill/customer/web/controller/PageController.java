package com.funstill.customer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
public class PageController {
	  @GetMapping(value={"/","/index"})
	    public String index() {
	        return "view/index.html";
	    }
	    /**
	     * 登录页面
	     * @author liukaiyang 2017年8月22日
	     * @return
	     */
	    @GetMapping(value={"view/login"})
	    public String getLoginView() {
	        return "view/login.html";
	    }
	    
	 
}
