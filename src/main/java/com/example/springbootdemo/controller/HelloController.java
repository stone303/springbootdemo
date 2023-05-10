package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.User;
import com.example.springbootdemo.service.AddUserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author guocang.shi
 */
@RestController
@RequestMapping("/api")
public class HelloController {

        @GetMapping("/hello")
        public String hello() {
            return "Hello World!";
        }

        @PostMapping("/add")
        public String addUser(@RequestBody User user) {
        // 处理添加用户的逻辑
            return  AddUserService.addUser(user);
      }

}

