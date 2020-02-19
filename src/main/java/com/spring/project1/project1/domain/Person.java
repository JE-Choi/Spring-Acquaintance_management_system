package com.spring.project1.project1.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString // (exclude = "phoneNumber") //getter에서 제외할 항목 인자로 넣음
public class Person {
    @Id
    @GeneratedValue // Id 자동생성을 위해
    private Long id;
    private String name;
    private  int age;
    private  String hobby;
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private  String job;
    @ToString.Exclude //getter에서 제외할 항목 인자로 넣음
    private  String phoneNumber;



//    // alt + insert => toString
//    //객체의 속성값을 반환
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", hobby='" + hobby + '\'' +
//                ", bloodType='" + bloodType + '\'' +
//                ", address='" + address + '\'' +
//                ", birthday=" + birthday +
//                ", job='" + job + '\'' +
//                '}';
//    }
}
