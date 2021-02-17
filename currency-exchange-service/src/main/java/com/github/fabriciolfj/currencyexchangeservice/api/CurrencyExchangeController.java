package com.github.fabriciolfj.currencyexchangeservice.api;

import com.github.fabriciolfj.currencyexchangeservice.domain.CurrencyExchange;
import com.github.fabriciolfj.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeRepository repository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable("from") final String from, @PathVariable("to") final String to) {
        return repository.findByFromAndTo(from, to)
                .map(r -> {
                    r.setEnvironment(environment.getProperty("local.server.port"));
                    return r;
                })
                .orElseThrow(() -> new RuntimeException("Currency not found"));
    }
}
