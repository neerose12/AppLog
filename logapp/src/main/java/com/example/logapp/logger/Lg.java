package com.example.logapp.logger;

import com.bosphere.filelogger.FL;
import com.parse.ParseObject;

public class Lg {

    public static void d(String log) {
        FL.d(log);

        ParseObject gameScore = new ParseObject("AppLog");
        gameScore.put("Log", log);
        gameScore.saveInBackground();
    }
    public static void v(String log) {
        FL.v(log);
    }

    public static void e(String log) {
        FL.e(log);
    }

    public static void w(String log) {
        FL.w(log);
    }

    public static void i(String log) {
        FL.i(log);
    }



}
