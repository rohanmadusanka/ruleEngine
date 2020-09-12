package com.hcloud.ruleengine.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcloud.ruleengine.model.Reshma;
import com.hcloud.ruleengine.model.TrustedServerZone;
import com.hcloud.ruleengine.service.ReshmaService;
import com.hcloud.ruleengine.service.TrustedServerService;

@Controller
public class HomeController {
		
	@Autowired
	private TrustedServerService trustedServerService;
	
	@Autowired
	private ReshmaService reshmaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	
	@RequestMapping(value = "/Reshma", method = RequestMethod.GET)
	public String reshma(Model model) {
		List<Reshma> list = reshmaService.getAllReshma();
		 
	     model.addAttribute("reshmas", list);
	     Reshma reshma = new Reshma();
			model.addAttribute("reshma", reshma);
		return "Reshma";
	}
	
	@RequestMapping(value = "/TrustedServers", method = RequestMethod.GET)
	public String trustedServer(Model model) {
		
		List<TrustedServerZone> list = trustedServerService.getTrustedServers();
		 
	     model.addAttribute("TrustedServers", list);
	     TrustedServerZone tsz = new TrustedServerZone();
			model.addAttribute("tsz", tsz);
		return "TrustedServers";
	}
	
}
