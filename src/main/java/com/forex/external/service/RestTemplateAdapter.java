package com.forex.external.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forex.external.pojo.SupportedCurrencies;
import com.forex.external.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@Component
public class RestTemplateAdapter {

	@Autowired
	RequestUtil requestUtil;

	private SupportedCurrencies supportedCurrencies;

	public SupportedCurrencies performGetRequest(final String url) {
		String responseBody = new RestTemplate().exchange(url, HttpMethod.GET, requestUtil.buildHeaders(), String.class).getBody();
		try {
			supportedCurrencies = new ObjectMapper().readValue(responseBody, SupportedCurrencies.class);
		} catch (IOException exception) {
			log.info("error processing response from external service.", exception.getMessage(), exception.getCause());
		}
		return supportedCurrencies;
	}

}
