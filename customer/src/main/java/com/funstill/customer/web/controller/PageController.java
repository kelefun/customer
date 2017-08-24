package com.funstill.customer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
@RequestMapping("view")
public class PageController {

    @GetMapping(value={"customer/index"})
    public String index() {
        return "view/customer/customer-index.html";
    }
    @GetMapping(value={"customer/insert"})
    public String insert() {
        return "view/customer/customer-insert.html";
    }
    
}
