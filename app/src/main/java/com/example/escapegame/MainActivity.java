package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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
                Intent intent = new Intent(this, Setting.class);
                startActivity(intent);
                break;
        }
    }

    public void onNorth(View view) {
        switch (view.getId()) {
            case R.id.North:
                Intent intent = new Intent(this, North.class);
                startActivity(intent);


                break;


        }
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:

                float xplace = motionEvent.getX();
                float yplace = motionEvent.getY();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(xplace+","+yplace)
                        .setPositiveButton("#", null);
                builder.show();
                break;
            case MotionEvent.ACTION_UP:
                // something to do
                break;
            case MotionEvent.ACTION_MOVE:
                // something to do
                break;
            case MotionEvent.ACTION_CANCEL:
                // something to do
                break;
        }

        return false;
    }


}