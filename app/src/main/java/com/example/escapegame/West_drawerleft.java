package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.widget.ImageButton;
import android.widget.ImageView;

public class West_drawerleft extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int touchcount = 0;
    int seleitem;
    int selenum;
    private AdView adView;
    private FrameLayout adContainerView;

    MyMedia m = new MyMedia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_west_drawerleft);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //ボタンの画像読み込み
        new btnload().refresh();

        m.onCreate(this, R.raw.bgm);

        adContainerView = findViewById(R.id.ad_view_container);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.adaptive_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();
    }

    private void loadBanner() {
        // Create an ad request. Check your logcat output for the hashed device ID
        // to get test ads on a physical device, e.g.,
        // "Use AdRequest.Builder.addTestDevice("ABCDE0123") to get test ads on this
        // device."
        AdRequest adRequest = new AdRequest.Builder().build();

        AdSize adSize = getAdSize();
        // Step 4 - Set the adaptive ad size on the ad view.
        adView.setAdSize(adSize);

        // Step 5 - Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);}

    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        m.onSe1();

    }


    public void onWest(View view) {
        Intent intent = new Intent(this, West.class);
        startActivity(intent);
        finish();

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        m.onSe2();

    }


    public boolean onTouchEvent(MotionEvent motionEvent) {


        //タップしたとき
        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);
        int envcount = lib.getInt("west_drawerleft", 0);
        SharedPreferences.Editor editor = lib.edit();

        ImageView backimage = ((ImageView) findViewById(R.id.backimage));

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                switch (envcount) {

                    case 0:
                        //ガチャガチャ効果音
                        m.onSe7();
                        break;

                    case 1:
                        m.onSe12();
                        //アイテムを取っていない
                        //アイテム有の画像
                        backimage.setImageResource(R.drawable.south_rockerrighton);
                        editor.putInt("west_drawerleft", 2).apply();
                        break;

                    case 2:
                        //アイテムをタッチ
                        if (0 < xplace && 0 < yplace) {
                            AlertDialog.Builder siyaku = new AlertDialog.Builder(this);
                            siyaku.setMessage("金庫の鍵")
                                    .setPositiveButton("OK", null).show();

                            //アイテムなしの画像に
                            backimage.setImageResource(R.drawable.south_rockerrightoff);

                            //アイテム欄に追加と背景変更の保存
                            int itemboxnum = lib.getInt("itemboxnum", 0);
                            itemboxnum++;
                            editor.putInt("itemboxnum", itemboxnum).apply();
                            editor.putInt("itembox" + itemboxnum, R.drawable.item_safekey).apply();
                            editor.putInt("west_drawerleft", 3).apply();

                            m.onSe3();

                            //ボタンの画像読み込み
                            new btnload().refresh();
                        }
                        break;

                    case 3:
                        m.onSe12();
                        //アイテムなしの画像
                        backimage.setImageResource(R.drawable.south_rockerrightoff);
                        break;
                }
                break;
        }
        return false;
    }


    public void onitem1(View view) {
        new itemsele().itemselefun(view, R.id.itembutton1, "itembox1", 1);
    }

    public void onitem2(View view) {
        new itemsele().itemselefun(view, R.id.itembutton2, "itembox2", 2);
    }

    public void onitem3(View view) {
        new itemsele().itemselefun(view, R.id.itembutton3, "itembox3", 3);
    }

    public void onitem4(View view) {
        new itemsele().itemselefun(view, R.id.itembutton4, "itembox4", 4);
    }

    public void onitem5(View view) {
        new itemsele().itemselefun(view, R.id.itembutton5, "itembox5", 5);
    }

    public void onitem6(View view) {
        new itemsele().itemselefun(view, R.id.itembutton6, "itembox6", 6);
    }

    public void onitem7(View view) {
        new itemsele().itemselefun(view, R.id.itembutton7, "itembox7", 7);
    }

    public void onitem8(View view) {
        new itemsele().itemselefun(view, R.id.itembutton8, "itembox8", 8);
    }

    public void onitem9(View view) {
        new itemsele().itemselefun(view, R.id.itembutton9, "itembox9", 9);
    }

    public void onitem10(View view) {
        new itemsele().itemselefun(view, R.id.itembutton10, "itembox10", 10);
    }

    public void onitem11(View view) {
        new itemsele().itemselefun(view, R.id.itembutton11, "itembox11", 11);
    }

    public void onitem12(View view) {
        new itemsele().itemselefun(view, R.id.itembutton12, "itembox12", 12);
    }


    class itemsele {
        public void itemselefun(View view, int seleId, String selebox, int slnum) {

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