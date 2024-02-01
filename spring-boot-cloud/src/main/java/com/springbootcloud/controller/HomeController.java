package com.springbootcloud.controller;

import com.springbootcloud.model.User;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
public class HomeController {
    @RequestMapping("/")
    public String Home(){
        return "Spring boot hey";
    }
    @RequestMapping("/user")
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("Rahul");
        user.setEmailId("rashul@gmail.com");
        user.toString();
        return user;
    }

    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id,
                               @PathVariable("id2") String name){
        return "the path variable is" + id + ":" + name;
    }
    @GetMapping("/requestParam")//?name=sid&emailId=sid@gmail.com
    public String requestParam(@RequestParam String name,
                               @RequestParam(name = "email", required = false, defaultValue = "") String emailId){
        return "The Name is" + name + "email is" + emailId;
    }
}
