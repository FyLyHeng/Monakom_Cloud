package com.example.monakom_cloud.java_advance_topic.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BehavoirParameterization {
    interface ApplePredicate {
        public boolean test (Apple apple);
    }

    public void test(){
        List<Apple> data = Arrays.asList(
                new Apple("green",10),
                new Apple("green",5),
                new Apple("red",10),
                new Apple("red",5)
        );


        List<Apple> greenApples = filterApples(data, (Apple a) -> {return a.color == "green";});
        List<Apple> greenApples1 = filterApples(data, (Apple a) -> a.color == "green");
        List<Apple> greenApples2 = filterApples(data, a -> a.color == "green");

        System.out.println(greenApples);
        System.out.println(greenApples1);
        System.out.println(greenApples2);



        List<Apple> redApples = filter(data, (Apple a) -> {return Objects.equals(a.color, "red");});
        List<Apple> redApples1 = filter(data, (Apple a) -> Objects.equals(a.color, "red"));

        List<Apple> redApples2 = filter(data, a ->
                Objects.equals(a.color, "red")
        );

        List<Apple> redApples3 = filter(data, (Apple a) ->
        {
            return Objects.equals(a.color, "a");
        });


        System.out.println(redApples);
        System.out.println(redApples1);
        System.out.println(redApples2);
        System.out.println(redApples3);

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

