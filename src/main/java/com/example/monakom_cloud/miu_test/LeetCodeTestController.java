package com.example.monakom_cloud.miu_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LeetCodeTestController {

    /**
     * Sample Input
     * 5 -> number of line list
     * 5 [41 77 74 22 44]     -> line 1
     * 1 [12]                 -> line 2
     * 4 [37 34 36 52]        -> line 3
     * 0 []                   -> line 4
     * 3 [20 22 33]           -> line 5

     * 5    -> number of line list query
     * 1 3  -> will find in line q, element 3 (74). noted 1 is a row, 3 is the column
     * 3 4
     * 3 1
     * 4 3
     * 5 5

     * Sample Output
     * 74   -> output of filter 1
     * 52   -> output of filter 2
     * 37   -> output of filter 3
     * ERROR!   -> output of filter 4
     * ERROR!   -> output of filter 5
     */

    public void test2() {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        int numOfLine = s.nextInt();

        for (int i = 0; i < numOfLine; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            int arraySize = s.nextInt();

            for (int j = 0; j < arraySize; j++) {
                a.add(s.nextInt());
            }
            result.add(a);
        }


        int numOfQuery = s.nextInt();

         for (ArrayList<Integer> arrayList : result) {
             System.out.println(Arrays.toString(arrayList.toArray()));
         }


        for (int j = 0; j < numOfQuery; j++) {

            int srarchLine = s.nextInt()-1;
            int srarchValue = s.nextInt()-1;

             System.out.println("searchLine  :"+srarchLine);
             System.out.println("searchValue :"+srarchValue);

            try{
                System.out.println(result.get(srarchLine).get(srarchValue));
            }catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }

        }
    }





    /**
     * Sample Input

     * 5
     * 12 0 1 78 12
     * 2
     * Insert
     * 5 23
     * Delete
     * 0
     * Sample Output

     * 0 1 78 12 23
     */

    /**
     * Test Case
     * 50
     * 75192 14885 71431 34461 61231 21558 55622 36011 39791 94414 37813 30293 64822 11691 19285 98683 8562 6953 82718 63941 69534 35738 45068 95556 11046 85063 30936 11640 56380 65304 87804 60980 38266 10904 43475 26649 92856 90700 54044 2437 88357 17442 73368 39722 15320 14133 47254 69024 5565 95080
     * 100
     * Insert
     * 44 30237
     * Insert
     * 34 57126
     * Insert
     * 33 5418
     * Insert
     * 30 66954
     * Delete
     * 13
     * Insert
     * 4 38588
     * Insert
     * 38 28360
     * Insert
     * 24 23895
     * Insert
     * 11 17252
     * Insert
     * 11 71596
     * Insert
     * 40 14091
     * Insert
     * 35 4795
     * Insert
     * 7 17464
     * Insert
     * 53 86360
     * Delete
     * 14
     * Insert
     * 46 34128
     * Insert
     * 28 51603
     * Insert
     * 28 8849
     * Insert
     * 19 6186
     * Insert
     * 19 98707
     * Insert
     * 61 16274
     * Delete
     * 24
     * Insert
     * 39 97288
     * Delete
     * 52
     * Delete
     * 63
     * Insert
     * 6 81894
     * Insert
     * 47 49553
     * Insert
     * 41 35054
     * Delete
     * 64
     * Delete
     * 9
     * Delete
     * 14
     * Insert
     * 14 59312
     * Delete
     * 57
     * Delete
     * 23
     * Delete
     * 0
     * Insert
     * 24 80902
     * Delete
     * 29
     * Insert
     * 27 62978
     * Delete
     * 50
     * Delete
     * 9
     * Delete
     * 51
     * Delete
     * 31
     * Delete
     * 30
     * Delete
     * 53
     * Delete
     * 18
     * Insert
     * 54 91123
     * Delete
     * 48
     * Delete
     * 3
     * Delete
     * 32
     * Delete
     * 21
     * Insert
     * 22 23587
     * Delete
     * 43
     * Delete
     * 7
     * Delete
     * 38
     * Delete
     * 31
     * Delete
     * 20
     * Delete
     * 41
     * Insert
     * 29 76024
     * Insert
     * 48 64945
     * Insert
     * 15 64814
     * Delete
     * 51
     * Delete
     * 46
     * Delete
     * 46
     * Delete
     * 37
     * Insert
     * 40 35367
     * Delete
     * 42
     * Insert
     * 0 51387
     * Insert
     * 36 82795
     * Insert
     * 46 67350
     * Delete
     * 49
     * Delete
     * 1
     * Insert
     * 26 89312
     * Delete
     * 20
     * Insert
     * 46 82353
     * Delete
     * 7
     * Insert
     * 45 37176
     * Delete
     * 48
     * Delete
     * 37
     * Delete
     * 41
     * Insert
     * 34 31705
     * Delete
     * 5
     * Insert
     * 21 63912
     * Insert
     * 14 73658
     * Delete
     * 39
     * Insert
     * 46 13825
     * Delete
     * 11
     * Delete
     * 10
     * Insert
     * 20 7286
     * Delete
     * 0
     * Delete
     * 36
     * Insert
     * 17 78144
     * Delete
     * 27
     * Delete
     * 12
     * Delete
     * 10
     * Insert
     * 23 6220
     * Insert
     * 24 55859
     * Delete
     * 29
     * Delete
     * 9
     * Insert
     * 29 56901
     * Insert
     * 18 10362
     */
    public void  test3 () {

        Scanner s = new Scanner(System.in);

        ArrayList<Integer> a = new ArrayList<>();
        int maxIndex = s.nextInt();

        for (int i = 0; i < maxIndex; i++) {
            a.add(s.nextInt());
        }

        int operatorCount = s.nextInt();

        for (int i = 0; i < operatorCount; i++) {

            String ope = s.next();

            if (ope.equals("Insert")){
                a.add(s.nextInt(), s.nextInt());
            }

            else if (ope.equals("Delete")) {
                a.remove(s.nextInt());
            }
        }

        for (Integer integer : a) {

            System.out.print(integer+" ");
        }

    }



}
