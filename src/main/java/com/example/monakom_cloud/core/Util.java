package com.example.monakom_cloud.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public void printDateTime(String desc) {

        Date now = new Date();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SSSSSSS");
        String formattedDate = format.format(now);

        System.out.println(desc+" : "+formattedDate);

    }
}
