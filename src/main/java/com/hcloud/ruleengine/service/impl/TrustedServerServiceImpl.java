package com.hcloud.ruleengine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcloud.ruleengine.model.TrustedServerZone;
import com.hcloud.ruleengine.repository.TrustedServersRepository;
import com.hcloud.ruleengine.service.TrustedServerService;

@Service
public class TrustedServerServiceImpl implements TrustedServerService{

	@Autowired
	private TrustedServersRepository trustedServersRepository;

	@Override
	public List<TrustedServerZone> getTrustedServers() {
		return trustedServersRepository.findAll();
		
	}
	
	
}
