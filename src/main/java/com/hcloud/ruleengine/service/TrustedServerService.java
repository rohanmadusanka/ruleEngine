package com.hcloud.ruleengine.service;

import java.util.List;


import com.hcloud.ruleengine.model.TrustedServerZone;

public interface TrustedServerService {
	List<TrustedServerZone> getTrustedServers();
}
