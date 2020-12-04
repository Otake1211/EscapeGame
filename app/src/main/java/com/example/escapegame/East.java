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


public class East extends AppCompatActivity {

    int screenWidth;
    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
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

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                if (588 < xplace && xplace < 749 && 1133 < yplace && yplace < 1220) {
                    //引き出しへ
                    Intent intent = new Intent(this, East_drawer.class);
                    startActivity(intent);
                    finish();
                }

                if (473 < xplace && xplace < 605 && 878 < yplace && yplace < 1057) {
                    //棚へ
                    Intent intent = new Intent(this, East_box.class);
                    startActivity(intent);
                    finish();
                }

                if (649 < xplace && xplace < 820 && 906 < yplace && yplace < 1068) {
                    //青と赤の棚へ
                    Intent intent = new Intent(this, East_rbbox.class);
                    startActivity(intent);
                    finish();
                }

                if (825 < xplace && 914 < yplace && yplace < 1045) {
                    //電子レンジへ
                    Intent intent = new Intent(this, East_wave.class);
                    startActivity(intent);
                    finish();
                }

                if (xplace < 274 && 591 < yplace && yplace < 1201) {
                    //出口へ
                    Intent intent = new Intent(this, East_door.class);
                    startActivity(intent);
                    finish();
                }

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