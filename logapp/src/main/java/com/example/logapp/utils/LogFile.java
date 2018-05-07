package com.example.logapp.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogFile {


    public LogFile() {

    }

    public static void retrofitLog(String response){
        String result ="\r\n"+ getCurrentDate() + "  "+response;
        writeFile(result);
    }


    public static String getCurrentDate(){
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String formattedDate = df.format(c);

        return formattedDate;
    }


    public static  void writeFile(String text) {
        String dir = Environment.getExternalStorageDirectory()+ File.separator+"myDirectory";
        //create folder
        File folder = new File(dir); //folder name
        folder.mkdirs();

        File myFile = new File(dir,"logFile.txt");
        if (myFile.exists()) {

        } else {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fOut = new FileOutputStream(myFile,true);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(text);
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
