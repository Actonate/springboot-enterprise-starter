package com.accio.spring.starter.controllers;

import com.rollbar.notifier.Rollbar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PingController {
    /**
     * Rollbar instance.
     */
    @Autowired
    private Rollbar rollbar;

    /**
     * Logger instance.
     */
    private final Logger logger = LoggerFactory.getLogger(PingController.class);

    /**
     * Ping to check server is running or not.
     * always return "PONG"
     *
     * @return String
     */
    @GetMapping("/ping")
    ResponseEntity<String> ping() {
        // Sends a debug message to your Spring project on Rollbar
        rollbar.debug("Here is some debug message");

        Exception e = new Exception("Rollbar test error");
        rollbar.error(e);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Id", "123");
        map.put("User Name", "John Doe");
        map.put("Email", "john@doe.com");
        rollbar.log(e, map);



        logger.info("message info");
        logger.warn("message warn");
        logger.error("message error");
        logger.debug("message debug");
        return new ResponseEntity<>("PONG", HttpStatus.OK);
    }

}
