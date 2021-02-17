package com.github.fabriciolfj.currencyexchangeservice;

import com.github.fabriciolfj.currencyexchangeservice.domain.CurrencyExchange;
import com.github.fabriciolfj.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = CurrencyExchangeRepository.class)
@EntityScan(basePackageClasses = CurrencyExchange.class)
@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}
