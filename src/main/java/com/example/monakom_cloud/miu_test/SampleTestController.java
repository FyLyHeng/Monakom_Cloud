package com.example.monakom_cloud.miu_test;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Arrays;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("miu-test")
public class SampleTestController {


    /**
     *
     * Question 1
     * An array with an odd number of elements is said to be centered
     * if all elements (except the middle one) are strictly greater than the value
     * of the middle element. Note that only arrays with an odd number of elements
     * have a middle element. Write a function that accepts an integer array and
     * returns 1 if it is a centered array, otherwise it returns 0.
     * Examples:
     *  -----------------------|-----------------------------------------------------------------------
     * | if the input array is | return                                                                |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {1,2,3,4,5}           | 0 (the middle element 3 is not strictly less than all other elements) |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {3,2,1,4,5}           | 1 (the middle element 1 is strictly less than all other elements)     |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {3,2,1,4,1}           | 0 (the middle element 1 is not strictly less than all other elements) |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {1,2,3,4}             | 0 (no middle element)                                                 |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {}                    | 0 (no middle element)                                                 |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {10}                  | 1 (the middle element 10 is strictly less than all other elements)    |
     *  -----------------------------------------------------------------------------------------------
     *
     */

    @GetMapping("/q1")
    public int test1(@RequestParam int[] arr) {

        var aLength = arr.length;

        log.info("array length  :" + aLength);
        log.info("array element :" + Arrays.toString(arr));

        if (aLength == 0 || aLength %2 == 0) {
            return 0;
        }

        var midIndex = aLength/2;
        var midElement = arr[midIndex];
        log.info("min of array : "+ midIndex);
        log.info("min of array : "+ midElement);


        for (int i = 0; i < arr.length; i++) {

            if (midIndex != i && arr[i]<= midElement) {
                return 0;
            }
        }

        return 1;
    }


    /**
     *Question 2
     * Write a function that takes an array of integers as an argument and returns a
     * value based on the sums of the even and odd numbers in the array. Let X = the sum of the odd
     * numbers in the array and let Y = the sum of the even numbers. The function should return X - Y
     * The signature of the function is:
     * int f(int[] a)
     * Examples:
     *  -----------------------|-----------------------------------------------------------------------
     * | if input array is     | return                                                                |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {1}                   | 1                                                                     |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {1,2}                 | -1                                                                    |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {1,2,3}               | 2                                                                     |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {1,2,3,4}             | -2                                                                    |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {3,3,4,4}             | -2                                                                    |
     * |-----------------------|-----------------------------------------------------------------------|
     * | {}                    | 0                                                                     |
     *  -----------------------------------------------------------------------------------------------
     */

    @GetMapping("/q2")
    public int test2(@RequestParam int[] arr) {
        int even = 0;
        int ood = 0;

        for (int element : arr) {

            if (element % 2 == 0) {
                even += element;
            } else {
                ood += element;
            }
        }

        log.info(MessageFormat.format("ood : {0}, even : {1}", ood, even));

        return ood-even;

    }


    /**
     * Question 3
     * Write a function that accepts a character array, a zero-based start position and
     * a length. It should return a character array containing lengthCharacters starting with
     * the startCharacter of the input array. The function should do error checking on the start
     * position and the length and return null if the either value is not legal.

     * The function signature is:
     * char[] f(char[] a, int start, int len)
     *  --------------------------------|--------------------------------------------------------------
     * | if the input parameters are is | return                                                       |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 0, 4            | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 0, 3            | {'a','b','c'}                                                |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 0, 2            | {'a','b'}                                                    |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 0, 1            | {'a'}                                                        |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 1, 3            | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 1, 2            | {'b','c'}                                                    |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 1, 1            | {'b'}                                                        |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 2, 2            | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 2, 1            | {'c'}                                                        |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 3, 1            | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, 1, 0            | {}                                                           |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, -1, 2           | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | {'a','b','c'}, -1, -2          | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | {}, 0, 1                       | null                                                         |
     *  -----------------------------------------------------------------------------------------------
     * NOTE: To ease debugging, i will return string containing the characters
     */
    @GetMapping("/q3")
    public Object test3(@RequestParam char[] chars, @RequestParam int start, @RequestParam int length) {

        try {
            if (start<0 || length<0) {return "null";}

            var arrayResult = new char[length];

            for (int i = 0; i < arrayResult.length; i++) {
                arrayResult[i] = chars[start];
                start++;
            }

// I think the first one is much better because it doesn't declare a var j
//            for (int i = 0, j = start; i < arrayResult.length; i++, j++) {
//                arrayResult[i] = chars[j];
//            }

            return Arrays.toString(arrayResult);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "null";
        }
    }

}
