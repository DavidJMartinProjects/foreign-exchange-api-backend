package com.forex.business.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
@ConfigurationProperties(prefix = "currency")
public class CurrenciesConfig {

	private ArrayList symbols;

}
