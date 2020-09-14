package com.hcloud.ruleengine.service;

import java.util.List;

import com.hcloud.ruleengine.model.Reshma;
import com.hcloud.ruleengine.model.TrustedServerZone;


public interface ReshmaService {

	List<Reshma> getReshmaIPs(String ipAddress);
	
	
	List<Reshma> getAllReshma();
	
	
	Reshma save(Reshma reshma);

	void delete(long id);

	Reshma update(Reshma reshma);
	
	

}
