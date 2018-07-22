package com.example.logapp.logger;

import android.util.Log;

import com.parse.ParseObject;

public class Lg {

    public static void d(String log) {
        Log.d("NETTV APP",log);
    }
    public static void v(String log) {
        Log.v("NETTV APP",log);
    }

    public static void e(String log) {
        Log.e("NETTV APP",log);
    }

    public static void w(String log) {
        Log.w("NETTV APP",log);
    }

    public static void i(String log) {
        Log.i("NETTV APP",log);
    }
}
