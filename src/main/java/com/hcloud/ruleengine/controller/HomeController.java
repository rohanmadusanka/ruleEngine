package com.hcloud.ruleengine.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hcloud.ruleengine.service.ReshmaService;

@Controller
public class HomeController {
		
	@Autowired
	private ReshmaService reshmaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
}
