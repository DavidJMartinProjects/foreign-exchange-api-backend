package com.forex.external.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forex.external.pojo.SupportedCurrencies;
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
	RestTemplateUtil restTemplateUtil;

	private SupportedCurrencies supportedCurrencies;

	public SupportedCurrencies performGetRequest(final String url) {

		try {
			String responseBody = new RestTemplate().exchange(url, HttpMethod.GET, restTemplateUtil.buildHeaders(), String.class).getBody();
			supportedCurrencies = new ObjectMapper().readValue(responseBody, SupportedCurrencies.class);
		} catch (IOException exception) {
			log.info("error processing request from external service.", exception.getMessage(), exception.getCause());
		}
		return supportedCurrencies;

	}

}
