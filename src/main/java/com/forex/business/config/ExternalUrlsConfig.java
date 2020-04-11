package com.forex.business.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "paths.external-api")
public class ExternalUrlsConfig {
	private String forexApiUrl;
}
