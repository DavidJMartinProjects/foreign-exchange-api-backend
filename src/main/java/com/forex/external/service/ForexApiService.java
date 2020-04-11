package com.forex.external.service;

import com.forex.business.config.CurrenciesConfig;
import com.forex.business.config.ExternalUrlsConfig;
import com.forex.external.domain.CurrencyRates;
import com.forex.external.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForexApiService {

	@Autowired
	private MapperUtil mapperUtil;

	@Autowired
	private CurrenciesConfig currenciesConfig;

	@Autowired
	private ExternalUrlsConfig externalUrlsConfig;

	@Autowired
	private RestTemplateAdapter restTemplateAdapter;

	public CurrencyRates getMajorCurrencyPairs() {
		return mapperUtil.mapToMajorCurrencies(restTemplateAdapter.performGetRequest(buildUrl()));
	}

	private String buildUrl() {
		return externalUrlsConfig.getMajorCurrenciesUrl() +	mapperUtil.mapListToString((currenciesConfig.getSymbols()));
	}

}
