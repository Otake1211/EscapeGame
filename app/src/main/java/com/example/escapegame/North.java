package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class North extends AppCompatActivity {

    int screenWidth;
    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        // ファイルの準備
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);

        // データの読込
        int envcount = lib.getInt("north", 0);

        //背景画像の場合分け
        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
        switch (envcount) {
            case 2:
                backimage.setImageResource(R.drawable.north);
                break;

            case 3:
                backimage.setImageResource(R.drawable.north0);
                break;
        }
    }


    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void onWest(View view) {
        Intent intent = new Intent(this, West.class);
        startActivity(intent);
        finish();
    }


    public void onEast(View view) {
        Intent intent = new Intent(this, East.class);
        startActivity(intent);
        finish();
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                if (523 < xplace && 977 < yplace && yplace < 1144) {
                    SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
                    //リトマス紙へ
                    int envcount = lib.getInt("north", 0);
                    if(envcount==0) {
                        AlertDialog.Builder north_desk = new AlertDialog.Builder(this);
                        north_desk.setMessage("リトマス紙(青)")
                                .setPositiveButton("OK", null).show();

                        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
                        backimage.setImageResource(R.drawable.north);

                        SharedPreferences.Editor editor = lib.edit();
                        editor.putInt("north", 2).apply();
                    }

                }

                if (xplace < 252 && 643 < yplace && yplace < 1196) {
                    //準備室へ
                    Intent intent = new Intent(this, North_preparationroom.class);
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