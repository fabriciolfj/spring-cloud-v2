package com.github.fabriciolfj.currencyexchangeservice.api;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "hardCodeResponse")
    @CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodeResponse")
    //@RateLimiter(name = "sample-api")
    @Bulkhead(name = "sample-api")
    public String sampleApi() {
        logger.info("Sample api call received");
        var restTemplate = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);

        return restTemplate.getBody();
    }

    public String hardCodeResponse(Exception ex) {
        return "fallback response";
    }
}
