package com.forex.external.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forex.external.pojo.SupportedCurrencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateAdapter {

	@Autowired
	RestTemplateUtil restTemplateUtil;

	public SupportedCurrencies performGetRequest(final String url) throws JsonProcessingException {
		return new ObjectMapper().readValue(new RestTemplate().exchange(url, HttpMethod.GET, restTemplateUtil.buildHeaders(), String.class).getBody(), SupportedCurrencies.class);
	}

}
