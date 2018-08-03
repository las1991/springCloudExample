package com.las.learn.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulServiceAApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulServiceAApplication.class).web(true).run(args);
    }
}
