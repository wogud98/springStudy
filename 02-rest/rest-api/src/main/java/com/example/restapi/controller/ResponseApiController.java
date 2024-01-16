package com.example.restapi.controller;


import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController //REST API로 동작하겠다. 응답값이 json으로 내려가겠다는 선언. spring boot는 html 응답도 가능하기에 이 때는 Controller 어노테이션 사용
//@Controller
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("") //명시적 사용
    //@RequestMapping(path = "", method = RequestMethod.GET)    //경로와 메소드를 통해서 어떤 요청을 매칭시킬지.(메소드 미지정 모든 메소드에 대해 동작함)
    //@ResponseBody @Controller 어노테이션 사용 시. (응답이 json으로 내려감)
    public ResponseEntity<UserRequest> user(

    ){
        var user = new UserRequest();
        user.setUserName("김재형");
        user.setUserAge(27);
        user.setEmail("kjh3136352@gmail.com");

        log.info("user :{}", user); //return type이
        var response = ResponseEntity
//                .status(HttpStatus.OK)
//                .status(HttpStatus.BAD_REQUEST)
                .status(HttpStatus.CREATED)
                .header("x-custion", "hi")
                .body(user);
        /*
            Spring Boot 에서의 응답
            메소드는 객체를 리턴하는 것을 주로 사용함 (return user;)

            ResponseEntity의 사용 이유?
            로직 처리 중 에외가 발생할 때 응답코드를 내리는 방법.
            응답에 대한 status를 커스텀할 때. 예를들어 생성 시 201 코드를 사용하고 싶다면?
            반환 타입을 ResponseEntity(제네릭으로 UserRequest)의 .status()를 사용

            뿐만 아니라 .header()를 통해 헤더에 값을 줄 수 있음
         */

        //return user;
        //return user.toString();
        return response;
    }
}
