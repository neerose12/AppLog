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

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class LogFile {


    public static void parseInit(Context context) {
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
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String formattedDate = df.format(c);
        return formattedDate;
    }


    public static void writeFile(String text) {
        ParseObject testObject = new ParseObject("Test");
        testObject.put("Log", text);
        testObject.saveInBackground();

        String dir = Environment.getExternalStorageDirectory() + File.separator + "myDirectory";
        File folder = new File(dir); //folder name
        folder.mkdirs();
        final File myFile = new File(dir, "logFile.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Observable<File> observable = Observable.just(myFile);
        observable.subscribe(new Observer<File>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(File file) {
                try {
                    FileOutputStream fOut = new FileOutputStream(file, true);
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                    myOutWriter.append(text);
                    myOutWriter.close();
                    fOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onComplete() {
            }
        });
    }
}
