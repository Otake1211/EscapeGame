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

public class South extends AppCompatActivity {


    int screenWidth;
    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south);

        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
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


    public void onEast(View view) {
        Intent intent = new Intent(this, East.class);
        startActivity(intent);
        finish();
    }


    public void onWest(View view) {
        Intent intent = new Intent(this, West.class);
        startActivity(intent);
        finish();
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int)(motionEvent.getX()*1000/screenWidth);
        int yplace = (int)(motionEvent.getY()*2000/screenHeight);


        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき
                if(xplace>91&&xplace<405&&yplace>746&&yplace<1011){
                AlertDialog.Builder south_yakuhinn = new AlertDialog.Builder(this);
                south_yakuhinn.setMessage("薬品金庫")
                        .setPositiveButton("OK", null).show();
                }

                if(588<xplace&&xplace<886&&740<yplace&&yplace<1004){
                    AlertDialog.Builder south_shiyaku = new AlertDialog.Builder(this);
                    south_shiyaku.setMessage("試薬金庫")
                            .setPositiveButton("OK", null).show();
                }

                if(308<xplace&&xplace<444&&1064<yplace&&yplace<1271){
                    AlertDialog.Builder south_leftrocker = new AlertDialog.Builder(this);
                    south_leftrocker.setMessage("ロッカー左")
                            .setPositiveButton("OK", null).show();
                }

                if(555<xplace&&xplace<705&&1067<yplace&&yplace<1278){
                    AlertDialog.Builder south_rightrocker = new AlertDialog.Builder(this);
                    south_rightrocker.setMessage("ロッカー右")
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