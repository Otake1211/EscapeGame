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

                if (588 < xplace && xplace < 749 && 1133 < yplace && yplace < 1183) {
                    AlertDialog.Builder east_hikidasi = new AlertDialog.Builder(this);
                    east_hikidasi.setMessage("引き出し")
                            .setPositiveButton("OK", null).show();
                }
                if (473 < xplace && xplace < 605 && 878 < yplace && yplace < 1057) {
                    AlertDialog.Builder east_tana = new AlertDialog.Builder(this);
                    east_tana.setMessage("棚")
                            .setPositiveButton("OK", null).show();
                }
                if (649 < xplace && xplace < 820 && 906 < yplace && yplace < 1068) {
                    AlertDialog.Builder east_rbtana = new AlertDialog.Builder(this);
                    east_rbtana.setMessage("青と赤の棚")
                            .setPositiveButton("OK", null).show();
                }
                if (825 < xplace && 914 < yplace && yplace < 1045) {
                    AlertDialog.Builder east_ = new AlertDialog.Builder(this);
                    east_.setMessage("電子レンジ")
                            .setPositiveButton("OK", null).show();
                }
                if (xplace < 274 && 591 < yplace && yplace < 1201) {
                    AlertDialog.Builder east_deguti = new AlertDialog.Builder(this);
                    east_deguti.setMessage("出口")
                            .setPositiveButton("OK", null).show();
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