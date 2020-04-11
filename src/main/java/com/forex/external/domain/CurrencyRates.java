package com.forex.external.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyRates {

	@JsonProperty("rates")
	private Map<String, Rate> rates;

	@JsonProperty("code")
	private String code;

}
