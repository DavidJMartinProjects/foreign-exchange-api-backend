package com.forex.external.service;

import com.forex.business.config.ExternalUrlsConfig;
import com.forex.external.pojo.SupportedCurrencies;
import com.forex.external.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ForexApiService {

	@Autowired
	private MapperUtil mapperUtil;

	@Autowired
	private ExternalUrlsConfig externalUrlsConfig;

	@Autowired
	private RestTemplateAdapter restTemplateAdapter;

	public SupportedCurrencies getSupportedCurrencyPairs() {
		return mapperUtil.mapToSupportedCurrencies(restTemplateAdapter.performGetRequest(externalUrlsConfig.getForexApiUrl()));
	}

}
