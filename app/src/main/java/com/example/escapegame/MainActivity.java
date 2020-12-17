package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.media.MediaPlayer;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;


public class MainActivity extends AppCompatActivity {

    int screenWidth;
    int screenHeight;

    MediaPlayer p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

    }


    @Override
    protected void onResume() {
        super.onResume();


        p = MediaPlayer.create(getApplicationContext(), R.raw.mainbgm);
        p.start();
        p.setLooping(true);


    }

    @Override
    protected void onPause() {
        super.onPause();
        p.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.release();
        p = null;
    }

    public void onSetting(View view) {

        p.release();
        p = null;

        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }


    public void onNorth(View view) {

        p.release();
        p = null;

        Intent intent = new Intent(this, North.class);
        startActivity(intent);
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("(" + xplace + "," + yplace + ")")
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