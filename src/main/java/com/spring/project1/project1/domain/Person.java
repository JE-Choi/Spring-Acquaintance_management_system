package com.spring.project1.project1.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
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
    @NonNull
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private  String job;
    @ToString.Exclude //getter에서 제외할 항목 인자로 넣음
    private  String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block; // 해당 person에 관해서 block을 했는지에 대한 여부 저장
}
