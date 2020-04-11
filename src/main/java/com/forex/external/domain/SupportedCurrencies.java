package com.forex.external.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Component;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupportedCurrencies {

	@JsonProperty("message")
	private String message;

	@JsonProperty("supportedPairs")
	private List<String> supportedPairs;

	@JsonProperty("code")
	private Integer code;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}