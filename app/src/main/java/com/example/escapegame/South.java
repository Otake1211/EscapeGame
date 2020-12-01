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
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
    }

    public void onEast(View view) {
                Intent intent = new  Intent(this, East.class);
                startActivity(intent);
                finish();
    }

    public void onWest(View view) {
                Intent intent = new  Intent(this, West.class);
                startActivity(intent);
                finish();
    }
}