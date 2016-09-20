package com.las.learn.spring.cloud.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @Description
 * @Author：andy
 * @CreateDate：2016/9/20
 */
@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }

}