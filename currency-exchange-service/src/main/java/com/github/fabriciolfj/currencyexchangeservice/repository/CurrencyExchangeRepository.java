package com.github.fabriciolfj.currencyexchangeservice.repository;

import com.github.fabriciolfj.currencyexchangeservice.domain.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    Optional<CurrencyExchange> findByFromAndTo(final String from, final String to);
}
