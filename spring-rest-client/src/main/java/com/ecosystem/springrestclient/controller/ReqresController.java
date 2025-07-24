package com.ecosystem.springrestclient.controller;

import com.ecosystem.springrestclient.model.RUMCharacter;
import com.ecosystem.springrestclient.model.ReqUser;
import com.ecosystem.springrestclient.model.ReqUserApiResponseDto;
import com.ecosystem.springrestclient.model.ReqUserDto;
import com.ecosystem.springrestclient.service.ReqresService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class ReqresController {
    ReqresService reqresService;

    @GetMapping
    public List<ReqUser> getUsers(){
        return reqresService.getUsers();
    }

    @PostMapping
    public ReqUserApiResponseDto createUser(@RequestBody ReqUserDto userDto){
        return reqresService.createUser(userDto);
    }
}
