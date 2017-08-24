package com.funstill.customer.web.controller;

import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funstill.customer.base.model.PageResult;
import com.funstill.customer.module.model.Bill;
import com.funstill.customer.module.model.BillQuery;
import com.funstill.customer.module.service.BillService;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
@RequestMapping("bill")
public class BillController {

    @Resource
    private BillService billService;


    @GetMapping("/list")
    @ResponseBody
    public PageResult<Bill> list(BillQuery query) {
        int count = billService.selectCountList(query);
        if(count==0){
        	return PageResult.fetchPage(count,Collections.emptyList());
        }else{
        	return PageResult.fetchPage(count,billService.selectList(query));
        }
         
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(Bill bill) {
        return billService.insert(bill);
    }
    
    
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(Bill bill) {
        return billService.updateById(bill);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(Long id) {
        return billService.deleteById(id);
    }
    
}
