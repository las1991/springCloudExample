package com.las.learn.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.las.learn.springcloud.ribbonClient.*")
})
public class ConsulDiscoveryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConsulDiscoveryApplication.class).web(true).run(args);

        RestTemplate restTemplate = context.getBean(RestTemplate.class);

        String result = restTemplate.getForObject("http://consul-service/400", String.class);
        System.out.println(result);
    }

}
