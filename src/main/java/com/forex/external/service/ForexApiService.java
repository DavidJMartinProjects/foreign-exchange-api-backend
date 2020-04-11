package com.forex.external.service;

import com.forex.business.config.Symbols;
import com.forex.business.config.ExternalUrls;
import com.forex.external.domain.CurrencyRates;
import com.forex.external.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForexApiService {

	@Autowired
	private MapperUtil mapperUtil;

	@Autowired
	private Symbols symbols;

	@Autowired
	private ExternalUrls externalUrls;

	@Autowired
	private RestTemplateAdapter restTemplateAdapter;

	public CurrencyRates getMajorCurrencyPairs() {
		return mapperUtil.mapToMajorCurrencies(restTemplateAdapter.performGetRequest(buildUrl()));
	}

	private String buildUrl() {
		return externalUrls.getMajorCurrenciesPath() + mapperUtil.mapListToString((symbols.getSymbols()));
	}

}
