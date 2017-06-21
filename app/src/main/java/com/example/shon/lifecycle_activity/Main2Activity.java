package com.example.shon.lifecycle_activity;

import android.arch.lifecycle.LifecycleActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
