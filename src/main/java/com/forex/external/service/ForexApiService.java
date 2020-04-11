package com.forex.external.service;

import com.forex.business.config.CurrenciesConfig;
import com.forex.business.config.ExternalUrlsConfig;
import com.forex.external.domain.CurrencyRates;
import com.forex.external.domain.SupportedCurrencies;
import com.forex.external.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForexApiService {

	@Autowired
	private MapperUtil mapperUtil;

	@Autowired
	CurrenciesConfig currenciesConfig;

	@Autowired
	private ExternalUrlsConfig externalUrlsConfig;

	@Autowired
	private RestTemplateAdapter restTemplateAdapter;

	public SupportedCurrencies getSupportedCurrencyPairs() {
		return mapperUtil.mapToSupportedCurrencies(
				restTemplateAdapter.performGetRequest(
					externalUrlsConfig.getSupportedCurrenciesUrl()));
	}

	public CurrencyRates getMajorCurrencyPairs() {
		return mapperUtil.mapToMajorCurrencies(
				restTemplateAdapter.performGetRequest(
				 externalUrlsConfig.getMajorCurrenciesUrl() +
						 mapperUtil.mapListToString((currenciesConfig.getCurrencies()))));
	}

}
