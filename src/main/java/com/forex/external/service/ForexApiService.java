package com.forex.external.service;

import com.forex.business.config.ExternalUrlsConfig;
import com.forex.external.pojo.SupportedCurrencies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ForexApiService {

	@Autowired
	ExternalUrlsConfig externalUrlsConfig;

	@Autowired
	RestTemplateAdapter restTemplateAdapter;

	public SupportedCurrencies getSupportedCurrencyPairs() {
		return restTemplateAdapter.performGetRequest(externalUrlsConfig.getForexApiUrl());
	}

}
