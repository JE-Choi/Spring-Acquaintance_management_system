package com.spring.project1.project1.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
// (exclude = "phoneNumber") //getter에서 제외할 항목 인자로 넣음
@ToString
@NoArgsConstructor
// @NonNull로 지정한 인자에 따른 생성자
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue // Id 자동생성을 위해
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    private  String hobby;
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private  String job;
    @ToString.Exclude //getter에서 제외할 항목 인자로 넣음
    private  String phoneNumber;

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        Person person = (Person) obj;
        if(!person.getName().equals(this.getName())){
            return false;
        }
        if(person.getAge() != this.getAge()){
            return false;
        }
        return true;
    }

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
