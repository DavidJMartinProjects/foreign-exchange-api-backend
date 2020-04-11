package com.forex.external.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rate {

	private String rate;
	private String timestamp;

}
