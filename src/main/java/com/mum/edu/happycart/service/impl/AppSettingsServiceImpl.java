package com.mum.edu.happycart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.repository.AppSettingsRepository;
import com.mum.edu.happycart.service.AppSettingsService;
import com.mum.edu.happycart.domain.AppSettings;

@Service
public class AppSettingsServiceImpl implements AppSettingsService {

	@Autowired
	AppSettingsRepository appSettingsRepository;

	public AppSettings appSettings(String paramKey) {
		
		return appSettingsRepository.getParamValueByParamKey(paramKey);
	}
	
	


	

}
