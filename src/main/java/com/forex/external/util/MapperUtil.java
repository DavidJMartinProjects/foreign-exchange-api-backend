package com.forex.external.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forex.external.pojo.SupportedCurrencies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class MapperUtil {

	SupportedCurrencies supportedCurrencies;

	public SupportedCurrencies mapToSupportedCurrencies(final ResponseEntity responseEntity) {
		String responseBody = responseEntity.getBody().toString();
		try {
			supportedCurrencies = new ObjectMapper().readValue(responseBody, SupportedCurrencies.class);
		} catch (IOException exception) {
			log.info("error processing response from external service.", exception.getMessage(), exception.getCause());
		}
		return supportedCurrencies;
	}

}
