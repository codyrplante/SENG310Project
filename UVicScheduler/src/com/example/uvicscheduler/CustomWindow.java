package com.example.uvicscheduler;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class CustomWindow extends Activity {
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
 
        setContentView(R.layout.activity_login);
 
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
 
    }
}