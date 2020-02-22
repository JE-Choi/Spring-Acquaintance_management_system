package com.spring.project1.project1.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
//@Getter
//@Setter
// (exclude = "phoneNumber") //getter에서 제외할 항목 인자로 넣음
//@ToString
@NoArgsConstructor
// @NonNull로 지정한 인자에 따른 생성자
@RequiredArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode

public class Person {
    @Id
    @GeneratedValue // Id 자동생성을 위해
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    private  String hobby;
    @NonNull
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private  String job;
    @ToString.Exclude //getter에서 제외할 항목 인자로 넣음
    private  String phoneNumber;

    // CascadeType.PERSIST : 따로 Block을 저장소에 저장하지 않아도, block 객체 생성하면 자동으로 저장소에 추가됨.
    // 속성 값 2개 부터 {}안에 넣기
    // CascadeType.MERGE : person객체의 block객체 값을 변경하고 다시 save하면 반영되게 하기
    // CascadeType.REMOVE : 관계가 끊긴 BLOCK까지 지움
    // CascadeType.ALL: CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE 를 모두 합친거
    // fetch = FetchType.EAGER : left outer join
    // optional = false : block의 값은 항상 필요하다.
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block; // 해당 person에 관해서 block을 했는지에 대한 여부 저장

//    // 8강 @EqualsAndHashCode로 대체
//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null){
//            return false;
//        }
//        Person person = (Person) obj;
//        if(!person.getName().equals(this.getName())){
//            return false;
//        }
//        if(person.getAge() != this.getAge()){
//            return false;
//        }
//        return true;
//    }
//  8강 @EqualsAndHashCode로 대체
//    // person1과 person2의 name,age만 같아도 hashcode를 동일하게 취급한다.
//    public int hashCode(){
//        return (name+age).hashCode();
//    }

//    6강
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
