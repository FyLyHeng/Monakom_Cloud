package com.example.monakom_cloud.data_structure_algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MyArrayTestOne {
    int[] arr = null;

    public MyArrayTestOne(int size) {
        arr = new int[size];

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.MIN_VALUE;
//        }

        // this fill method mean same as code above
        Arrays.fill(arr, Integer.MIN_VALUE);

    }

    public void insert(int index, int value) {

        try {
            if (arr[index] == Integer.MIN_VALUE) { //-> this index is able to insert

                arr[index] = value;
                log.info("Successfully inserted");

            }else {
                log.warn("This index is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Invalid index of access array!");
        }
    }
}
