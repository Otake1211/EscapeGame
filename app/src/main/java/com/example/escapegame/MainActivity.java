package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSetting(View view) {
        switch (view.getId()) {
            case R.id.Setting:
            Intent intent = new  Intent(this, Setting.class);
        startActivity(intent);break;
        }
    }

    public void onStart(View view) {
        switch (view.getId()) {
            case R.id.Start:
                Intent intent = new  Intent(this, north.class);
                startActivity(intent);break;
        }
    }
}