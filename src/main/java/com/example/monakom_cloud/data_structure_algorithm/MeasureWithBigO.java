package com.example.monakom_cloud.data_structure_algorithm;

import java.util.Arrays;

public class MeasureWithBigO {


    public void spoofArray(int[] arr) {

        int sum = 0;//-------------------------->  O(1)
        int product = 1;//---------------------->  O(1)

        for (int j : arr) { //------------------>  O(n)
            sum += j;//------------------------->  O(1)
            product *= j;//--------------------->  O(1)
        }

        System.out.println(sum+" ,"+product);//->  O(1)
        //total time complexity = 0(n)
    }


    public void printParisOfArr(int[] arr) {

        for (int i : arr) { //---------------------> O(n)
            for (int j : arr) { //-----------------> O(n) = O(n^2)
                System.out.print(i +"_"+ j +" ");//-> O(1)
            }
            System.out.println();
        }

        //total time complexity = 0(n)
    }


    public void printUnorderedPairs(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j=i+1; j <arr.length; j++) {
                System.out.print(arr[i]+""+arr[j]+" ");
            }
            System.out.println(" ");
        }
    }


    public void reversArrayElement(int[] arr) {

        for (int i = 0; i < arr.length/2; i++) {

            int lastIndex = arr.length-i-1;
            int tmp = arr[i];

            //swape last index to the first
            arr[i] = arr[lastIndex];

            //swape the first index to last
            arr[lastIndex] = tmp;

        }
        System.out.println(Arrays.toString(arr));
    }
}
