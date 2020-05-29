package com.example.demo;

import com.example.demo.bean.service.HelloService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author chengjiansheng
 * @date 2019-05-26
 */
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args)) {
            HelloService helloService = applicationContext.getBean(HelloService.class);
            helloService.sayHello();
        }
    }

}
