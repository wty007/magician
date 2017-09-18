package org.terry.platform;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Terry
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminDashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminDashBoardApplication.class, args);
    }
}
