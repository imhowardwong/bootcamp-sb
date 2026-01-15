package com.vtxlab.demo.helloworld.class_demo_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class HelloworldController {
  
  @GetMapping(value = "/bootcamp")
  public String hello(){
    return "Hello World!! Welcome to Spring Boot.";
  }
}
