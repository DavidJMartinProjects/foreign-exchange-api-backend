package com.forex.external.service;

import com.forex.external.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RestTemplateAdapter {

	@Autowired
	RequestUtil requestUtil;

	public ResponseEntity<String> performGetRequest(final String url) {
		return new RestTemplate().exchange(url, HttpMethod.GET, requestUtil.buildHeaders(), String.class);
	}

}
