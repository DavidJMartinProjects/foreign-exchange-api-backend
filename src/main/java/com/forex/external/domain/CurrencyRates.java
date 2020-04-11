package com.forex.external.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyRates {

	private Map<String, Rate> rates;
	private String code;

}
