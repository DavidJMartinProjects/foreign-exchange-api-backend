package com.forex.external.service;

import com.forex.business.config.ExternalUrlsConfig;
import com.forex.external.pojo.SupportedCurrencies;
import com.forex.external.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ForexApiService {

	@Autowired
	ExternalUrlsConfig externalUrlsConfig;

	@Autowired
	RestTemplateAdapter restTemplateAdapter;

	@Autowired
	MapperUtil mapperUtil;

	public SupportedCurrencies getSupportedCurrencyPairs() {
		ResponseEntity responseEntity = restTemplateAdapter.performGetRequest(externalUrlsConfig.getForexApiUrl());
		return mapperUtil.mapToSupportedCurrencies(responseEntity);
	}

}
