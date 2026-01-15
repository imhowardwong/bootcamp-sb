package com.bootcamp.demo_basic_api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/calculator")
public class CalculatorController {
   // ! API = Application Programming Interface

  // ! by default variable x in java, matching to the URL path variable x
  @GetMapping(value = "/calculator/sum/{x}/{y}")
  public int sum(@PathVariable(value = "y") Integer salary,
      @PathVariable(value = "x") Integer bonus) {
    return salary + bonus;
  }

  @GetMapping(value = "/calculator/subtract/{x}/{y}")
  public int subtract(@PathVariable Integer x, @PathVariable Integer y) {
    return x - y;
  }

  //! @RequestParam
  // http://localhost:8081/calculator/multipy?x=3&y=10
  @GetMapping(value = "/calculator/multipy")
  public int multipy(@RequestParam (value = "x") Integer firstNum, @RequestParam (value = "y") Integer secondNum) {
    return firstNum * secondNum;
  }
}
