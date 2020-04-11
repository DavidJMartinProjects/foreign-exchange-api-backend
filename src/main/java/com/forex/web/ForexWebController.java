package com.forex.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.forex.external.pojo.SupportedCurrencies;
import com.forex.external.service.ExternalForexApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/forex")
public class ForexWebController {

    @Autowired
    ExternalForexApiService externalForexApiService;

    @GetMapping
    public ResponseEntity<String> getAllExchangeRates() {
        log.info("request received successfully.");
        return new ResponseEntity("welcome to forex web service.", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<SupportedCurrencies> getAllSupportedCurrencies() {
        log.info("request received successfully.");
        return new ResponseEntity(externalForexApiService.getSupportedCurrencyPairs(), HttpStatus.OK);
    }

}
