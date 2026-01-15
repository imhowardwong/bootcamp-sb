package com.bootcamp.demo_basic_api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo_basic_api.model.Cat;


@Controller
@ResponseBody
public class CatController {
 @GetMapping(value = "/cat/{name}/{age}")
  public Cat create(@PathVariable String name, @PathVariable Integer age) {
    return new Cat(name, age);
  }

  // return Cat[], which has one cat
  // API: input name and age
  @GetMapping(value = "/cats/{name}/{age}")
  public Cat[] createCats(@PathVariable String name, @PathVariable Integer age) {
    return new Cat[] {new Cat(name, age)};
  }

  // ! Class -> LocalDate, LocalDateTime, double, boolean, etc...
}
