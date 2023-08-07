package com.example.monakom_cloud.java_advance_topic.java8.functional_programming;

import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionLambdaExpTest {


    void test1(){

        /**
         * Single function composed of two others function programming
         * Predicate Composition
         */

        Predicate<String> startWithA = (text) -> text.startsWith("A");
        Predicate<String> endWithX   = (text) -> text.endsWith("x");

        //Custom style
        Predicate<String> startWithAAndEndWithX = (text) -> startWithA.test(text) && endWithX.test(text);

        //Build in style (end condition)
        Predicate<String> composed = startWithA.and(endWithX);

        //Build in style (or condition)
        Predicate<String> composed2 = startWithA.or(endWithX);



        String input = "A hard working person must have much relax";
        boolean isMuch0 =  startWithAAndEndWithX.test(input);
        boolean isMuch1 =  composed.test(input);
        boolean isMuch2 =  composed2.test(input);
        System.out.println("Is '"+ input + "' start with A and end with x? : "+isMuch0);
        System.out.println("Is '"+ input + "' start with A and end with x? : "+isMuch1);
        System.out.println("Is '"+ input + "' start with A and end with x? : "+isMuch2);

    }


    void test2(){

        /**
         * Single function composed of two others function programming
         * Function Composition
         */

        Function<Integer, Integer> multiply = value -> value * 2;
        Function<Integer, Integer> plus     = value -> value + 3;

        Function<Integer, Integer> multiplyThenPlus = multiply.andThen(plus);
        Function<Integer, Integer> plusThenMultiply = multiply.compose(plus);

        Integer result1 = multiplyThenPlus.apply(10); // = 10 * 2 + 3
        Integer result2 = plusThenMultiply.apply(10); // = 10 + 3 * 2
        System.out.println(result1);
        System.out.println(result2);

    }


}








