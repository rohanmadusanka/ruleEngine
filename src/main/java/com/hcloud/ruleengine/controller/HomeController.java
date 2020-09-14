package com.hcloud.ruleengine.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping(value = "/saveReshma")
	public String addReshma(@ModelAttribute("reshma") Reshma reshma, HttpServletRequest request) {
		
		reshmaService.save(reshma);
		return "redirect:/Reshma";
	
	}
	
	@PostMapping(value = "/updateReshma")
	public String updateReshma(@RequestParam("updateid") long id,@RequestParam("updateIpRange") String updateIpRange,@RequestParam("updateZoneName") String updateZoneName,@RequestParam("updateAppType") String updateAppType,@RequestParam("updateDCLocation") String updateDCLocation,@RequestParam("updateClusterName") String updateClusterName,@RequestParam("updateAppEnvironment") String updateAppEnvironment,@RequestParam("updateTier") String updateTier,@RequestParam("updateName") String updateName) throws ParseException {
		 
		Reshma reshma = new Reshma();
		reshma.setId(id);
		reshma.setIpRange(updateIpRange);
		reshma.setZoneName(updateZoneName);
		reshma.setAppType(updateAppType);
		reshma.setDcLocation(updateDCLocation);
		reshma.setClusterName(updateClusterName);
		reshma.setAppEnvironment(updateAppEnvironment);
		reshma.setTier(updateTier);
		reshma.setName(updateName);
		
		reshmaService.update(reshma);
			
	 return "redirect:/Reshma";
	}
	
	@PostMapping(value = "/deleteReshma")
	public String deleteReshma(@RequestParam("deleteId") long id) throws ParseException {
		 
		reshmaService.delete(id);
			
	 return "redirect:/Reshma";
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/TrustedServers", method = RequestMethod.GET)
	public String trustedServer(Model model) {
		
		List<TrustedServerZone> list = trustedServerService.getTrustedServers();
		 
	    model.addAttribute("TrustedServers", list);
	    TrustedServerZone tsz = new TrustedServerZone();
		model.addAttribute("tsz", tsz);
		return "TrustedServers";
	}
	
	
	@PostMapping(value = "/saveTrustedServers")
	public String addFirewallRule(@ModelAttribute("tsz") TrustedServerZone trustedServerZone, HttpServletRequest request) {
		
		
		trustedServerService.save(trustedServerZone);
		
		return "redirect:/TrustedServers";
	
	}
	
	@PostMapping(value = "/updateTrustedServers")
	public String updateTrustedServers(@RequestParam("updateid") long id,@RequestParam("updatesource") String source,@RequestParam("updatedestination") String destination,@RequestParam("updateremark") String remark) throws ParseException {
		 
		TrustedServerZone tsz = new TrustedServerZone();
		tsz.setId(id);
		tsz.setSource(source);
		tsz.setDestination(destination);
		tsz.setRemark(remark);
		
		trustedServerService.update(tsz);
			
	 return "redirect:/TrustedServers";
	}
	
	@PostMapping(value = "/deleteTrustedServers")
	public String deleteTrustedServers(@RequestParam("deleteId") long id) throws ParseException {
		 
		trustedServerService.delete(id);
			
	 return "redirect:/TrustedServers";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
