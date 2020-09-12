package com.hcloud.ruleengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcloud.ruleengine.model.Reshma;
import com.hcloud.ruleengine.model.TrustedServerZone;

public interface TrustedServersRepository extends JpaRepository<TrustedServerZone, Long>{

}
