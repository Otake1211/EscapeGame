package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class North_preparationroominside_rocer extends AppCompatActivity {

    int seleitem;
    int screenWidth;
    int screenHeight;
    int selenum;
    int touchcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_preparationroominside_rocer);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        // ファイルの準備
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);

        // データの読込
        int envcount = lib.getInt("north_preparationroominside_rocker", 0);

        //背景画像の場合分け
        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
        if (envcount == 1) {
            backimage.setImageResource(R.drawable.north_jyunbisiturocker2);
        }

        //ボタンの画像読み込み
        new btnload().refresh();
    }

    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onPreparationroom(View view) {
        Intent intent = new Intent(this, North_preparetionroominside.class);
        finish();
        startActivity(intent);
    }


    public void onPush1(View view) {
        new pushpass().pushdown("1");
    }

    public void onPush2(View view) {
        new pushpass().pushdown("2");
    }

    public void onPush3(View view) {
        new pushpass().pushdown("3");
    }

    public void onPush4(View view) {
        new pushpass().pushdown("4");
    }

    public void onPush5(View view) {
        new pushpass().pushdown("5");
    }

    public void onPush6(View view) {
        new pushpass().pushdown("6");
    }

    public void onPush7(View view) {
        new pushpass().pushdown("7");
    }

    public void onPush8(View view) {
        new pushpass().pushdown("8");
    }

    public void onPush9(View view) {
        new pushpass().pushdown("9");
    }

    class pushpass {

        public void pushdown(String prsnum) {
            if (touchcount < 4) {

                ((TextView) findViewById(R.id.passview)).setText(((TextView) findViewById(R.id.passview)).getText() + prsnum);
                touchcount++;
            } else {
                ((TextView) findViewById(R.id.passview)).setText(prsnum);

                touchcount = 1;
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        //タップしたとき
        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        int envcount = lib.getInt("north_preparationroominside_rocker", 0);
        SharedPreferences.Editor editor = lib.edit();

        ImageView backimage = ((ImageView) findViewById(R.id.backimage));


        switch (envcount) {

            case 0:
                // ガチャガチャ効果音

                break;

            case 1:
                //開ける操作
                //開いた音
                editor.putInt("north_preparationroominside_rocker", 2).apply();
                break;

            case 2:
                //アイテムを取っていない
                //アイテム有の画像
                backimage.setImageResource(R.drawable.south_rockerrighton);
                editor.putInt("north_preparationroominside_rocker", 3).apply();

                break;

            case 3:
                //アイテムをタッチ
                if (0 < xplace && 0 < yplace) {
                    AlertDialog.Builder siyaku = new AlertDialog.Builder(this);
                    siyaku.setMessage("粉")
                            .setPositiveButton("OK", null).show();

                    //アイテムなしの画像に
                    backimage.setImageResource(R.drawable.south_rockerrightoff);

                    //アイテム欄に追加と背景変更の保存
                    int itemboxnum = lib.getInt("itemboxnum", 0);
                    itemboxnum++;
                    editor.putInt("itemboxnum", itemboxnum).apply();
                    editor.putInt("itembox" + itemboxnum, R.drawable.item_rubymaterial).apply();
                    editor.putInt("north_preparationroominside_rocker", 4).apply();

                    //ボタンの画像読み込み
                    new btnload().refresh();
                }

                break;

            case 4:
                //アイテムなしの画像
                backimage.setImageResource(R.drawable.south_rockerrightoff);
        }
        return false;


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