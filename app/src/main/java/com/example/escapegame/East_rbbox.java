package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class East_rbbox extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int touchcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east_rbbox);

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


    public void onEast(View view) {
        Intent intent = new Intent(this, East.class);
        startActivity(intent);
        finish();
    }
}