package com.spring.project1.project1.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data//getter,setter를 위해
public class PersonDto {
    // 데이터를 받고 싶지 않으면, 속성으로 포함 안시키면 됨.
    private  String name;
//    private  int age;
    private String hobby;
//    private String bloodType;
    private String address;
    private LocalDate birthday; // 원래는 Birthday타입이지만, 일단은 LocalDate로
    private String job;
    private String phoneNumber;
}
