package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class North_experiment extends AppCompatActivity {

    int selenum;
    int seleitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_experiment);

        //ボタンの画像読み込み
        new btnload().refresh();

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        //ボタンの画像読み込み
        ((ImageView) findViewById(R.id.rightbutton)).setImageResource(lib.getInt("rightbutton",R.color.black));
        ((ImageView) findViewById(R.id.leftbutton)).setImageResource(lib.getInt("leftbutton",R.color.black));

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


    public void onRight(View view) {

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = lib.edit();


        if (lib.getInt("rightbutton", R.color.black) == R.color.black) {

            if (0 != seleitem) {
                //代入
                editor.putInt("rightbutton", seleitem).apply();

                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.rightbutton)).setImageResource(seleitem);

                //アイテム削除
                for (int i = selenum; i < 12; i++) {
                    editor.putInt("itembox" + i, lib.getInt("itembox" + (i + 1), 0)).apply();
                }
                editor.putInt("itemboxnum", lib.getInt("itemboxnum", 0) - 1).apply();

                //他のボタンを使えるようにする
                new otherable().reable(view);

                //アイテム欄の画像読み込み
                new btnload().refresh();

                seleitem = 0;
            }

        } else {

            if (seleitem == 0) {
                //アイテム欄に元のアイテムを追加
                int itemboxnum = lib.getInt("itemboxnum", 0);
                itemboxnum++;
                editor.putInt("itemboxnum", itemboxnum).apply();
                editor.putInt("itembox" + itemboxnum, lib.getInt("rightbutton", 0)).apply();

                //アイテム欄の画像読み込み
                new btnload().refresh();

                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.rightbutton)).setImageResource(R.color.black);
                editor.putInt("rightbutton", R.color.black).apply();


            } else {

                //アイテム欄に元のアイテムを追加
                editor.putInt("itembox" + (lib.getInt("itemboxnum", 0) + 1), lib.getInt("rightbutton", 0)).apply();


                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.rightbutton)).setImageResource(R.color.black);
                editor.putInt("rightbutton", R.color.black).apply();

                //アイテム削除
                for (int i = selenum; i < 12; i++) {
                    editor.putInt("itembox" + i, lib.getInt("itembox" + (i + 1), 0)).apply();
                }

                //他のボタンを使えるようにする
                new otherable().reable(view);

                //アイテム欄の画像読み込み
                new btnload().refresh();

                seleitem = 0;
            }

        }
    }


    public void onLeft(View view) {

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = lib.edit();


        if (lib.getInt("leftbutton", R.color.black) == R.color.black) {

            if (0 != seleitem) {
                //代入
                editor.putInt("leftbutton", seleitem).apply();

                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.leftbutton)).setImageResource(seleitem);

                //アイテム削除
                for (int i = selenum; i < 12; i++) {
                    editor.putInt("itembox" + i, lib.getInt("itembox" + (i + 1), 0)).apply();
                }
                editor.putInt("itemboxnum", lib.getInt("itemboxnum", 0) - 1).apply();

                //他のボタンを使えるようにする
                new otherable().reable(view);

                //アイテム欄の画像読み込み
                new btnload().refresh();

                seleitem = 0;
            }

        } else {

            if (seleitem == 0) {
                //アイテム欄に元のアイテムを追加
                int itemboxnum = lib.getInt("itemboxnum", 0);
                itemboxnum++;
                editor.putInt("itemboxnum", itemboxnum).apply();
                editor.putInt("itembox" + itemboxnum, lib.getInt("leftbutton", R.color.black)).apply();

                //アイテム欄の画像読み込み
                new btnload().refresh();

                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.leftbutton)).setImageResource(R.color.black);
                editor.putInt("leftbutton", R.color.black).apply();


            } else {

                //アイテム欄に元のアイテムを追加
                editor.putInt("itembox" + (lib.getInt("itemboxnum", 0) + 1), lib.getInt("leftbutton", 0)).apply();


                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.leftbutton)).setImageResource(R.color.black);
                editor.putInt("leftbutton", R.color.black).apply();

                //アイテム削除
                for (int i = selenum; i < 12; i++) {
                    editor.putInt("itembox" + i, lib.getInt("itembox" + (i + 1), 0)).apply();
                }

                //他のボタンを使えるようにする
                new otherable().reable(view);

                //アイテム欄の画像読み込み
                new btnload().refresh();

                seleitem = 0;
            }

        }


    }


    public void onMake(View view) {


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

        //選択しているボタンを取得
        selenum = 1;
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

        //選択しているボタンを取得
        selenum = 2;
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

        //選択しているボタンを取得
        selenum = 3;
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

        //選択しているボタンを取得
        selenum = 4;
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

        //選択しているボタンを取得
        selenum = 5;
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

        //選択しているボタンを取得
        selenum = 6;
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

        //選択しているボタンを取得
        selenum = 7;
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

        //選択しているボタンを取得
        selenum = 8;
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

        //選択しているボタンを取得
        selenum = 9;
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

        //選択しているボタンを取得
        selenum = 10;
    }

    public void onitem11(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton11);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox11", R.color.black);

        //選択しているボタンを取得
        selenum = 11;
    }

    public void onitem12(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton12);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        seleitem = lib.getInt("itembox12", R.color.black);

        //選択しているボタンを取得
        selenum = 12;
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

    class btnload {

        public void refresh() {

            // ファイルの準備
            SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);

            //ボタンの画像読み込み
            ((ImageView) findViewById(R.id.itembutton1)).setImageResource(lib.getInt("itembox1", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton2)).setImageResource(lib.getInt("itembox2", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton3)).setImageResource(lib.getInt("itembox3", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton4)).setImageResource(lib.getInt("itembox4", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton5)).setImageResource(lib.getInt("itembox5", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton6)).setImageResource(lib.getInt("itembox6", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton7)).setImageResource(lib.getInt("itembox7", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton8)).setImageResource(lib.getInt("itembox8", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton9)).setImageResource(lib.getInt("itembox9", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton10)).setImageResource(lib.getInt("itembox10", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton11)).setImageResource(lib.getInt("itembox11", R.drawable.clear));
            ((ImageView) findViewById(R.id.itembutton12)).setImageResource(lib.getInt("itembox12", R.drawable.clear));


        }
    }
}