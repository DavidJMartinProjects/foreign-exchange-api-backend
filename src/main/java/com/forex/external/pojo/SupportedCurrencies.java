package com.forex.external.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupportedCurrencies {

	@JsonProperty("message")
	private String message;
	@JsonProperty("supportedPairs")
	private List<String> supportedPairs = null;
	@JsonProperty("code")
	private Integer code;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}