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
public class GoodsViewController {
    
    
    @GetMapping(value={"goods/index"})
    public String goodsIndex() {
    	return "view/goods/goods-index.html";
    }
    @GetMapping(value={"goods/insert"})
    public String goodsInsert() {
    	return "view/goods/goods-insert.html";
    }
}
