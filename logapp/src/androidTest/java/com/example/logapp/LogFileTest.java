package com.example.logapp;

import com.example.logapp.utils.LogFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogFileTest {

    LogFile logFile;

    @Before
    public void setUp() throws Exception {
        logFile = new LogFile();
        writeFile();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void retrofitLog() {

    }

    @Test
    public void getCurrentDate() {
    }

    @Test
    public void writeFile() {
//        ShadowEnvironment.setExternalStorageState(Environment.MEDIA_MOUNTED);

        logFile.writeFile(null);
    }
}