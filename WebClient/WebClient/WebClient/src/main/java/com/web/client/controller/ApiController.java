package com.web.client.controller;

import com.web.client.model.UserData;
import com.web.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/webClient")
public class ApiController {

    @Autowired
    private UserService service;

    @GetMapping("/getUser/{id}")
    public Mono<UserData> getPost(@PathVariable int id){
        return service.getUser(id);
    }

    @PostMapping("/addUser")
    public Mono<UserData> addPost(@RequestBody UserData data){
        return service.addUser(data);
    }
}
