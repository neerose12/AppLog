package com.example.logapp.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogFileTest {

    LogFile logFile;

    @Before
    public void setUp() throws Exception {
        logFile = new LogFile();
    }

    @Test
    public void checkDate(){
        String dateFormat = "dd-MMM-yyyy HH:mm:ss";
        assertEquals(LogFile.getCurrentDate().length(),dateFormat.length());
    }
}