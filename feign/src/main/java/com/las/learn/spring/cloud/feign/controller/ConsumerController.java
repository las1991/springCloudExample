package com.las.learn.spring.cloud.feign.controller;

import com.las.learn.spring.cloud.feign.service.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/20
 */
@RestController
public class ConsumerController {
    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
}
