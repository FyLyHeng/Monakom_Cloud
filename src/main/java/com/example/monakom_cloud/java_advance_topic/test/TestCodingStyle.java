package com.example.monakom_cloud.java_advance_topic.test;


import java.util.Arrays;
import java.util.List;

public class TestCodingStyle {


    public void test() {

        List<String> names = Arrays.asList("liza","bopha","heng");


        //ImperativeStyle
        boolean isHeng = false;

        for (String name : names) {
            if (name == "heng"){
                isHeng = true;
                break;
            }
        }

        if (isHeng){
            System.out.println("Heng found");
        }else {
            System.out.println("Heng not found");
        }



        //DeclarativeStyle
        if (names.contains("heng")){
            System.out.println("Heng found");
        }else {
            System.out.println("Heng not found");
        }




        //what is function?
        // 1. pass obj to a fun
        // 2. Create obj in a fun
        // 3. Return obj from a fun

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("main thread invoke");
            }
        });
        th.start();
        System.out.println("Thread main");




        //What is High Order functions?
        // 1. pass fun within a function
        // 2. create fun within a fun
        // 3. return a fun from a fun

        Thread th1 = new Thread(()-> System.out.println("main thread 01 invoke"));
        th1.start();
        System.out.println("Thread 01 main");


    }

}
