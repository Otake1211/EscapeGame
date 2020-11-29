package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebStorage;

public class North extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north);
    }


    public void onMain(View view) {
        switch (view.getId()) {
            case R.id.Main:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void onWest(View view) {
        switch (view.getId()) {
            case R.id.West:
                Intent intent = new  Intent(this, West.class);
                startActivity(intent);break;
        }
    }

    public void onEast(View view) {
        switch (view.getId()) {
            case R.id.East:
                Intent intent = new  Intent(this, East.class);
                startActivity(intent);break;
        }
    }

}