package com.example.monakom_cloud.java_advance_topic.java8.functional_programming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class SupplierTest {

    interface MySupplier<T> {
        T get();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class MyTest {
        private String name;
        private String gender;
    }
    MyTest myTest1 = new MyTest("liza", "female");


    public <T> void printMyTestWithPrefix(MySupplier<T> supplier) {
        System.out.println(supplier.get());
    }



    void test() {

        MySupplier<MyTest> upperCass = () -> {
            myTest1.name = myTest1.name.toUpperCase();
            return myTest1;
        };
        System.out.println(upperCass);


        printMyTestWithPrefix(upperCass);

        printMyTestWithPrefix(() -> {
            myTest1.name = "T-"+myTest1.name.toUpperCase();
            return myTest1;
        });

    }


    void test2 (){

        BooleanSupplier nameLengthValid10Digit = () -> myTest1.name.length() == 10;
        Supplier<Boolean> nameLengthValid10Digit1 = () -> myTest1.name.length() == 10;



    }



}
