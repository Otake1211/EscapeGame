package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class West_aquarium extends AppCompatActivity {


    int seleitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_west_aquarium);
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

    public void onitem1(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton1);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox1", R.color.black);
    }

    public void onitem2(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton2);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox2", R.color.black);
    }

    public void onitem3(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton3);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox3", R.color.black);
    }

    public void onitem4(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton4);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox4", R.color.black);
    }

    public void onitem5(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton5);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox5", R.color.black);
    }

    public void onitem6(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton6);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox6", R.color.black);
    }

    public void onitem7(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton7);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox7", R.color.black);
    }

    public void onitem8(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton8);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88000000, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox8", R.color.black);
    }

    public void onitem9(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton9);
        imageButton.setEnabled(false);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox9", R.color.black);
    }

    public void onitem10(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton10);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox10", R.color.black);
    }

    class otherable {

        public void reable(View view) {

            ImageButton reimageButton1 = findViewById(R.id.itembutton1);
            reimageButton1.setEnabled(true);
            reimageButton1.setColorFilter(null);

            ImageButton reimageButton2 = findViewById(R.id.itembutton2);
            reimageButton2.setEnabled(true);
            reimageButton2.setColorFilter(null);

            ImageButton reimageButton3 = findViewById(R.id.itembutton3);
            reimageButton3.setEnabled(true);
            reimageButton3.setColorFilter(null);

            ImageButton reimageButton4 = findViewById(R.id.itembutton4);
            reimageButton4.setEnabled(true);
            reimageButton4.setColorFilter(null);

            ImageButton reimageButton5 = findViewById(R.id.itembutton5);
            reimageButton5.setEnabled(true);
            reimageButton5.setColorFilter(null);

            ImageButton reimageButton6 = findViewById(R.id.itembutton6);
            reimageButton6.setEnabled(true);
            reimageButton6.setColorFilter(null);

            ImageButton reimageButton7 = findViewById(R.id.itembutton7);
            reimageButton7.setEnabled(true);
            reimageButton7.setColorFilter(null);

            ImageButton reimageButton8 = findViewById(R.id.itembutton8);
            reimageButton8.setEnabled(true);
            reimageButton8.setColorFilter(null);

            ImageButton reimageButton9 = findViewById(R.id.itembutton9);
            reimageButton9.setEnabled(true);
            reimageButton9.setColorFilter(null);

            ImageButton reimageButton10 = findViewById(R.id.itembutton10);
            reimageButton10.setEnabled(true);
            reimageButton10.setColorFilter(null);

            ImageButton reimageButton11 = findViewById(R.id.itembutton11);
            reimageButton11.setEnabled(true);
            reimageButton11.setColorFilter(null);

            ImageButton reimageButton12 = findViewById(R.id.itembutton12);
            reimageButton12.setEnabled(true);
            reimageButton12.setColorFilter(null);

        }
    }
}