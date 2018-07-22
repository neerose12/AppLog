package com.example.user.applog;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.logapp.logger.Lg;
import com.example.logapp.logger.StartLogging;
import com.example.logapp.utils.LogFile;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_app_logger);
        Button btnLog = (Button) findViewById(R.id.btn_log);
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Test");
//        query.getInBackground("dmFqNfWGis", new GetCallback<ParseObject>() {
//            public void done(ParseObject object, ParseException e) {
//                if (e == null) {
//                    // object will be your game score
//                } else {
//                    // something went wrong
//                }
//            }
//        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lg.d("Hello checking log here");
            }
        });


    }


}
