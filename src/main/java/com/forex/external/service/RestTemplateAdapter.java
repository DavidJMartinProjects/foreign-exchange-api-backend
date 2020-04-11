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
	private RequestUtil requestUtil;

	private ResponseEntity<String> responseEntity;

	public ResponseEntity<String> performGetRequest(final String url) {
		try {
			responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, requestUtil.buildHeaders(), String.class);
		} catch (Exception exception) {
			log.error("failed to get response from url: {}, error message: {}, cause: {}"
					+ url, exception.getMessage(), exception.getCause());
		}
		return responseEntity;
	}

}
