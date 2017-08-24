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
public class BillViewController {
    
    @GetMapping(value={"bill/index"})
    public String billIndex() {
    	return "view/bill/bill-index.html";
    }
    @GetMapping(value={"bill/insert"})
    public String billInsert() {
    	return "view/bill/bill-insert.html";
    }
    
}
