package com.forex.web.controller;

import com.forex.external.domain.CurrencyRates;
import com.forex.external.service.ForexApiService;
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
public class WebController {

    @Autowired
    private ForexApiService forexApiService;

    @GetMapping(value = "/major")
    public ResponseEntity<CurrencyRates> getMajorCurrencyPairs() {
        log.info("GET /major request received successfully.");
        return new ResponseEntity(forexApiService.getMajorCurrencyPairs(), HttpStatus.OK);
    }

}
