package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class East extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east);
    }

    public void onMain(View view) {
        switch (view.getId()) {
            case R.id.Main:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    public void onNorth(View view) {
        switch (view.getId()) {
            case R.id.North:
                Intent intent = new  Intent(this, North.class);
                finish();
                startActivity(intent);break;
        }
    }

    public void onSouth(View view) {
        switch (view.getId()) {
            case R.id.South:
                Intent intent = new  Intent(this, South.class);
                finish();
                startActivity(intent);break;
        }
    }
}