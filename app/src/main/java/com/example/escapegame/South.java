package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.media.SoundPool;

public class South extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int seleitem;
    int selenum;

    SoundPool soundPool;

    int se1;
    int se2;


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

        // ファイルの準備
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);

        // データの読込
        int envcount = lib.getInt("south", 0);

        //背景画像の場合分け
        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
        if (envcount == 2) {
            backimage.setImageResource(R.drawable.south2);
        }

        //ボタンの画像読み込み
        new btnload().refresh();

        //効果音再生準備
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(5)
                    .build();
        }

        se1 = soundPool.load(this,R.raw.decision33,1);
        se2 = soundPool.load(this,R.raw.foot,1);
    }


    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        soundPool.play(se1,1.0f,1.0f,0,0,1.0f);
    }


    public void onEast(View view) {
        Intent intent = new Intent(this, East.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        soundPool.play(se2,1.0f,1.0f,0,0,1.0f);
    }


    public void onWest(View view) {
        Intent intent = new Intent(this, West.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        soundPool.play(se2,1.0f,1.0f,0,0,1.0f);
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);


        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                if (830 < xplace && xplace < 940 && 520 < yplace && yplace < 646) {
                    // ファイルの準備
                    SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
                    // データの読込
                    int envcount = lib.getInt("south", 0);
                    //背景画像の場合分け
                    //鍵へ
                    if (envcount == 0) {
                        AlertDialog.Builder south_key = new AlertDialog.Builder(this);
                        south_key.setMessage("鍵")
                                .setPositiveButton("OK", null).show();

                        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
                        backimage.setImageResource(R.drawable.south2);

                        SharedPreferences.Editor editor = lib.edit();
                        int itemboxnum = lib.getInt("itemboxnum", 0);
                        itemboxnum++;
                        editor.putInt("itemboxnum", itemboxnum).apply();
                        editor.putInt("itembox" + itemboxnum, R.drawable.item_boxkey).apply();

                        editor.putInt("south", 2).apply();

                        //ボタンの画像読み込み
                        new btnload().refresh();
                    }
                }


                if (91 < xplace && xplace < 405 && 746 < yplace && yplace < 1011) {
                    //薬品金庫へ
                    Intent intent = new Intent(this, South_safeleft.class);
                    startActivity(intent);
                    finish();

                    //アクティビティ遷移フェードイン
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                    soundPool.play(se2,1.0f,1.0f,0,0,1.0f);
                }

                if (588 < xplace && xplace < 886 && 740 < yplace && yplace < 1004) {
                    //試薬金庫へ
                    Intent intent = new Intent(this, South_saferight.class);
                    startActivity(intent);
                    finish();

                    //アクティビティ遷移フェードイン
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                    soundPool.play(se2,1.0f,1.0f,0,0,1.0f);
                }

                if (308 < xplace && xplace < 444 && 1064 < yplace && yplace < 1271) {
                    //ロッカー左へ
                    Intent intent = new Intent(this, South_rockerleft.class);
                    startActivity(intent);
                    finish();

                    //アクティビティ遷移フェードイン
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                    soundPool.play(se2,1.0f,1.0f,0,0,1.0f);
                }

                if (555 < xplace && xplace < 705 && 1067 < yplace && yplace < 1278) {
                    //ロッカー右へ
                    Intent intent = new Intent(this, South_rockerright.class);
                    startActivity(intent);
                    finish();

                    //アクティビティ遷移フェードイン
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                    soundPool.play(se2,1.0f,1.0f,0,0,1.0f);
                }

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
        seleitem = lib.getInt("itembox1", R.drawable.clear);

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
        seleitem = lib.getInt("itembox2", R.drawable.clear);

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
        seleitem = lib.getInt("itembox3", R.drawable.clear);

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