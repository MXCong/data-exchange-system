package com.css.dataexchangesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.css.dataexchangesystem.mapper")
@SpringBootApplication
public class DataExchangeSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(DataExchangeSystemApplication.class, args);
    }

}
