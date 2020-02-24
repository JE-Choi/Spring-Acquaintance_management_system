package com.spring.project1.project1.domain;

import com.spring.project1.project1.domain.dto.Birthday;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id 자동생성을 위해
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    private  String hobby;
    @NonNull
    private String bloodType;
    private String address;
    @Valid
    @Embedded
    private Birthday birthday;
    private  String job;
    @ToString.Exclude //getter에서 제외할 항목 인자로 넣음
    private  String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block; // 해당 person에 관해서 block을 했는지에 대한 여부 저장
}
