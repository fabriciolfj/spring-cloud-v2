package com.github.fabriciolfj.limitsservice.controller;

import com.github.fabriciolfj.limitsservice.bean.Limits;
import com.github.fabriciolfj.limitsservice.config.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/limits")
public class LimitsController {

    private final Configuration configuration;

    @GetMapping
    public Limits retrieve() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
