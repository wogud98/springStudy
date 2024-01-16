package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  //로그 백 관련 어노테이션
@RestController
@RequestMapping("/api")
public class PutController {

    @PutMapping("/put")
    public void put(
        @RequestBody UserRequest userRequest
    ){
        log.info("Request : {}", userRequest);

    }
}
