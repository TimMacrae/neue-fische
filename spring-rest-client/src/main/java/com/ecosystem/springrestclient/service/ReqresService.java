package com.ecosystem.springrestclient.service;

import com.ecosystem.springrestclient.model.ReqUser;
import com.ecosystem.springrestclient.model.ReqUserApiResponse;
import com.ecosystem.springrestclient.model.ReqUserApiResponseDto;
import com.ecosystem.springrestclient.model.ReqUserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ReqresService {
//    private final RestClient restClient;
//
//
//    public ReqresService(RestClient.Builder restClientBuilder) {
//        this.restClient = restClientBuilder.baseUrl("https://reqres.in/api").defaultHeader("x-api-key", "reqres-free-v1").build();
//    }
//
//
//    public List<ReqUser> getUsers() {
//        return restClient.get().uri("/users?page=2").retrieve().body(ReqUserApiResponse.class).data();
//    }
//
//    public ReqUserApiResponseDto createUser(ReqUserDto userDto) {
//        return restClient.post().uri("/users").body(userDto).retrieve().body(ReqUserApiResponseDto.class);
//    }
}
