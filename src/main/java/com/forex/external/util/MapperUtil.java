package com.forex.external.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forex.external.domain.CurrencyRates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MapperUtil {

	private CurrencyRates currencyRates;

	public CurrencyRates mapToMajorCurrencies(final ResponseEntity<String> responseEntity) {
		try {
			currencyRates = new ObjectMapper().readValue(responseEntity.getBody().toString(), CurrencyRates.class);
		} catch (Exception exception) {
			log.error("error mapping response from external service. message: {}, cause: {}", exception.getMessage(), exception.getCause());
		}
		return currencyRates;
	}

	public String mapListToString(final ArrayList theList) {
		return theList.stream()
			.collect(Collectors.joining(", "))
			.toString();
	}
}
