package com.example.user.applog;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.logapp.logger.Lg;
import com.example.logapp.logger.StartLogging;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)  findViewById(R.id.btn_app_logger);
        Button btnLog = (Button) findViewById(R.id.btn_log);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CheckingLogging", "OK here");
                StartLogging.init(MainActivity.this);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lg.d("Hello checking log here");
            }
        });


    }



}
