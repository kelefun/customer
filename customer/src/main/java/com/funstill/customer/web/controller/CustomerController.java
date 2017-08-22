package com.funstill.customer.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.funstill.customer.module.model.Customer;
import com.funstill.customer.module.model.CustomerQuery;
import com.funstill.customer.module.service.CustomerService;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;


    @GetMapping("/list")
    @ResponseBody
    public List<Customer> list(CustomerQuery query) {
        return customerService.selectList(query);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(Customer customer) {
        return customerService.insert(customer);
    }
    
    
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(Customer customer) {
        return customerService.updateById(customer);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(Long id) {
        return customerService.deleteById(id);
    }
    
    
    @GetMapping("/test")
    @ResponseBody
    public JSONObject test() {
    	List<Customer> cusList =new ArrayList<>();
    	for(int i=1;i<15;i++){
    		Customer cus = new Customer();
    		cus.setExtra("哈哈");
    		cus.setRealname("张三丰"+i);
    		cusList.add(cus);
    	}
    	
    	JSONObject json  = new JSONObject();
    	json.put("code", "0");
    	json.put("msg", "");
    	json.put("count", "1000");
    	json.put("data", cusList);
        return json;
    }
}
