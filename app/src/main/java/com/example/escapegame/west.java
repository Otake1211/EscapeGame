package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class west extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_west);
    }

    public void onMain(View view) {
        switch (view.getId()) {
            case R.id.Main:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void onSouth(View view) {
        switch (view.getId()) {
            case R.id.south:
                Intent intent = new  Intent(this, south.class);
                startActivity(intent);break;
        }
    }

    public void onNorth(View view) {
        switch (view.getId()) {
            case R.id.north:
                Intent intent = new  Intent(this, north.class);
                startActivity(intent);break;
        }
    }

}