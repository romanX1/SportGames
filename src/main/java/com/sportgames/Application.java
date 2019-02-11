package com.sportgames;


import com.sportgames.config.AddSportsToBase;
import com.sportgames.config.TestData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean(initMethod = "initSports")
//    public AddSportsToBase initAddSportsToBase(){
//        return new AddSportsToBase();
//    }
//
//    @Bean(initMethod = "initData")
//    public TestData initTestData(){
//        return new TestData();
//    }
}