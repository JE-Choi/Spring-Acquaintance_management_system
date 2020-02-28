package com.spring.project1.project1.domain;

import com.spring.project1.project1.controller.dto.PersonDto;
import com.spring.project1.project1.domain.dto.Birthday;
import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(1)
    private int age;

    private  String hobby;
    @NonNull
    @Column(nullable = false)
    @NotEmpty
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

    public void set(@NotNull PersonDto personDto){
        //        name, age, hobby, bloodType, address, birthday, job, phoneNumber
        if (personDto.getAge() != 0){
            this.setAge(personDto.getAge());
        }
        if (!StringUtils.isEmpty(personDto.getHobby())){
            this.setHobby(personDto.getHobby());
        }
        if (!StringUtils.isEmpty(personDto.getBloodType())){
            this.setBloodType(personDto.getBloodType());
        }
        if (!StringUtils.isEmpty(personDto.getAddress())){
            this.setAddress(personDto.getAddress());
        }
        if (!StringUtils.isEmpty(personDto.getBirthday())){
            this.setBirthday(new Birthday(personDto.getBirthday()));
        }
        if (!StringUtils.isEmpty(personDto.getJob())){
            this.setJob(personDto.getJob());
        }
        if (!StringUtils.isEmpty(personDto.getPhoneNumber())){
            this.setPhoneNumber(personDto.getPhoneNumber());
        }
    }
}
