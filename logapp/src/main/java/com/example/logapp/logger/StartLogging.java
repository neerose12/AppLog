package com.example.logapp.logger;

import android.content.Context;
import android.os.Environment;

import com.bosphere.filelogger.FL;
import com.bosphere.filelogger.FLConfig;
import com.bosphere.filelogger.FLConst;
import com.parse.Parse;

import java.io.File;

public class StartLogging  {


    public static void init(Context context){

        FL.init(new FLConfig.Builder(context)
                .defaultTag("Nettv Log")   // customise default tag
                .minLevel(FLConst.Level.V)   // customise minimum logging level
                .logToFile(true)   // enable logging to file
                .retentionPolicy(FLConst.RetentionPolicy.FILE_COUNT) // customise retention strategy
                .maxFileCount(FLConst.DEFAULT_MAX_FILE_COUNT)    // customise how many log files to keep if retention by file count
                .maxTotalSize(FLConst.DEFAULT_MAX_TOTAL_SIZE)    // customise how much space log files can occupy if retention by total size
                .build());


// overall toggle to enable/disable logging
        FL.setEnabled(true);
    }

    public static void initParse(Context context){
        Parse.initialize(context);
    }
}
