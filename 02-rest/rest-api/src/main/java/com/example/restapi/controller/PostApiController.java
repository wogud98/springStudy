package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    // https://localhost:8080/api/post
    // JSON형태
    @PostMapping("/post")
    public BookRequest post(
        @RequestBody BookRequest bookRequest    //@RequestBody : JSON형태 데이터를 변수에 매칭시켜줌
    ){
        System.out.println(bookRequest);
        return bookRequest;
    }

    // String, TEXT 형태
    @PostMapping("/post2")
    public String post2(
            @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    @PostMapping("/user")
    public UserRequest user(
            @RequestBody UserRequest userRequest
            ){
        System.out.println(userRequest);
        return userRequest;
    }
}
