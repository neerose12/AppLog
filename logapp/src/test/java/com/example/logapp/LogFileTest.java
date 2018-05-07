package com.example.logapp;

import com.example.logapp.utils.LogFile;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogFileTest {

    LogFile logFile;

    @Test
    public void retrofitLog() {
        logFile = new LogFile();
        assertNotNull(logFile);
    }

    @Test
    public void getCurrentDate() {
        String value  = logFile.getCurrentDate();
        assertEquals(true,value instanceof String);
        assertEquals("dd-MMM-yyyy HH:mm:ss".length(),logFile.getCurrentDate().length());

    }

    @Test
    public void writeFile() {
        String value  = new String("This is to write in file");
    }
}