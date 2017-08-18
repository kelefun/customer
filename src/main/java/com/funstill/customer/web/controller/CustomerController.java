package com.funstill.customer.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funstill.customer.module.model.Customer;
import com.funstill.customer.module.service.CustomerService;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
public class CustomerController {

    @Resource
    private CustomerService customerService;


    @RequestMapping("test")
    @ResponseBody
    public Customer test() {
        return customerService.selectById(1L);
    }

}
