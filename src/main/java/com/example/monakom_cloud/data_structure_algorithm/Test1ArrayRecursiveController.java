package com.example.monakom_cloud.data_structure_algorithm;

import com.example.monakom_cloud.core.Util;
import com.example.monakom_cloud.data_structure_algorithm.test_1_array.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("dsa")
public class Test1ArrayRecursiveController {

    @GetMapping("recursive")
    public void recursiveFunction() {
        log.info("====== recursiveFunction =====");

        Recursion recursion = new Recursion();
        int factor = recursion.factorial(5);
        System.out.println("factor :"+factor);



        int fibonacci = recursion.fibonacci(5);
        System.out.println("fibonacci :"+fibonacci);


        int sumOfDigits0 = recursion.sumOfDigits(11);// 11 = 1+1 = 2
        int sumOfDigits1 = recursion.sumOfDigits(112);// 112 = 11+2 = 4 -> 11 = 1+1 = 2
        System.out.println("sumOfDigits :"+sumOfDigits0);
        System.out.println("sumOfDigits :"+sumOfDigits1);


        int power = recursion.power(2, 4);
        System.out.println("Power of 2.power(4) = "+power);


        int gcd = recursion.gcd(8,4);
        System.out.println("GCD of 8, 4 is :"+gcd);


        int decimalToBinary = recursion.decimalToBinary(10);
        System.out.println("decimal : 10 => binary : "+ decimalToBinary);


        // find the num of (*) in array element start from index n => index 0
        int productOfArray = recursion.productOfArray(new int[]{2, 2, 2, 10, 5, 7}, 3);
        System.out.println("productOfArray : "+productOfArray);


        int sumOfNum = recursion.recursiveRange(4); // result = 10 because 1+2+3+4
        System.out.println("Sum of giving num 4 : "+sumOfNum);


    }

    @GetMapping("measure")
    public void measureWithBigO() {
        log.info("====== measureWithBigO =====");

        Util util = new Util();
        MeasureWithBigO measureWithBigO = new MeasureWithBigO();

        int[] customArray = {1,3,4,5};
        measureWithBigO.spoofArray(customArray);


        System.out.println("print the element of array by join arr[i] with arr[i+1]");
        util.printDateTime("Start");
        measureWithBigO.printParisOfArr(customArray);
        util.printDateTime("End  ");


        System.out.println("print the element");
        util.printDateTime("Start");
        measureWithBigO.printUnorderedPairs(customArray);
        util.printDateTime("End  ");



        measureWithBigO.reversArrayElement(customArray);
    }


    @GetMapping("arr")
    public void arrayTest() {

        MyArrayTestOne arrayTestOne = new MyArrayTestOne(5);
        arrayTestOne.insert(0,0);
        arrayTestOne.insert(1,10);
        arrayTestOne.insert(2,50);
        arrayTestOne.insert(1,15);
        arrayTestOne.insert(12,20);

        log.info("One dimension array");
        log.info(Arrays.toString(arrayTestOne.arr));



        MyArrayTestTwo arrayTestTwo = new MyArrayTestTwo(2,2);
        arrayTestTwo.insert(0,0,10);
        arrayTestTwo.insert(0,1,20);
        arrayTestTwo.insert(0,0,30);
        arrayTestTwo.insert(1,3,30);

        log.info("Two dimension array");
        log.info(Arrays.deepToString(arrayTestTwo.arr));
    }
}