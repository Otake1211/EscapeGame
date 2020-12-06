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

        // ファイルの準備
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);


        //ボタンの画像読み込み
        int itembox1 = lib.getInt("itembox1", R.drawable.clear);
        int itembox2 = lib.getInt("itembox2", R.drawable.clear);
        int itembox3 = lib.getInt("itembox3", R.drawable.clear);
        int itembox4 = lib.getInt("itembox4", R.drawable.clear);
        int itembox5 = lib.getInt("itembox5", R.drawable.clear);
        int itembox6 = lib.getInt("itembox6", R.drawable.clear);
        int itembox7 = lib.getInt("itembox7", R.drawable.clear);
        int itembox8 = lib.getInt("itembox8", R.drawable.clear);
        int itembox9 = lib.getInt("itembox9", R.drawable.clear);
        int itembox10 = lib.getInt("itembox10", R.drawable.clear);
        int itembox11 = lib.getInt("itembox11", R.drawable.clear);
        int itembox12 = lib.getInt("itembox12", R.drawable.clear);
        ImageView backimage1 = ((ImageView) findViewById(R.id.itembutton1));
        backimage1.setImageResource(itembox1);
        ImageView backimage2 = ((ImageView) findViewById(R.id.itembutton2));
        backimage2.setImageResource(itembox2);
        ImageView backimage3 = ((ImageView) findViewById(R.id.itembutton3));
        backimage3.setImageResource(itembox3);
        ImageView backimage4 = ((ImageView) findViewById(R.id.itembutton4));
        backimage4.setImageResource(itembox4);
        ImageView backimage5 = ((ImageView) findViewById(R.id.itembutton5));
        backimage5.setImageResource(itembox5);
        ImageView backimage6 = ((ImageView) findViewById(R.id.itembutton6));
        backimage6.setImageResource(itembox6);
        ImageView backimage7 = ((ImageView) findViewById(R.id.itembutton7));
        backimage7.setImageResource(itembox7);
        ImageView backimage8 = ((ImageView) findViewById(R.id.itembutton8));
        backimage8.setImageResource(itembox8);
        ImageView backimage9 = ((ImageView) findViewById(R.id.itembutton9));
        backimage9.setImageResource(itembox9);
        ImageView backimage10 = ((ImageView) findViewById(R.id.itembutton10));
        backimage10.setImageResource(itembox10);
        ImageView backimage11 = ((ImageView) findViewById(R.id.itembutton11));
        backimage11.setImageResource(itembox11);
        ImageView backimage12 = ((ImageView) findViewById(R.id.itembutton12));
        backimage12.setImageResource(itembox12);
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