package com.example.monakom_cloud.java_advance_topic.functional_programming;

import com.example.monakom_cloud.java_advance_topic.java8.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    interface ApplePredicate {
        public boolean test (Apple apple);
    }

    public void test(){
        List<Apple> data = Arrays.asList(

                new Apple("green",10),
                new Apple("green",5),
                new Apple("red",10),
                new Apple("red",5),
                new Apple("yellow",20)
        );

        /**
         * Using the
         * - custom Predicate and
         * - custom method name 'filterApple'
         */
        List<Apple> greenApples = filterApples(data, (Apple a) -> {return a.color == "green";});
        List<Apple> greenApples1 = filterApples(data, (Apple a) -> a.color == "green");
        List<Apple> greenApples2 = filterApples(data, a -> a.color == "green");





        /**
         * Using the
         * - build-in Predicate and
         * - custom method name 'filterApple'
         */
        List<Apple> redApples0 = filter(data, (Apple a) -> {return Objects.equals(a.color, "red");});
        List<Apple> redApples1 = filter(data, (Apple a) -> Objects.equals(a.color, "red"));




        /**
         * Using the
         * - build-in Predicate and
         * - build-in filter method with stream.api
         */
        List<Apple>redAppleWithWight5A = data.stream().filter(a-> Objects.equals(a.color, "red")).collect(Collectors.toList());
        List<Apple> redAppleWithWight5 = data.stream().filter((Apple a)->
        {
            return Objects.equals(a.color, "red") && a.weight == 5;
        }
        ).collect(Collectors.toList());



        /**
         * Using the
         * - build-in Predicate and
         * - build-in filter method with stream.api

         * ** split predicate out of lambda
         * why we do that?
         * because the filter condition may use in other place (reusable)
         */

        Predicate<Apple> yellowAppleNWight20 = (Apple a) -> a.color.equals("yellow") || a.weight==20;
        List<Apple> myYellowAppleNWight20 = data.stream().filter(yellowAppleNWight20).collect(Collectors.toList());





        /**
         * Using the
         * - build-in Predicate and
         * -custom filter method

         * ** split predicate out of lambda
         * ** split the custom filter
         */
        Predicate<Apple> yellowAppleNWight20_1 = (Apple a) -> a.color.equals("yellow") || a.weight==20;

        List<Apple> myYellowAppleNWight20_A = filter(data,yellowAppleNWight20_1);


    }

    public static List<Apple> filterApples(List<Apple> data, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>(10);

        for (Apple a : data){
            if (predicate.test(a)){
                result.add(a);
            }
        }

        return result;
    }

    public static <T> List<T> filter(List<T> data, Predicate<T> predicate) {
        List<T> result = new ArrayList<>(10);

        for (T t: data) {
            if (predicate.test(t)){
                result.add(t);
            }
        }

        return result;
    }
}
