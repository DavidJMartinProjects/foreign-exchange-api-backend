package com.forex.external.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
public class CurrencyRates {

	private Map<String, Rate> rates;
	private String code;

}
