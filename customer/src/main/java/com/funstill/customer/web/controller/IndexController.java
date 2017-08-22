package com.funstill.customer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
public class IndexController {

    @GetMapping(value={"/","/index"})
    public String index() {
        return "view/index.html";
    }
    @GetMapping(value={"/login"})
    public String login() {
        return "view/login.html";
    }
    
}
