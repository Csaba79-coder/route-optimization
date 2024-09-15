package com.csaba79coder.routeoptimization.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Value("${api.token}")
    private String apiToken;

    @Bean
    public String apiToken() {
        return apiToken;
    }
}
