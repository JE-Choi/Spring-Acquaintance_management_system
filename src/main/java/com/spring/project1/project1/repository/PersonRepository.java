package com.spring.project1.project1.repository;

import com.spring.project1.project1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

// jpaRepository를 상속받은 interface를 만들면 crud메소드를 가집
public interface PersonRepository extends JpaRepository<Person, Long> { // Long은 Id타입임
    List<Person> findByName (String name);
    List<Person> findByBlockIsNull();
    List<Person> findByBloodType(String booldType);
    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthday")
    List<Person> findByMonthOfBirthday (@Param("monthOfBirthday")int monthOfBirthday);

    @Query(value = "select * from Person person where person.deleted = true", nativeQuery = true)
    List<Person> findPeopleDeleted();

//    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = ?1 and person.birthday.dayOfBirthday = ?2")
//    List<Person> findByMonthOfBirthday (int monthOfBirthday, int dayOfBirthday);

//    // name으로 값을 넣어주고 싶다면?
////    @Query(value = "select person from Person person " +
////            "where person.birthday.monthOfBirthday = :monthOfBirthday " +
////            "and person.birthday.dayOfBirthday = :dayOfBirthday")
////    List<Person> findByMonthOfBirthday (@Param("monthOfBirthday")int monthOfBirthday, @Param("dayOfBirthday")int dayOfBirthday);

//    // nativeQuery로 작성하려면?
//    @Query(value = "select * from person " +
//            "where month_of_birthday = :monthOfBirthday " +
//            "and day_of_birthday = :dayOfBirthday"
//            ,nativeQuery = true)
//    List<Person> findByMonthOfBirthday (@Param("monthOfBirthday")int monthOfBirthday, @Param("dayOfBirthday")int dayOfBirthday);
}
