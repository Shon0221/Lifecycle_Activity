package com.example.shon.lifecycle_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task();
                task.setOnFinishListener(new Task.OnFinishListener() {
                    @Override
                    public void onFinish() {
                        startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                        finish();
                    }
                });
                task.execute();
            }
        });
    }
}
