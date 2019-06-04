package com.wangkaiyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * Hello world!
 */
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.wangkaiyi.datasource", "com.wangkaiyi.web", "com.wangkaiyi.service", "com.wangkaiyi.test2.service"})
//@ComponentScan(basePackages = {"com.wangkaiyi"})
@MapperScan(basePackages ="com.wangkaiyi.mapper")
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //启动springboot项目
        SpringApplication.run(App.class, args);
    }
}
