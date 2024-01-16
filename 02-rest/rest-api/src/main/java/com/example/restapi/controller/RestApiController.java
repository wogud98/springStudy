package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

@RestController //rest api를 처리해주는 컨트롤러로 지정
@RequestMapping("/api") //api로 시작하는 주소는 해당 컨트롤러로 받겠다
public class RestApiController {

    @GetMapping(path = "hello") // Get요청
    public String hello(){
        var html = "<html> <body> <h1> HELLO SPRINGBOOT </h1> </body> </html>";

        return html;
    }

    // GET맵핑의 {} 내 변수는, 클래스 내 pathvariable이 가지는 변수명과 동일해야하는데,
    // (name="")을 통해 파싱가능
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")  //주소는 대문자 사용x, - 사용으로 대체
    public String echo(
            @PathVariable(name ="message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        // TODO 대문자로 변환해서 RETURN
//        if(msg.equals("hi")) msg = "HI";
        System.out.println("echo message : "+msg);
        System.out.println("echo message : "+age);
        System.out.println("echo message : "+isMan);

        return msg.toUpperCase();
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=03&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }


    // http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=03&issuedDay=31
    @GetMapping(path = "/book2")
    public void queryParam(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    // TODO Parameter 2가지 받고, int형태로 받아 두 수의 덧셈, 곱셈 실시
    @GetMapping(path = "/book3")
    public  void calculate(
            @RequestParam int a,
            @RequestParam int b,
            @RequestParam boolean isGirl
    ){
        int sum1 = a+b;
        int gob1 = a*b;
        System.out.println(sum1);
        System.out.println(gob1);
        System.out.println(isGirl);
    }


}
