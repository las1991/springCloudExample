package com.las.learn.springcloud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);

    @Autowired
    private Registration registration;

    @RequestMapping(value = "/400")
    public ResponseEntity badRequest() {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(registration);
            LOGGER.info(json);
        } catch (JsonProcessingException e) {
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
    }

    @RequestMapping(value = "/403")
    public ResponseEntity forbidden() {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(registration);
            LOGGER.info(json);
        } catch (JsonProcessingException e) {
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(json);
    }

    @RequestMapping(value = "/415")
    public ResponseEntity unsupportedMediaType() {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(registration);
            LOGGER.info(json);
        } catch (JsonProcessingException e) {
        }
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(json);
    }
}
