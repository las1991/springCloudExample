package com.las.learn.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulDiscoveryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConsulDiscoveryApplication.class).web(true).run(args);

        RestTemplate restTemplate = context.getBean(RestTemplate.class);

        String result = restTemplate.getForObject("http://consul-service/error", String.class);
        System.out.println(result);
    }

}
