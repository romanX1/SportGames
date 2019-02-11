package com.sportgames;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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