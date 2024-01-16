package com.example.restapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //JsonNaming 사용 시 response가 snake case로(Object를 return 했을 때) 미사용 시 camel case
public class UserRequest {
    private String userName;
    private Integer userAge;    //JSON 사용 시 레퍼런스 타입을 사용하는 것을 추천,  default >>  int:0, Integer:null
    private String email;
    private Boolean isKorean;
}
