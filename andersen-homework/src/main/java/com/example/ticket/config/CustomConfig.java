package com.example.ticket.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {

    @Bean
    @ConditionalOnProperty(name = "my.custom.bean.enabled", havingValue = "true", matchIfMissing = false)
    public String thisIsMyFirstConditionalBean() {
        return "This is my first conditional bean!";
    }
}
