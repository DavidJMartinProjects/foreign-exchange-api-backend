package com.forex.external.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Rate {

	private String rate;
	private String timestamp;

}
