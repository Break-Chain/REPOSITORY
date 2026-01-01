package com.bc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
        @GetMapping("/aop")
        public String aop() {
            return "hello world";
        }
        @GetMapping("/handler")
        public String handler() {
            return "hello world";
        }
}
