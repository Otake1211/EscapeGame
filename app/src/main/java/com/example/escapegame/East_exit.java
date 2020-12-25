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
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class East_exit extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int seleitem;
    int selenum;

    MyMedia m = new MyMedia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east_exit);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //ボタンの画像読み込み
        new btnload().refresh();

        m.onCreate(this,R.raw.mainbgm);
    }

    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        m.onSe1();
    }


    public void onEast(View view) {
        Intent intent = new Intent(this, East.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        m.onSe2();
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {


        //タップしたとき
        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        int envcount = lib.getInt("east_exit", 0);
        SharedPreferences.Editor editor = lib.edit();

        ImageView backimage = ((ImageView) findViewById(R.id.backimage));

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                switch (envcount) {
                    case 0:

                        // 開く操作
                        if (seleitem == R.drawable.item_boxkey) {

                            //開けた効果音
                            m.onSe6();
                            editor.putInt("east_box", 1).apply();
                            backimage.setImageResource(R.drawable.south_rockerrighton);
                        } else {
                            //ガチャガチャ効果音
                            m.onSe4();
                        }

                        break;

                    case 1:
                        //ドアを開ける
                        m.onSe13();
                        //ドアを開けた画像

                        backimage.setImageResource(R.drawable.south_rockerrightoff);
                        editor.putInt("east_exit", 2).apply();
                        break;

                    case 2:
                        //脱出成功！！
                        m.onSe2();
                        m.onSe14();

                        Intent intent = new Intent(this, Endrool.class);
                        startActivity(intent);
                        finish();

                        //アクティビティ遷移フェードイン
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }
                break;
        }
        return false;
    }



    public void onitem1(View view) {
        new itemsele().itemselefun(view,R.id.itembutton1,"itembox1",1);
    }

    public void onitem2(View view) {
        new itemsele().itemselefun(view,R.id.itembutton2,"itembox2",2);
    }

    public void onitem3(View view) {
        new itemsele().itemselefun(view,R.id.itembutton3,"itembox3",3);
    }

    public void onitem4(View view) {
        new itemsele().itemselefun(view,R.id.itembutton4,"itembox4",4);
    }

    public void onitem5(View view) {
        new itemsele().itemselefun(view,R.id.itembutton5,"itembox5",5);
    }

    public void onitem6(View view) {
        new itemsele().itemselefun(view,R.id.itembutton6,"itembox6",6);
    }

    public void onitem7(View view) {
        new itemsele().itemselefun(view,R.id.itembutton7,"itembox7",7);
    }

    public void onitem8(View view) {
        new itemsele().itemselefun(view,R.id.itembutton8,"itembox8",8);
    }

    public void onitem9(View view) {
        new itemsele().itemselefun(view,R.id.itembutton9,"itembox9",9);
    }

    public void onitem10(View view) {
        new itemsele().itemselefun(view,R.id.itembutton10,"itembox10",10);
    }

    public void onitem11(View view) {
        new itemsele().itemselefun(view,R.id.itembutton11,"itembox11",11);
    }

    public void onitem12(View view) {
        new itemsele().itemselefun(view,R.id.itembutton12,"itembox12",12);
    }


    class itemsele {
        public void itemselefun (View view, int seleId, String selebox, int slnum) {

            //他のボタンを使えるようにする
            new otherable().reable(view);

            //このボタンを使えないようにする
            ImageButton imageButton = findViewById(seleId);
            imageButton.setEnabled(false);
            imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            //選択しているアイテムを変更
            SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
            seleitem = lib.getInt(selebox, R.drawable.clear);

            //選択しているボタンを取得
            selenum = slnum;
        }
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