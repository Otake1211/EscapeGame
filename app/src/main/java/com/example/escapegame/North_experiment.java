package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
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
        ((ImageView) findViewById(R.id.rightbutton)).setImageResource(lib.getInt("rightbutton", R.drawable.clear));
        ((ImageView) findViewById(R.id.leftbutton)).setImageResource(lib.getInt("leftbutton", R.drawable.clear));

    }


    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    public void onNorth(View view) {
        Intent intent = new Intent(this, North.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }


    public void onRight(View view) {

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = lib.edit();


        if (lib.getInt("rightbutton", R.drawable.clear) == R.drawable.clear) {

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
                ((ImageView) findViewById(R.id.rightbutton)).setImageResource(R.drawable.clear);
                editor.putInt("rightbutton", R.drawable.clear).apply();


            } else {

                //アイテム欄に元のアイテムを追加
                editor.putInt("itembox" + (lib.getInt("itemboxnum", 0) + 1), lib.getInt("rightbutton", 0)).apply();


                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.rightbutton)).setImageResource(seleitem);
                editor.putInt("rightbutton", seleitem).apply();

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


        if (lib.getInt("leftbutton", R.drawable.clear) == R.drawable.clear) {

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
                editor.putInt("itembox" + itemboxnum, lib.getInt("leftbutton", R.drawable.clear)).apply();

                //アイテム欄の画像読み込み
                new btnload().refresh();

                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.leftbutton)).setImageResource(R.drawable.clear);
                editor.putInt("leftbutton", R.drawable.clear).apply();


            } else {

                //アイテム欄に元のアイテムを追加
                editor.putInt("itembox" + (lib.getInt("itemboxnum", 0) + 1), lib.getInt("leftbutton", 0)).apply();


                //ボタンの画像読み込み
                ((ImageView) findViewById(R.id.leftbutton)).setImageResource(seleitem);
                editor.putInt("leftbutton", seleitem).apply();

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

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        int rightitem = lib.getInt("rightbutton", R.drawable.clear);
        int leftitem = lib.getInt("leftbutton", R.drawable.clear);

        if ((rightitem == R.drawable.clear ) || (leftitem == R.drawable.clear )) {
            new AlertDialog.Builder(North_experiment.this).setMessage("上の欄にアイテムを入れてね。\nアイテムを選択した後、四角をタップするとアイテムが入るよ。").setPositiveButton("OK", null).show();
        }

        //鉛筆と白い紙　黒い紙
        new maker().make(R.drawable.item_enpitsu, R.drawable.item_whiteaquariumpaper, R.drawable.item_blackaquariumpaper, "黒い紙", R.drawable.clear, R.drawable.item_enpitsu);

        //王水と金の鍵　準備室の鍵
        new maker().make(R.drawable.item_ousui, R.drawable.item_goldkey, R.drawable.item_junbisitukry, "準備室の鍵", R.drawable.clear, R.drawable.item_ousui);

        //アンモニアと赤いリトマス紙　金庫の暗号
        new maker().make(R.drawable.item_ammonia, R.drawable.item_litmusred, R.drawable.item_safecode, "金庫の暗号", R.drawable.clear, R.drawable.clear);

        //王水と青いリトマス紙　ロッカーの暗号
        new maker().make(R.drawable.item_ousui, R.drawable.item_litmusblue, R.drawable.item_rockercode, "ロッカーの暗号", R.drawable.clear, R.drawable.item_ousui);

        //鉛筆とカッター　黒鉛
        new maker().make(R.drawable.item_enpitsu, R.drawable.item_cutter, R.drawable.item_carbon, "黒鉛", R.drawable.clear, R.drawable.item_cutter);

        //瓶とカッター　王水
        new maker().make(R.drawable.item_cutter, R.drawable.item_rockedousui, R.drawable.item_ousui, "王水", R.drawable.clear, R.drawable.item_cutter);

    }


    public class maker {

        public void make(int itemA, int itemB, int product, String proname, int rightchange, int leftchange) {

            SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
            SharedPreferences.Editor editor = lib.edit();
            int rightitem = lib.getInt("rightbutton", R.drawable.clear);
            int leftitem = lib.getInt("leftbutton", R.drawable.clear);


            //アイテム判定
            if ((rightitem == itemA && leftitem == itemB) || (rightitem == itemB && leftitem == itemA)) {

                //得たアイテム表示
                new AlertDialog.Builder(North_experiment.this).setMessage(proname).setPositiveButton("OK", null).show();

                //使ったアイテムを使用後に変更
                editor.putInt("rightbutton", rightchange).apply();
                editor.putInt("leftbutton", leftchange).apply();

                ((ImageView) findViewById(R.id.rightbutton)).setImageResource(lib.getInt("rightbutton", R.drawable.clear));
                ((ImageView) findViewById(R.id.leftbutton)).setImageResource(lib.getInt("leftbutton", R.drawable.clear));

                //作ったアイテムをアイテム欄に追加
                int itemboxnum = lib.getInt("itemboxnum", 0);
                itemboxnum++;
                editor.putInt("itemboxnum", itemboxnum).apply();
                editor.putInt("itembox" + itemboxnum, product).apply();

                //アイテム欄の画像読み込み
                new btnload().refresh();

            }
        }
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