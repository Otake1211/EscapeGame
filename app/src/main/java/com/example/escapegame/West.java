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


public class West extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int seleitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_west);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        // ファイルの準備
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);

        // データの読込
        int envcount = lib.getInt("west", 0);

        //背景画像の場合分け
        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
        if (envcount == 2) {
            backimage.setImageResource(R.drawable.west2);
        }

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

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                if (41 < xplace && xplace < 122 && 940 < yplace && yplace < 1004) {
                    SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
                    //資料へ
                    int envcount = lib.getInt("west", 0);
                    if (envcount == 0) {
                        AlertDialog.Builder west_shiryou = new AlertDialog.Builder(this);
                        west_shiryou.setMessage("資料")
                                .setPositiveButton("OK", null).show();

                        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
                        backimage.setImageResource(R.drawable.west2);

                        SharedPreferences.Editor editor = lib.edit();
                        int itemboxnum = lib.getInt("itemboxnum", 0);
                        itemboxnum++;
                        editor.putInt("itemboxnum", itemboxnum).apply();
                        editor.putInt("itembox" + itemboxnum, R.drawable.item_wavedoc).apply();

                        editor.putInt("west", 2).apply();

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

                if (252 < xplace && xplace < 353 && 950 < yplace && yplace < 1041) {
                    //はかりへ
                    Intent intent = new Intent(this, West_scale.class);
                    startActivity(intent);
                    finish();
                }

                if (477 < xplace && xplace < 552 && 880 < yplace && yplace < 1004) {
                    //フラスコへ
                    Intent intent = new Intent(this, West_flask.class);
                    startActivity(intent);
                    finish();
                }

                if (730 < xplace && xplace < 922 && 783 < yplace && yplace < 944) {
                    //水槽へ
                    Intent intent = new Intent(this, West_aquarium.class);
                    startActivity(intent);
                    finish();
                }

                if (236 < xplace && xplace < 352 && 1094 < yplace && yplace < 1148) {
                    //引き出し左へ
                    Intent intent = new Intent(this, West_drawerleft.class);
                    startActivity(intent);
                    finish();
                }

                if (766 < xplace && xplace < 886 && 1091 < yplace && yplace < 1141) {
                    //引き出し右へ
                    Intent intent = new Intent(this, West_drawerright.class);
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