package com.xfactor.lably.controllers;
import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.Map;
import  com.xfactor.lably.entity.Admin;


@RestController
@RequestMapping("/admin")
public class AdminController
{
    @GetMapping()
    public String HelloWorld()
    {
        return "Hello World";
    }
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello from Admin Controller";
    }
   // @RequestMapping(method=RequestMethod.GET,value="/greet")
   @GetMapping("/greet")
    public String greetings()
    {
        return "Greetings from Kolkata";
    }
    @GetMapping("/greet/{text}")
    public String greetme(@PathVariable String text)
    {
        return "Greetings from " + text;
    }
    @GetMapping("/greet2")
    public String greet2(@RequestParam String name, @RequestParam int age,@RequestParam String city)
    {
        return "Greetings from "+name+" whose age is "+age+" who lives in "+city;
    }
    @GetMapping("/greet3")
    public Map<String ,String> greet3(@RequestParam String name, @RequestParam String age,@RequestParam String city)
    {
    Map<String, String> resp = new HashMap<>();
    resp.put("name",name);
    resp.put("age", age);
    resp.put("city",city);
    return resp;
    }
    @GetMapping("/register")
    public Map<String ,String> register(@RequestParam String name, @RequestParam String username,@RequestParam String password,@RequestParam String department)
    {
   /* Map<String, String> resp = new HashMap<>();
    resp.put("name",name);
    resp.put("username", username);
    resp.put("password",password);
    resp.put("department",department);
    return resp;*/
    Admin admin1=new Admin();
    admin1.setName(name);
    admin1.setUsername(username);
    admin1.setPassword(password);
    admin1.setDepartment(department);
    return admin1;
    }
    public Admin registerPost(@RequestBody Admin admin){
        admin.setId(UUID.randomUUID().toString());
        return admin;
    }
}