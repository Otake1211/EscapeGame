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

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);


        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                if (91 < xplace && xplace < 405 && 746 < yplace && yplace < 1011) {
                    //薬品金庫へ
                    Intent intent = new Intent(this, South_safeleft.class);
                    startActivity(intent);
                    finish();
                }

                if (588 < xplace && xplace < 886 && 740 < yplace && yplace < 1004) {
                    //試薬金庫へ
                    Intent intent = new Intent(this, South_saferight.class);
                    startActivity(intent);
                    finish();
                }

                if (308 < xplace && xplace < 444 && 1064 < yplace && yplace < 1271) {
                    //ロッカー左へ
                    Intent intent = new Intent(this, South_rockerleft.class);
                    startActivity(intent);
                    finish();
                }

                if (555 < xplace && xplace < 705 && 1067 < yplace && yplace < 1278) {
                   //ロッカー右へ
                    Intent intent = new Intent(this, South_saferight.class);
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