package com.microservices.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMehod(){
        return "User service is taking longer than Expected.\n" +
                "Please try again, later.";
    }
    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMehod(){
        return "Department service is taking longer than Expected.\n" +
                "Please try again, later.";
    }
}
