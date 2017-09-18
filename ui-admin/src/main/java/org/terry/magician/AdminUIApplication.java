package org.terry.magician;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Terry
 */
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class AdminUIApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminUIApplication.class, args);
    }

}
