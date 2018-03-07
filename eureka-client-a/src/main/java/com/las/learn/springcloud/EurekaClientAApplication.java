package com.las.learn.springcloud;

import com.las.learn.springcloud.controller.DcController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientAApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientAApplication.class).web(true).run(args);
    }

}
