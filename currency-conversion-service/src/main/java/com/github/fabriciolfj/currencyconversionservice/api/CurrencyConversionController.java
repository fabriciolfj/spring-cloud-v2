package com.github.fabriciolfj.currencyconversionservice.api;

import com.github.fabriciolfj.currencyconversionservice.client.CurrencyExchangeProxy;
import com.github.fabriciolfj.currencyconversionservice.domain.CurrencyConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversion(@PathVariable("from") final String from,
                                                 @PathVariable("to") final String to,
                                                 @PathVariable("quantity") final BigDecimal quantity) {
        var currency = currencyExchangeProxy.retrieveExchangeValue(from, to);
        return CurrencyConversion.builder()
                .id(currency.getId())
                .quantity(quantity)
                .conversionMultiple(currency.getConversionMultiple().multiply(quantity))
                .to(currency.getTo())
                .environment(currency.getEnvironment())
                .build();
    }
}
