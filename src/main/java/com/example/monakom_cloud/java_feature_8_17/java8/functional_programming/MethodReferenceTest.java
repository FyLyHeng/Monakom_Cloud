package com.example.monakom_cloud.java_feature_8_17.java8.functional_programming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class MethodReferenceTest {

    public void test() {

        /**
         * Static method reference
         */
        DoubleUnaryOperator sqrt1 = a -> Math.sqrt(a);
        DoubleUnaryOperator sqrt2 = Math::sqrt;


        IntBinaryOperator max = (a, b) -> Integer.max(a, b);
        IntBinaryOperator min = Integer::min;




        /**
         * Unbound Method reference
         * Methods That Do Not Take Any Argument
         */
        Function<String, Integer> toLength = s -> s.length();
        Function<String, Integer> toLength1 = String::length;


        Function<MyTest, String> getName1 = myTest -> myTest.getName();
        Function<MyTest, String> getName2 = MyTest::getName;





        /**
         * Bound Method References
         */
        Consumer<String> printer1 = s -> System.out.println(s);
        Consumer<String> printer2 = System.out::println;


        printer1.accept("lest-only1");
        printer2.accept("lest-only2");

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class MyTest {
        private String name;
        private String gender;
    }
}
