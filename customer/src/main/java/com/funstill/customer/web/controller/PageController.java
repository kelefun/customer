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
    
    @GetMapping(value={"bill/index"})
    public String billIndex() {
    	return "view/bill/bill-index.html";
    }
    @GetMapping(value={"bill/insert"})
    public String billInsert() {
    	return "view/bill/bill-insert.html";
    }
    
    
    @GetMapping(value={"goods/index"})
    public String goodsIndex() {
    	return "view/goods/goods-index.html";
    }
    @GetMapping(value={"goods/insert"})
    public String goodsInsert() {
    	return "view/goods/goods-insert.html";
    }
}
