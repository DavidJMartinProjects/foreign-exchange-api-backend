package com.forex.external.service;

import com.forex.external.pojo.SupportedCurrencies;
import com.forex.external.util.RestTemplateAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalForexApiService {

	@Autowired
	RestTemplateAdapter restTemplateAdapter;

	private String externalServiceUrl = "https://www.freeforexapi.com/api/live";

	public SupportedCurrencies getSupportedCurrencyPairs() {
		return restTemplateAdapter.performGetRequest(externalServiceUrl);
	}

}