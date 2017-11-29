package com.swk.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author songwanke
 * @date 2017/11/8
 */
@SpringBootApplication
public class PracticeApplication {
    public static void main(String[] args) {
//        第一种方式
//        new SpringApplicationBuilder()
//                .sources(PracticeApplication.class)
//                .run(args);
//        第二种方式
        SpringApplication.run(PracticeApplication.class, args);
//        第三种方式
//        SpringApplication application = new SpringApplication(PracticeApplication.class);
//        application.run(args);
    }
}
