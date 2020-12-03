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


public class West extends AppCompatActivity {

    int screenWidth;
    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_west);
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


    public void onSouth(View view) {
        Intent intent = new Intent(this, South.class);
        startActivity(intent);
        finish();
    }


    public void onNorth(View view) {
        Intent intent = new Intent(this, North.class);
        startActivity(intent);
        finish();
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int)(motionEvent.getX()*1000/screenWidth);
        int yplace = (int)(motionEvent.getY()*2000/screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき
                if(41<xplace&&xplace<122&&940<yplace&&yplace<1004){
                    AlertDialog.Builder west_shiryou = new AlertDialog.Builder(this);
                    west_shiryou.setMessage("資料")
                            .setPositiveButton("OK", null).show();
                }

                if(252<xplace&&xplace<353&&950<yplace&&yplace<1041){
                AlertDialog.Builder west_hakari = new AlertDialog.Builder(this);
                    west_hakari.setMessage("はかり")
                        .setPositiveButton("OK", null).show();
                }

                if(477<xplace&&xplace<552&&880<yplace&&yplace<1004){
                AlertDialog.Builder west_furasuko = new AlertDialog.Builder(this);
                    west_furasuko.setMessage("フラスコ")
                        .setPositiveButton("OK", null).show();
                }

                if(730<xplace&&xplace<922&&783<yplace&&yplace<944){
                AlertDialog.Builder west_suisou = new AlertDialog.Builder(this);
                    west_suisou.setMessage("水槽")
                        .setPositiveButton("OK", null).show();
                }

                if(236<xplace&&xplace<352&&1094<yplace&&yplace<1148){
                AlertDialog.Builder west_lefthikidashi = new AlertDialog.Builder(this);
                    west_lefthikidashi.setMessage("引き出し左")
                        .setPositiveButton("OK", null).show();
            }

                if(766<xplace&&xplace<886&&1091<yplace&&yplace<1141){
                AlertDialog.Builder west_righthikidashi = new AlertDialog.Builder(this);
                    west_righthikidashi.setMessage("引き出し右")
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