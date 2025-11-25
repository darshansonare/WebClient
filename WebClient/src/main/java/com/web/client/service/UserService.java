package com.web.client.service;

import com.web.client.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private WebClient webClient;

    // Get user by ID
    public Mono<UserData> getUser(int id){
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(UserData.class);
    }

    // Add a new post
    public Mono<UserData> addUser(UserData data){
        return webClient.post()
                .uri("/posts")
                .bodyValue(data)
                .retrieve()
                .bodyToMono(UserData.class);
    }
}
