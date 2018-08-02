package com.las.learn.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    Registration registration;


    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices() + " _ " + registration.getUri();
        System.out.println(services);
        return services;
    }

}
