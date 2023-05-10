package com.example.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guocang.shi
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class FlagTrackController {

    @GetMapping("/log")
    public String flagTrack(){
        log.info("-----> 测试 info <-----");
        log.warn("-----> 测试 warn <-----");
        log.error("-----> 测试 error <-----");
        return null;
    }

}
