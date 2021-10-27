package com.baoshan.shanghai.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baoshan.shanghai.project.mapper")
public class BootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootKafkaApplication.class, args);
    }

}
