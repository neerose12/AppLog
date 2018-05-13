package com.example.logapp.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LogFile {


    public static void init(Context context) {
        Parse.initialize(new Parse.Configuration.Builder(context)
                .applicationId("z5ZmT4MYin2rFDpvIGDkGsH7vFMlx5IcT7s1Rv4b")
                .clientKey("wjltWX6q55St4zE80fTspGHmRmiSt3x3yYCs0QY4")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }

    public static void log(String response) {
        String result = "\r\n" + getCurrentDate() + "  " + response;
        writeFile(result);
    }


    public static String getCurrentDate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String formattedDate = df.format(c);

        return formattedDate;
    }


    public static void writeFile(String text) {

        Log.d("Checking i am here", "here");
        ParseObject testObject = new ParseObject("Test");
        testObject.put("Log", text);
        testObject.saveInBackground();

        String dir = Environment.getExternalStorageDirectory() + File.separator + "myDirectory";
        //create folder
        File folder = new File(dir); //folder name
        folder.mkdirs();

        File myFile = new File(dir, "logFile.txt");
        if (myFile.exists()) {

        } else {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fOut = new FileOutputStream(myFile, true);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(text);
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
