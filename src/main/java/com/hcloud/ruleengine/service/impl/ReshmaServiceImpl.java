package com.hcloud.ruleengine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcloud.ruleengine.model.Reshma;
import com.hcloud.ruleengine.repository.ReshmaRepository;
import com.hcloud.ruleengine.service.ReshmaService;

@Service
public class ReshmaServiceImpl implements ReshmaService{

	@Autowired
	private ReshmaRepository reshmaRepository;
	
	
	@Override
	public List<Reshma> getReshmaIPs(String ipAddress) {
		return reshmaRepository.getReshma(ipAddress);
	}
}
