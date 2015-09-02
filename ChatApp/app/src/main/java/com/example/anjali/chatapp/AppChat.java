package com.example.anjali.chatapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by anjali on 31/8/15.
 */

public class AppChat extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "****", "****");
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
