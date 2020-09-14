package com.hcloud.ruleengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcloud.ruleengine.model.Reshma;
import com.hcloud.ruleengine.model.TrustedServerZone;
import com.hcloud.ruleengine.service.ReshmaService;
import com.hcloud.ruleengine.service.TrustedServerService;

@RestController
public class RuleEngineRestController {

	@Autowired
	private ReshmaService reshmaService;
	
	@Autowired
	private TrustedServerService trustedServerService;
	
	@GetMapping(value = "/getRemarks")
	public String getRemarks(@RequestParam("sourceIP") String sourceIP,@RequestParam("destinationIP") String destinationIP) {
		
		String remark="";
		
		System.out.println("Source IP "+sourceIP);
		System.out.println("Destination IP "+destinationIP);
		
		List<Reshma> source = reshmaService.getReshmaIPs(sourceIP);
		List<Reshma> des = reshmaService.getReshmaIPs(destinationIP);
		for (Reshma s : source) {
			
			for (Reshma d : des) {
				System.out.println("Destination Server Name : "+d.getName());
				List<TrustedServerZone> tsz=getRemarkValue(s.getName(), d.getName());
				
				for (TrustedServerZone t: tsz) {
					remark+=t.getRemark()+"\n";
				}
			}
		}
		
		
		
		return remark;
	} 
	
	
	
	
	@GetMapping(value = "/getRemarkValue")
	public List<TrustedServerZone> getRemarkValue(@RequestParam("sourceServer") String sourceServer,@RequestParam("destinationServer") String destinationServer) {
		
		
		return trustedServerService.getRemarkValues(sourceServer, destinationServer);
	} 
	
	
	
	
	
}
