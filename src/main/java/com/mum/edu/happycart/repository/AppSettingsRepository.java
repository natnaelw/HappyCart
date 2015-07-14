package com.mum.edu.happycart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.edu.happycart.domain.AppSettings;

@Repository
public interface AppSettingsRepository extends CrudRepository<AppSettings, Long> {
	
	public AppSettings getParamValueByParamKey(String paramKey);
	

}
