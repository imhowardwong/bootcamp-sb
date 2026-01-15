package com.bootcamp.demo_basic_api.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo_basic_api.model.Database;


@Controller
@ResponseBody

public class StringController {
    // input 2 strings, return concat their first characters
  // hello world -> hw
  @GetMapping(value = "/string/{firstword}/{secondword}")
  public String concatFirstChar(@PathVariable(value = "firstword") String x,
      @PathVariable(value = "secondword") String y) {
    return "" + x.charAt(0) + y.charAt(0); // "hw"
    // char + char -> int + int -> int // "223"
  }

//!API signature definition
  @GetMapping(value="/database/names")
  public List<String> getNames() {
    return Database.names;
  }

  // get Name by index, if not found, return "Not Found"
  // if index is invalid, return "Wrong index"
  @GetMapping(value="/database/index/{index}")
  public String getNameByIndex(@PathVariable String index) {
    //String -> Integer
    try{
      int idx = Integer.valueOf(index);
      if(idx < 0 || idx >= Database.names.size())
        return "Wrong Index";
      return Database.names.get(idx);
    } catch (NumberFormatException e)  {
      return "Wrong Index";
    }
  }
  // delete Name by Name
  @DeleteMapping (value="/database/delete/{name}")
  public String deleteName(@PathVariable String name) {
    return Database.names.remove(name) ? name:null;
  }
  // @GetMapping(value="/database/add/{name}")
  // public String addName(@PathVariable String name) {
  //   return Database.names.add(name) ? name:null;
  // }

  // ! API signature definition: XXXXMapping + URI path
  @PostMapping(value = "/database/{name}")
  public String addName(@PathVariable String name) {
    return Database.names.add(name) ? name : null;
  }

  // update Name by Index + New Name
  @PutMapping("/database/index/{index}/newname/{newname}")
  public String updateNameString(@PathVariable String index,
      @PathVariable(value = "newname") String newName) {
    try {
      int idx = Integer.valueOf(index); //
      if (idx < 0 || idx >= Database.names.size())
        return "Wrong Index.";
      return Database.names.set(idx, newName);
    } catch (NumberFormatException e) {
      return "Wrong Index.";
    }
  }
}