package com.forex.business.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Slf4j
@Component
@ConfigurationProperties
public class CurrenciesConfig {

	private List currencies;

}
