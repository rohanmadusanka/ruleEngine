package com.hcloud.ruleengine.service;

import java.util.List;

import com.hcloud.ruleengine.model.Reshma;


public interface ReshmaService {

	List<Reshma> getReshmaIPs(String ipAddress);
	
	
	List<Reshma> getAllReshma();

}
