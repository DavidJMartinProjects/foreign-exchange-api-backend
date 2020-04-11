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

	private SupportedCurrencies supportedCurrencies;

	public SupportedCurrencies mapToSupportedCurrencies(final ResponseEntity responseEntity) {
		try {
			supportedCurrencies = new ObjectMapper().readValue(responseEntity.getBody().toString(), SupportedCurrencies.class);
		} catch (IOException exception) {
			log.info("error mapping response from external service.", exception.getMessage(), exception.getCause());
		}
		return supportedCurrencies;
	}

}
