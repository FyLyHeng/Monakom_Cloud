package com.example.monakom_cloud.java_feature_8_17.java8.functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionTest {

    public interface Function<T,R> {
        R apply(T t);
    }

    public void test (){
        List<String> studentsName = Arrays.asList("heng","liza","bopha");

        /**
         * using of Function
         * - custom function interface
         * - custom map method
         */
        List<Integer> studentNameAsALength = mapCustom(studentsName,s -> s.length());//this s.length and String::length meaning the same
        List<Integer> studentNameAsALengthA = mapCustom(studentsName, String::length);




        /**
         * using of Function
         * - build-in function interface
         * - custom map method
         */
        List<Integer> studentNameAsALength1 = map(studentsName, String::length);
        List<String> studentNameUpperCase = map(studentsName, String::toUpperCase);



        /**
         * using of Function
         * - build-in function interface
         * - build-in map method with stream.api
         */
        var studentNameAsALength2 = studentsName.stream().map(String::toUpperCase).collect(Collectors.toList());
        var studentNameAsALength3 = studentsName.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static <T,R> List<R> mapCustom(List<T> list, Function<T,R> function) {
        List<R> result = new ArrayList<>();

        for (T t : list){
            result.add(function.apply(t));
        }

        return result;
    }
    public static <T,R> List<R> map(List<T> list, java.util.function.Function<T,R> function) {
        List<R> result = new ArrayList<>();

        for (T t : list){
            result.add(function.apply(t));
        }

        return result;
    }
}
