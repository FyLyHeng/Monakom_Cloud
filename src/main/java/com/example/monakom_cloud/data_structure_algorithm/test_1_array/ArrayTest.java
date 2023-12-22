package com.example.monakom_cloud.data_structure_algorithm.test_1_array;

import java.util.Arrays;

public class ArrayTest {

    public void sampleArray() {
        int[] arr1; //-----------> O(1)
        arr1 = new int[3];//-----> O(1)
        arr1[0] = 1;//-----------> O(1)
        arr1[1] = 1;//-----------> O(1)
        arr1[2] = 1;//-----------> O(1)
        // total = O(N)

        System.out.println(Arrays.toString(arr1));



        int[] arr2 = {1,2,3}; //-----------> O(1)
        System.out.println(Arrays.toString(arr2));
    }

    public void OneDimensionArray() {

    }
}
