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


    /**
     * Question 4
     * Write a function to reverse an integer using numeric operators and without
     * using any arrays or other data structures.

     * The signature of the function is:
     * int f(int n)
     * Examples

     *  --------------------------------|--------------------------------------------------------------
     * | if the input integer is        | return                                                       |
     * |--------------------------------|--------------------------------------------------------------|
     * | 1234                           | 4321                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | 12005                          | 50021                                                        |
     * |--------------------------------|--------------------------------------------------------------|
     * | 1                              | 1                                                            |
     * |--------------------------------|--------------------------------------------------------------|
     * | 1000                           | 1                                                            |
     * |--------------------------------|--------------------------------------------------------------|
     * | 0                              | 0                                                            |
     * |--------------------------------|--------------------------------------------------------------|
     * | -12345                         | -54321                                                       |
     *  --------------------------------|--------------------------------------------------------------
     */
    @GetMapping("/q4")
    public Integer test4(@RequestParam int number) {


        //step 1 if number negative
        //step 2 make negative to positive => to fit with formula
        //step 3 apply revers formula
        //step 4 return the positive and multiply with signe
        //      - if input negative
        //      - return must as same as input (negative)


        //step 1
        int sing = 1;
        if (number<0){
            //step 2
            number = -number;
            sing = -1;
        }

        //step 3
        int n = 0;
        while (number!=0){



            // (number % 10) with somnol after. -> (a)
            // (sommol after. * 10)             -> (b)
            // a + b => to keep the digit consequent


            // ex
            //  => (1234 % 10) = 0.4
            //  => 0.4 * 10 => 4


            // next loop (n*10) + (number % 10)
            //           (4*10) + (3) => 43

            n= (n*10) + (number % 10);

            // (number / 10) to drop the last digit
            // ex
            // => (1234 / 10) => 123.4
            // => number = 123
            number = number / 10;

        }

        //step 4
        return n*sing;
    }



    /**
     * Question 5
     * Write a function to return an array containing all elements common to two
     * given arrays containing distinct positive integers. You should not use any inbuilt
     * methods. You are allowed to use any number of arrays.

     * The signature of the function is:
     * int[] f(int[] first, int[] second)

     * Examples:
     *  --------------------------------|--------------------------------------------------------------
     * | if the input parameters are    | return                                                       |
     * |--------------------------------|--------------------------------------------------------------|
     * | {1,8,3,2},{4,2,6,1}            | {1,2}                                                        |
     * |--------------------------------|--------------------------------------------------------------|
     * | {1,8,3,2,6},{2,6,1}            | {2,6,1}                                                      |
     * |--------------------------------|--------------------------------------------------------------|
     * | {1,3,7,9},{7,1,9,3}            | {1,3,7,9}                                                    |
     * |--------------------------------|--------------------------------------------------------------|
     * | {1,2}, {3,4}                   | {}                                                           |
     * |--------------------------------|--------------------------------------------------------------|
     * | {}, {1,2,3}                    | {}                                                           |
     * |--------------------------------|--------------------------------------------------------------|
     * | {1,2}, {}                      | {}                                                           |
     * |--------------------------------|--------------------------------------------------------------|
     * | {1,2}, null                    | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | null, {}                       | null                                                         |
     * |--------------------------------|--------------------------------------------------------------|
     * | null, null                     | null                                                         |
     *  --------------------------------|--------------------------------------------------------------

     * NOTE: To ease debugging, Will return a string array.
     */
    @GetMapping("/q5")
    public String test5(@RequestParam int[] arr1, @RequestParam int[] arr2) {


        log.info("arr1 " + Arrays.toString(arr1));
        log.info("arr2 " + Arrays.toString(arr2));

        if (arr1 == null || arr2 == null) return "null";
        if (arr1.length == 0 || arr2.length == 0) return "[]";

        int minSizeArr;
        int[] clone1, clone2;
        if (arr1.length < arr2.length) {
            clone1 = arr1;
            clone2 = arr2;
            minSizeArr = arr1.length;
        } else {
            clone1 = arr2;
            clone2 = arr1;
            minSizeArr = arr2.length;
        }


        int[] r = new int[minSizeArr];
        int found = 0;


        for (int i = 0; i < clone1.length; i++) {

            for (int k = 0; k < clone2.length; k++) {
                if (clone1[i] == clone2[k]) {
                    log.error("found : "+ clone2[k]);
                    r[found] = clone2[k];
                    found++;
                }
            }

        }


        int[] foundElement = new int[found];

        for (int i = 0; i < foundElement.length; i++) {

            if (r[i] != 0)
                foundElement[i] = r[i];
        }

        return Arrays.toString(foundElement);

    }


    /**
     * Question 6
     * Consider an array A with n of positive integers. An integer idx is called
     * a POE (point of equilibrium) of A, if A[0]+A[1]+...+A[idx-1] is equal to A[idx+1]+A[idx+2]+...+A[n-1].
     * Write a function to return POE of an array, if it exists and -1 otherwise.

     * The signature of the function is:
     * int f(int[] a)

     * Examples
     *  -------------------------|--------------------------------------------------------------
     * | if the input arrays are | return                                                       |
     * |-------------------------|--------------------------------------------------------------|
     * | {1,8,3,7,10,2}          | 3 Reason: a[0]+a[1]+a[2] is equal to a[4]+a[5]               |
     * |-------------------------|--------------------------------------------------------------|
     * | {1,5,3,1,1,1,1,1,1}     | 2 Reason: a[0]+a[1] is equal to a[3]+a[4]+a[5]+a[6]+a[7]+a[8]|
     * |-------------------------|--------------------------------------------------------------|
     * | {2,1,1,1,2,1,7}         | 5 Reason: a[0]+a[1]+a[2]+a[3]+a[4] is equal to a[6]          |
     * |-------------------------|--------------------------------------------------------------|
     * | {1,2,3}                 | -1 Reason: No POE                                            |
     * |-------------------------|--------------------------------------------------------------|
     * | {3,4,5,10}              | -1 Reason: No POE                                            |
     * |-------------------------|--------------------------------------------------------------|
     * | {1,2,10,3,4}            | -1 Reason: No POE                                            |
     *  -------------------------|--------------------------------------------------------------
     */

    @GetMapping("/q6")
    public Integer test6(@RequestParam int[] arr) {

        int poe = -1;
        int sumA = 0;

        for (int i = 0; i < arr.length; i++) {
            sumA += arr[i];

            int sumB = 0;
            for (int j = i+2; j < arr.length; j++) {
                sumB += arr[j];
            }

            //log.warn("sumA : "+ sumA + ", sumB : "+ sumB);

            if (sumA == sumB){
                poe = i+1;
                break;
            }
        }

        return poe;
    }

}