package com.funstill.customer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.funstill.customer.module.model.CustomerQuery;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
public class PageController {

    @GetMapping(value={"/","/index"})
    public String index(CustomerQuery query) {
        return "view/index.html";
    }
    

}
