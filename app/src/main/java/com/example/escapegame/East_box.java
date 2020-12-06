package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class East_box extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int seleitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east_box);
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
    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
                int envcount = lib.getInt("box", 0);

                ImageView backimage = ((ImageView) findViewById(R.id.backimage));

                if (envcount == 0) {
                    // 開く操作
                    if (seleitem == R.drawable.item_rockerkey) {

                        //開けた効果音
                        SharedPreferences.Editor editor = lib.edit();
                        editor.putInt("saferight", 1).apply();

                    } else {
                        //ガチャガチャ効果音
                    }
                }

                if (envcount == 1) {
                    //アイテムを取っていない
                    //アイテム有の画像
                    backimage.setImageResource(R.drawable.south_rockerrighton);
                    SharedPreferences.Editor editor = lib.edit();
                    editor.putInt("saferight", 2).apply();
                }

                if (envcount == 2) {

                    if (0 < xplace && 0 < yplace) {//試薬の上をタッチ
                        AlertDialog.Builder siyaku = new AlertDialog.Builder(this);
                        siyaku.setMessage("鉛筆")
                                .setPositiveButton("OK", null).show();
                        //アイテムなしの画像
                        backimage.setImageResource(R.drawable.south_rockerrightoff);

                        SharedPreferences.Editor editor = lib.edit();
                        editor.putInt("saferight", 3).apply();
                    }
                }

                if (envcount==3) {
                    //アイテムなしの画像
                    backimage.setImageResource(R.drawable.south_rockerrightoff);
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