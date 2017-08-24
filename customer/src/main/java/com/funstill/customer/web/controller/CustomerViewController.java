package com.funstill.customer.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.funstill.customer.module.service.CustomerService;

/**
 * @author liukaiyang
 * @version v1.0.0
 */
@Controller
@RequestMapping("view")
public class CustomerViewController {

	@Resource
	private CustomerService customerService;

	@GetMapping(value = { "customer/index" })
	public String customerIndex() {
		return "view/customer/customer-index.html";
	}

	@GetMapping(value = { "customer/insert" })
	public String customerInsert() {
		return "view/customer/customer-insert.html";
	}

	@GetMapping(value = { "customer/update" })
	public String customerUpdate(Model model, @RequestParam Long id) {
//		model.addAttribute("test", "test33");//页面取值用 ${test)
//		model.addAttribute("test33");//页面取值用 ${string)
		model.addAttribute(customerService.selectById(id));//页面取值用customer.mobile等
		return "view/customer/customer-update.html";
	}

}
