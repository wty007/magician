package org.terry.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import zipkin.server.EnableZipkinServer;

/**
 * @author Terry
 */
@SpringBootApplication
@EnableZipkinServer
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class ZipkinAndHystrixDashBoardServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinAndHystrixDashBoardServerApplication.class, args);
    }
}
