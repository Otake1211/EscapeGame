package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class East extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east);
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility( View.SYSTEM_UI_FLAG_FULLSCREEN );
    }


    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void onNorth(View view) {
        Intent intent = new Intent(this, North.class);
        finish();
        startActivity(intent);
    }


    public void onSouth(View view) {
        Intent intent = new Intent(this, South.class);
        finish();
        startActivity(intent);
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {

        float xplace = motionEvent.getX();
        float yplace = motionEvent.getY();

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(xplace + "," + yplace)
                        .setPositiveButton("OK", null).show();
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