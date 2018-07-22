package com.example.user.applog;

import android.app.Application;

import com.example.logapp.logger.StartLogging;
import com.example.logapp.utils.LogFile;
import com.parse.Parse;
import com.parse.ParseObject;

public class MainApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        StartLogging.init(this);
    }
}
