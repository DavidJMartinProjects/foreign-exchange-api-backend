package com.forex.external.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rate {

	@JsonProperty("rate")
	private String rate;

	@JsonProperty("timestamp")
	private String timestamp;

}
