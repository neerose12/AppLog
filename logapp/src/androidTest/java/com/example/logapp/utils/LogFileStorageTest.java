package com.example.logapp.utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.ActivityCompat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LogFileStorageTest {

    @Test
    public void sdcardTest() {

        //check sdcard availability
        Assert.assertEquals("Media is not mounted!", Environment.getExternalStorageState(), Environment.MEDIA_MOUNTED);
        //get and check Permissions
        int grantResult = ActivityCompat.checkSelfPermission(InstrumentationRegistry.getTargetContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Assert.assertEquals(PackageManager.PERMISSION_GRANTED, grantResult);
        grantResult = ActivityCompat.checkSelfPermission(InstrumentationRegistry.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Assert.assertEquals(PackageManager.PERMISSION_GRANTED, grantResult);

        //finally try to create folder
        File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "test");
        if (!f.exists()) {
            boolean mkdir = f.mkdirs();
            Assert.assertTrue("Folder '" + f.getAbsolutePath() + "' not Present!", mkdir);
        }
        boolean delete = f.delete();
        Assert.assertTrue("Folder '" + f.getAbsolutePath() + "' is Present!", delete);
    }

}