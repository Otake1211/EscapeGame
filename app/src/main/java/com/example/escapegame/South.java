package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class South extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south);
    }

    public void onMain(View view) {
        switch (view.getId()) {
            case R.id.Main:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void onEast(View view) {
        switch (view.getId()) {
            case R.id.east:
                Intent intent = new  Intent(this, east.class);
                startActivity(intent);break;
        }
    }

    public void onWest(View view) {
        switch (view.getId()) {
            case R.id.west:
                Intent intent = new  Intent(this, west.class);
                startActivity(intent);break;
        }
    }
}