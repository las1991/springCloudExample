package com.las.learn.spring.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ComputeServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
    }

}
