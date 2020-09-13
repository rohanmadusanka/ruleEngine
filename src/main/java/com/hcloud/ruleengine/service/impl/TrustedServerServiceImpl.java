package com.hcloud.ruleengine.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public TrustedServerZone save(TrustedServerZone trustedServerZone) {
		// TODO Auto-generated method stub
		return trustedServersRepository.save(trustedServerZone);
	}

	@Override
	public void delete(long id) {
		trustedServersRepository.deleteById(id);
	}
	
	@Override
	public TrustedServerZone update(TrustedServerZone trustedServerZone) {
		// TODO Auto-generated method stub
		return trustedServersRepository.save(trustedServerZone);
	}

	
}
