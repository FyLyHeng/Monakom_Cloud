package com.example.monakom_cloud.data_structure_algorithm;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.Arrays;

@Slf4j
public class MyArrayTestTwo {


    /**
     * This test01 and test02 is about create an array
     * test01 consume time more than test02 because it do 3 step separately
     * test02 consume much less than 01 because it do 3 step in only 1 execute line.
     */

    public void test01() {
        int[][] arr;
        arr = new int[2][2];

        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;

        //deepToString for print 2 dimension array
        System.out.println(Arrays.deepToString(arr));
    }

    public void test02(int index, int value) {

        int[][] arr = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(arr));
    }


    int[][] arr = null;

    public MyArrayTestTwo(int rowsSize, int columnsSize) {

        arr = new int[rowsSize][columnsSize];
    }

    public void insert(int rowIndex, int columnIndex, int value) {
        try {

            if (arr[rowIndex][columnIndex] == 0) {
                arr[rowIndex][columnIndex] = value;
                System.out.println("The value is successfully inserted");
            } else {
                System.out.println("This cell is already occupied");
            }


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array");
        }
    }

    public void accessCell(int rowIndex, int columnIndex) {

        System.out.println(MessageFormat.format("Accessing with Row{0}, Col{1}", rowIndex, columnIndex));

        try {
            System.out.println("Cell value is : "+arr[rowIndex][columnIndex]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array");
        }
    }


    public void travel() {

        //style 1 traditional style
        for (int row = 0; row < arr.length; row++) { //=> loop row

            for (int column = 0; column < arr[0].length; column++) { //=> loop column

                System.out.println(arr[row][column]);
            }
            System.out.println();
        }

        //style 2 modern style
        for (int[] ins : arr) { //=> loop row
            for (int column = 0; column < arr[0].length; column++) { //=> loop column
                System.out.println(ins[column]);
            }
            System.out.println();
        }



    }

}
