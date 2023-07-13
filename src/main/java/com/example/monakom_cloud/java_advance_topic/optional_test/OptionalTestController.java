package com.example.monakom_cloud.java_advance_topic.optional_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("optional")
public class OptionalTestController {

    Car HONDA = null;
    Car AUDI = new Car("AUDI",2023, "AUDI R8");
    Optional<Car> BMW_Blank = Optional.empty();
    Optional<Car> BMW_M3 = Optional.of(new Car("BMW",2023, "BMW M3"));



    List<Person> peoples = List.of(
            new Person("liza", 18, Optional.ofNullable(HONDA)),
            new Person("heng", 18, BMW_M3),
            new Person("Bopha", 18, BMW_Blank),
            new Person("Sophea", 18, Optional.of(AUDI))
    );


    @GetMapping("test1")
    public String test01 (Person person) {

        // this case if car is empty it will error.
        return person.getCar().get().getName();

    }

    @GetMapping("test2")
    public String test02 (Optional<Person> person) {

        var style1 =  person.map(x-> x.getCar().get().getName()).get();

        var style2 = person.flatMap(Person::getCar).map(Car::getName).get();

        var style3 = person.flatMap(Person::getCar).map(Car::getName).orElse("Unknown");

        return style3;
    }



}
