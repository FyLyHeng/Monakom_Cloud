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
public class MIUSampleTestController {


    /**
     * Question 1
     * An array with an odd number of elements is said to be centered
     * if all elements (except the middle one) are strictly greater than the value
     * of the middle element. Note that only arrays with an odd number of elements
     * have a middle element. Write a function that accepts an integer array and
     * returns 1 if it is a centered array, otherwise it returns 0.
     * Examples:
     * -----------------------|-----------------------------------------------------------------------
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
     * -----------------------------------------------------------------------------------------------
     */

    @GetMapping("/q1")
    public int test1(@RequestParam int[] arr) {

        var aLength = arr.length;

        log.info("array length  :" + aLength);
        log.info("array element :" + Arrays.toString(arr));

        if (aLength == 0 || aLength % 2 == 0) {
            return 0;
        }

        var midIndex = aLength / 2;
        var midElement = arr[midIndex];
        log.info("min of array : " + midIndex);
        log.info("min of array : " + midElement);


        for (int i = 0; i < arr.length; i++) {

            if (midIndex != i && arr[i] <= midElement) {
                return 0;
            }
        }

        return 1;
    }


    /**
     * Question 2
     * Write a function that takes an array of integers as an argument and returns a
     * value based on the sums of the even and odd numbers in the array. Let X = the sum of the odd
     * numbers in the array and let Y = the sum of the even numbers. The function should return X - Y
     * The signature of the function is:
     * int f(int[] a)
     * Examples:
     * -----------------------|-----------------------------------------------------------------------
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
     * -----------------------------------------------------------------------------------------------
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

        return ood - even;

    }


    /**
     * Question 3
     * Write a function that accepts a character array, a zero-based start position and
     * a length. It should return a character array containing lengthCharacters starting with
     * the startCharacter of the input array. The function should do error checking on the start
     * position and the length and return null if the either value is not legal.
     * <p>
     * The function signature is:
     * char[] f(char[] a, int start, int len)
     * --------------------------------|--------------------------------------------------------------
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
     * -----------------------------------------------------------------------------------------------
     * NOTE: To ease debugging, i will return string containing the characters
     */
    @GetMapping("/q3")
    public Object test3(@RequestParam char[] chars, @RequestParam int start, @RequestParam int length) {

        try {
            if (start < 0 || length < 0) {
                return "null";
            }

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
     * <p>
     * The signature of the function is:
     * int f(int n)
     * Examples
     * <p>
     * --------------------------------|--------------------------------------------------------------
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
     * --------------------------------|--------------------------------------------------------------
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
        if (number < 0) {
            //step 2
            number = -number;
            sing = -1;
        }

        //step 3
        int n = 0;
        while (number != 0) {


            // (number % 10) with somnol after. -> (a)
            // (sommol after. * 10)             -> (b)
            // a + b => to keep the digit consequent


            // ex
            //  => (1234 % 10) = 0.4
            //  => 0.4 * 10 => 4


            // next loop (n*10) + (number % 10)
            //           (4*10) + (3) => 43

            n = (n * 10) + (number % 10);

            // (number / 10) to drop the last digit
            // ex
            // => (1234 / 10) => 123.4
            // => number = 123
            number = number / 10;

        }

        //step 4
        return n * sing;
    }


    /**
     * Question 5
     * Write a function to return an array containing all elements common to two
     * given arrays containing distinct positive integers. You should not use any inbuilt
     * methods. You are allowed to use any number of arrays.
     * <p>
     * The signature of the function is:
     * int[] f(int[] first, int[] second)
     * <p>
     * Examples:
     * --------------------------------|--------------------------------------------------------------
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
     * --------------------------------|--------------------------------------------------------------
     * <p>
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
                    log.error("found : " + clone2[k]);
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
     * <p>
     * The signature of the function is:
     * int f(int[] a)
     * <p>
     * Examples
     * |-------------------------|--------------------------------------------------------------|
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
     * |-------------------------|--------------------------------------------------------------|
     */

    @GetMapping("/q6")
    public Integer test6(@RequestParam int[] arr) {

        // style 1
        /*
        int poe = -1;
        int sumA = 0;

        for (int i = 0; i < arr.length; i++) {
            sumA += arr[i];

            int sumB = 0;
            for (int j = i + 2; j < arr.length; j++) {
                sumB += arr[j];
            }

            //log.warn("sumA : "+ sumA + ", sumB : "+ sumB);

            if (sumA == sumB) {
                poe = i + 1;
                break;
            }
        }
        return poe;
        */


        //style 2
        //very advance, I never think about that kine of solution

        if (arr.length < 3) return -1;
        int i = 0;
        int j = arr.length - 1;
        int idx = 1;
        int leftSum = arr[i];
        int rightSum = arr[j];
        for (int k = 1; k < arr.length - 2; k++) {
            if (leftSum < rightSum) {
                i++;
                leftSum += arr[i];
                idx = i + 1;
            } else {
                j--;
                rightSum += arr[j];
                idx = j - 1;
            }

            log.warn("leftSum :"+leftSum+", rightSum :"+rightSum+" idx :"+idx);
        }
        if (leftSum == rightSum)
            return idx;
        else
            return -1;
    }


    /**
     * Question 7
     * Write a function nextPerfectSquare that returns the first perfect square that is greater than
     * it's integer argument. A perfect square is an integer that is equal to some integer squared.

     * For example 16 is a perfect square because 16 = 4*4. However 15 is not a perfect square because
     * there is no integer n such that 15 = n*n.

     * The signature of the function is
     * int isPerfectSquare(int n)
     * Examples
     *  -------------------------|--------------------------------------------------------------
     * | n                       | next perfect square                                          |
     * |-------------------------|--------------------------------------------------------------|
     * | 6                       | 9                                                            |
     * |-------------------------|--------------------------------------------------------------|
     * | 36                      | 49                                                           |
     * |-------------------------|--------------------------------------------------------------|
     * | 0                       | 1                                                            |
     * |-------------------------|--------------------------------------------------------------|
     * | -5                      | 0                                                            |
     *  -------------------------|--------------------------------------------------------------
     */

    /**
     * perfectSquare
     * 1	=	1 × 1	=	1.pow(2)
     * 4	=	2 × 2	=	2.pow(2)
     * 9	=	3 × 3	=	3.pow(2)
     * 16	=	4 × 4	=	4.pow(2)
     * 25	=	5 × 5	=	5.pow(2)
     * 36	=	6 × 6	=	6.pow(2)
     * 49	=	7 × 7	=	7.pow(2)
     * 64	=	8 × 8	=	8.pow(2)
     * 81	=	9 × 9	=	9.pow(2)
     * 100	=	10 × 10	=	10.pow(2)
     */
    @GetMapping("/q7")
    public Integer test7(@RequestParam int n) {

        if (n<0) return 0;


        //to find the Square number
        //ex1 : 9
        //   => s = 3
        //   because 3.pow(2) = 9


        //to find the Square number
        //ex2 : 10
        //   => s = 3.16
        //   => s (3.16) + 1 => 4.16
        //   s.toInt() => 4
        //   because 4.pow(2) = 16

        double perfectSquare = Math.sqrt(n);
        int base = (int) (perfectSquare+1);


        log.warn("perfectSquare :"+perfectSquare +" => "+base);

        return (int) Math.pow(base,2);

    }


    /**
     * Question 8
     * Define the n-upcount of an array to be the number of times the partial sum goes from less than
     * or equal to n to greater than n during the calculation of the sum of elements of the array.
     * if you are programming in Java or C#, the function signature is int nUpCount(int[] a, int n)

     * For example, if n=5, the 5-upcount of the array {2,3,1,-6,8,-3,-1,2} is 3.
     *  ------|--------|--------------|---------|---------------------------------
     * |index |element | partial sum  | upcount | comment                         |
     * |------|------|--------------|---------|---------------------------------|
     * | 0    | 2    | 2            |         |                                 |
     * |------|------|--------------|---------|---------------------------------|
     * | 1    | 3    | 5            |         |                                 |
     * |------|------|--------------|---------|---------------------------------|
     * | 2    | 1    | 6            | 1       | partial sum goes from 5 to 6    |
     * |------|------|--------------|---------|---------------------------------|
     * | 3    | -6   | 0            |         |                                 |
     * |------|------|--------------|---------|---------------------------------|
     * | 4    | 8    | 8            | 2       | partial sum goes from 0 to 8    |
     * |------|------|--------------|---------|---------------------------------|
     * | 5    | -3   | 5            |         |                                 |
     * |------|------|--------------|---------|---------------------------------|
     * | 6    | -1   | 4            |         |                                 |
     * |------|------|--------------|---------|---------------------------------|
     * | 7    | 2    | 6            | 3       | partial sum goes from 4 to 6    |
     *  ------|------|--------------|---------|---------------------------------
     */
    @GetMapping("/q8")
    public Integer test8(@RequestParam int[] arr, @RequestParam int n){


        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
            log.warn("sum : "+sum);
            if ( sum> n ){

                //sum = 0;
                count++;
                log.error("count :"+count);
            }
        }

        return count;
    }



    /**
     * Question 9
     * Write a function named primeCount with signature int primeCount(int start, int end);
     * The function returns the number of primes between start and end inclusive.
     * Recall that a prime is a positive integer greater than 1 whose only integer factors are 1 and itself.

     * Examples
     *  -------------|------------|---------|------------------------------------------------------------------
     * | if start is | and end is | return  | reason                                                           |
     * |-------------|------------|---------|------------------------------------------------------------------|
     * | 10          | 30         | 6       | The primes between 10 and 30 inclusive are 11,13,17,19,23 and 29 |
     * |-------------|------------|---------|------------------------------------------------------------------|
     * | 11          | 29         | 6       | The primes between 11 and 29 inclusive are 11,13,17,19,23 and 29 |
     * |-------------|------------|---------|------------------------------------------------------------------|
     * | 20          | 22         | 0       | 20,21, and 22 are all non-prime                                  |
     * |-------------|------------|---------|------------------------------------------------------------------|
     * | 1           | 1          | 0       | By definition, 1 is not a prime number                           |
     * |-------------|------------|---------|------------------------------------------------------------------|
     * | 5           | 5          | 1       | 5 is a prime number                                              |
     * |-------------|------------|---------|------------------------------------------------------------------|
     * | 6           | 2          | 0       | start must be less than or equal to end                          |
     * |-------------|------------|---------|------------------------------------------------------------------|
     * | -10         | 6          | 3       | primes are greater than 1. 2, 3 and 5 are prime                  |
     *  -------------|------------|---------|------------------------------------------------------------------
     */
    @GetMapping("/q9")
    public Integer test9(@RequestParam int start, @RequestParam int end) {

        int count = 0;

        for (int i = start; i < end; i++) {
            boolean isPrime = true;

            if (i > 1) {
                System.out.println();

                for (int j = 2; j * 2 <= i; j++) {

                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    log.error("prime "+i);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * input
     * 17
     *
     *
     * result process
     * 1,
     * 1,
     * 3*1(b) +2*1(a) = 5
     * 3*5(b) +2*1(a) = 17
     * 3*17(b) + 2*5(a) = 61

     */

    @GetMapping("/q10")
    public Integer test10(@RequestParam int n) {

        if (n<0) return 0;
        if (n==1) return 1;
        int c =0, a=1, b=1;

        while(c<n)
        {

            c = 3 * b + 2 * a;
            a =b;
            b =c;

            log.warn("[c"+c +"] [b"+b+"] [a"+a+"]");
        }
        if(c==n)
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }


    /**
     * Question 11
     * A Meera array is any array that contains the value 1 if and only if it contains 9.
     * It is okay if a Meera array contains more than one value 1 and more than one 9.

     * The array {7,9,0,10,1}       is a Meera array because it contains 1 and 9.
     * The array {6,10,8}           is a Meera array because it contains no 1 and no 9.
     * The array {7,6,1}            is not a Meera array because it contains 1 but does not contain a 9.
     * The array {9,10,0}           is not a Meera array because it contains a 9 but does not contain 1.
     * The array {1,1,0,8,0,9,9,1}  is a Meera array.

     * Write a function named isMeera that returns 1 if it's array argument is a Merra array
     * and returns 0 otherwise.
     * If you are programming in Java or C#, the function signature is int isMeera(int[] a)
     */

    @GetMapping("/q11")
    public Integer test11(@RequestParam int[] n) {

        boolean isMatchMin = false;
        boolean isMatchMax = false;

        for (int i = 0; i < n.length; i++) {

            if (n[i] == 1) isMatchMin = true;

            else if (n[i] == 9) isMatchMax = true;

        }

        if (isMatchMin == isMatchMax){
            return 1;
        }
        return 0;
    }


    /**
     * Question 12
     * A Bean array is defined to be an integer array where for every value n in the array,
     * there is also an element 2n, 2n+1 or n/2 in the array.

     * for example {4,9,8} is a Bean array because
     *      for 4, 8 is present,
     *      for 9, 4 is present,
     *      for 8, 4 is present.

     * Other Bean arrays include {2,2,5,11,23}, {7,7,3,6} and {0}.

     * Not a Bean array {3,8,4} because of the value 3 which
     * requires that the array contain either the value 6, 7 or 1 and none of these values are in the array.

     * Write a function named isBean that returns 1 if it's array argument is a Bean array,
     * otherwise it returns a 0.
     * if you are programming in Java or C#, the function signature is int isBean(int[] a)


     * explanation
     * ex: array[4,9,8] start from 4
     *      => [4 == 4*2] || [4 == 4*2+1] || [4 == 4/2] => not-all-case
     *      => [9 == 9*2] || [9 == 9*2+1] || [9 == 9/2] => not-all-case
     *      => [8 == 8*2] || [8 == 8*2+1] || [8 == 8/2] => true in last case (8 == 8/2)
     */
    @GetMapping("/q12")
    public Integer test12(@RequestParam int[] a) {
        int isBean = 0;

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length; j++) {

                log.info(a[i] +" == " +2*a[j] +" || "+ a[i] +" == "+ 2*a[j] + 1 +" || "+ a[i] +" == " +a[j]/2);

                if (a[i] == 2*a[j] || a[i] == 2*a[j] + 1 || a[i] == a[j]/2) {
                    isBean = 1;
                    break;
                }
            }
            return isBean;
        }
        return isBean;
    }


    /**
     * Question 13
     * Consider the positive integer 50. Note that 50 = 25 + 25 = 5^2 + 5^2 and 50 = 1 + 49 = 1^2 + 7^2,
     * Thus 50 can be expressed as a sum of the two squares in two different ways.
     * Write a method whether or not a positive integer n can be expressed as a sum of two squares in
     * exactly two different ways.
     * The signature of the function is
     * int answerOne(int n)
     */

    @GetMapping("/q13")
    public String test13(@RequestParam int n) {

        for (int i = 0; i <= n/2; i++) {

            int s1 = (int) Math.sqrt(i);
            int s2 = (int) Math.sqrt(n-i);

            if ( (Math.pow(s1,2)) + (Math.pow(s2,2)) == n){
                System.out.println(MessageFormat.format("Found : {0} = {1}^2 + {2}^2", n,s1,s2));
                return "Found";
            }
        }
        return n + " cannot be expressed as a sum of two squares";
    }


    /**
     * Question 14
     * Write a function that will return the most occurring number in an array. If there is more than
     * one such number, the function may return any one of them.
     * If you are programming in Java or C#, the function signature is int answerTwo(int[] a)
     *
     * Examples
     *  -------------------------|----------|------------------------------------------------------------
     * | a                       | return   | Explanation                                                |
     * |-------------------------|----------|------------------------------------------------------------|
     * | {6,8,1,8,2}             | 8        | 8 occurs two times. No other number occurs 3 or more times |
     * |-------------------------|----------|------------------------------------------------------------|
     * | {6,8,1,8,6,8}           | 8 or 6   | 8, 6. The Function may return either 8 or 6                |
     *  -------------------------|----------|------------------------------------------------------------

     */
    @GetMapping("/q14")
    public int test14(@RequestParam int[] n) {

        int mostOccurring = 0,pMostOccurring  = 0;
        int occurring = -1,pOccurring = -1;


        for (int i = 0; i < n.length; i++) {

            for (int j = i+1; j < n.length; j++) {

                if (n[i] == n[j]) {

                    if (mostOccurring>0){

                        if (occurring==n[i]){
                            mostOccurring++;
                        }else {
                            pOccurring = occurring;
                            pMostOccurring = mostOccurring;

                            occurring = n[i];
                            mostOccurring++;
                        }
                    }else {
                        occurring = n[i];
                        mostOccurring++;
                    }
                }
            }
        }

        if (pMostOccurring>mostOccurring){
            return pOccurring;
        }else {
            return occurring;
        }
    }


    /**
     * Question 15
     * Write a function that will return 1 if an integer array satisfies the following conditions and returns 0 otherwise.
     * 1. it has even numbers of elements
     * 2. Sum of all the numbers in the first half of the array is equal to the sum of all the numbers in the second half of the array.
     *
     * If you are programming in Java, the function Signature is
     * int answerThree(int[] a)
     * Examples
     *  -------------------|--------|-----------------------------------------------------------------------
     * | a                 | return | Explanation                                                           |
     * |-------------------|--------|-----------------------------------------------------------------------|
     * | {5,4,3,2,3,4,6,1} | 1      | *There are 8 (even) number of elements in the array. Thus condition 1 |
     * |                   |        | satisfied.                                                            |
     * |                   |        | *The sum of all the numbers in the first half = 5+4+3+2 = 14          |
     *  -------------------|--------|-----------------------------------------------------------------------
     */

    @GetMapping("/q15")
    public int test15(@RequestParam int[] n) {

        if (n.length%2!=0) return 0;

        int sum1 = 0, sum2=0;

        for (int i = 0; i < n.length/2; i++) {

            sum1+=n[i];
            sum2+=n[n.length-1-i];

        }

        if (sum1==sum2){
            return 1;
        }
        return 0;
    }


    /**
     * Question 16
     * A Madhav array has the following property.
     * a[0] = a[1] + a[2] = a[3] + a[4] + a[5] = a[6] + a[7] + a[8] + a[9] = ...
     * The length of a Madhav array must be n*(n+1)/2 for some n.
     * Write a method named isMadhavArray that returns 1 if its array argument is a Madhav array,
     * otherwise it returns 0. If you are programming in Java or C# the function signature is
     * int isMadhavArray(int[] a)
     *
     * Examples
     *  -----------------------------------|-------|---------------------------------------------------
     * | if a is                           | return| reason                                            |
     * |-----------------------------------|-------|---------------------------------------------------|
     * | {2,1,1}                           | 1     | 2 = 1 + 1                                         |
     * |-----------------------------------|-------|---------------------------------------------------|
     * | {2,1,1,4,-1,-1}                   | 1     | 2 = 1 + 1, 2 = 4 + -1 + -1                        |
     * |-----------------------------------|-------|---------------------------------------------------|
     * | {6,2,4,2,2,2,1,5,0,0}             | 1     | 6 = 2 + 4, 6 = 2 + 2 + 2, 6 = 1 + 5 + 0 + 0       |
     * |-----------------------------------|-------|---------------------------------------------------|
     * | {18,9,10,6,6,6}                   | 0     | 18 != 9 + 10                                      |
     * |-----------------------------------|-------|---------------------------------------------------|
     * | {-6,-3,-3,8,-5,-4}                | 0     | -6 != 8 + -5 + -4                                 |
     * |-----------------------------------|-------|---------------------------------------------------|
     * | {0,0,0,0,0,0,0,0,0,0,1,1,1,-2,-1} | 1     | 0 = 0+0, 0 = 0+0+0, 0 = 0+0+0+0, 0 = 1+1+1+-2+-1  |
     * |-----------------------------------|-------|---------------------------------------------------|
     * | {3,1,2,3,0}                       | 0     | The length of the array is 5, but 5 != n*(n+1)/2  |
     *  -----------------------------------|-------|---------------------------------------------------
     */
    @GetMapping("/q16")
    public int test16(@RequestParam int[] n) {

        int base = n[0];
        int sum = 0;
        int sumSize = 2;
        for (int i = 1; i < n.length; ) {

            try {
                for (int j = 0; j < sumSize; j++) {
                    log.warn("inner log " + i);
                    sum = sum + n[i];
                    i++;
                }

                log.error("check : " + sum + " && " + base);
                if (sum != base) return 0;

                sumSize++;
                sum = 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                return 0;
            }
        }

        return 1;
    }


    /**
     *
     * Question 17
     * An array is defined to be inertial if the following conditions hold:
     * a. it contains at least one odd value
     * b. the maximum value in the array is even
     * c. every odd value is greater than every even value that is not the maximum value.
     * so {11,4,20,9,2,8} is inertial because
     *  - it contains at least one odd value
     *  - the maximum value in the array is 20 which is even
     *  - the two odd values (11 and 9) are greater than all the even values that are not
     * equal to 20 (the maximum), i.e {4,2,8}.
     * However, {12,11,4,9,2,3,10} is not inertial because it fails condition (c), i.e.
     * 10 (which is even) is greater than 9 (which is odd), and 10 is not the maximum value
     * in the array.

     * Write a function called isInertial that accepts an integer array and returns 1 if the array
     * is inertial; otherwise it returns 0.
     * If you are programing in Java or C#, the function signature is
     * int isInertial(int[] a)

     * Some other examples:
     *  -----------------------|--------|-----------------------------------------------------------------------
     * | if the input array is | return | reason                                                                |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {1}                   | 0      | fails condition (a) - the maximum value must be even                  |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {2}                   | 0      | fails condition (b) - the array must contain at least one odd value   |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {1,2,3,4}             | 0      | fails condition (c) - 1(which is odd) is not greater than all even    |
     * |                       |        | values other than the maximum (1 is less than 2 which is not the max) |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {1,1,1,1,1,1,2}       | 1      | there is no even number other than the maximum. Hence, there can be no|
     * |                       |        | other even values that are greater than 1.                            |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {2,12,4,6,8,11}       | 1      | 11, the only odd value is greater than all even values except 12 which|
     * |                       |        | is the maximum value in the array.                                    |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {2,12,12,4,6,8,11}    | 1      | same as previous, ie, it is ok if maximum value occurs more than once |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {-2,-4,-6,-8,-11}     | 0      | -8, which is even, is not the maximum value but is greater than -11   |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {2,3,5,7}             | 0      | the maximum value is odd                                              |
     * |-----------------------|--------|-----------------------------------------------------------------------|
     * | {2,4,6,8,10}          | 0      | there is no odd value in the array                                    |
     *  -----------------------|--------|-----------------------------------------------------------------------

     * NOTE: To ease debugging, i will return a string
     */

    @GetMapping("/q17")
    public String test17(@RequestParam int[] n) {

        // style 1
        /*int max = 0;
        boolean isContainOdd = false;
        int[] evenOdd = new int[n.length];
        int evenIdx = 0;
        int oddIdx = n.length-1;

        for (int i = 0; i < n.length; i++) {

            if (n[i]%2==0) {
                evenOdd[evenIdx] = n[i];
                evenIdx++;

            }else {
                evenOdd[oddIdx] = n[i];
                oddIdx--;
                isContainOdd = true;
            }

            if (max <n[i]) max = n[i];

        }


        if (max%2!=0 || !isContainOdd) {
            log.warn(MessageFormat.format("max : {0} isContainOdd : {1}", max%2!=0, isContainOdd));
            return "false";
        }


        for (int i = 0; i < evenOdd.length; i++) {
            if (evenOdd[i] == max) continue;

            for (int j = evenIdx+1; j < evenOdd.length; j++) {

                if (evenOdd[i] < evenOdd[j]) {
                    log.warn("false cause of : "+ evenOdd[i]+" < " + evenOdd[j]);
                    return "false";
                }
            }
        }*/


        int max = 0, currentEven = 0,previousEven = 0, currentOdd = 0;
        boolean case3 = true;

        // style 2
        for (int i = 0; i < n.length; i++) {

            //check max
            if (max <n[i]) max = n[i];


            //check odd OR even
            if (n[i]%2==0) {
                currentEven = n[i];
            }else {
                currentOdd = n[i];

            }


            // odd must be small then even
            if (currentOdd < currentEven) {
                log.warn(MessageFormat.format("[currentOdd < currentEven : {0} {1}]", currentOdd, currentEven));
                case3 = false;
            }




            log.error(MessageFormat.format("current even {0}, previousEven {1}, currentOdd {2}, currentMax {3}", currentEven, previousEven, currentOdd, max));
        }

        if (currentOdd==0){
            log.warn(MessageFormat.format("fails cause [currentOdd == 0 : {0}]", currentOdd ));
            return "false";
        }

        if (max%2!=0) {
            log.warn(MessageFormat.format(" [max%2!=0 : {0}]", max%2));
            return "false";
        }

        if (!case3) {
            if (max == currentEven) {
                return "true";
            }
            return "false";
        }

        return "true";
    }
}