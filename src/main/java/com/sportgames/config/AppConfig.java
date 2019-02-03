package com.sportgames.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(initMethod = "initData")

    public TestData initTestData(){
        return new TestData();
    }
}
