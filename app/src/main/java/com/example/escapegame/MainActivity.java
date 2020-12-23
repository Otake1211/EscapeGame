package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Point;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;


public class MainActivity extends AppCompatActivity {

    int screenWidth;
    int screenHeight;

    MyMedia m = new MyMedia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ここで1秒間スリープし、スプラッシュを表示させたままにする。
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        // スプラッシュthemeを通常themeに変更する
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        m.onCreate(this,R.raw.mainbgm);
    }

    @Override
    protected void onResume() {
        super.onResume();

        m.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        m.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        m.onDestroy();
    }

    public void onSetting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        m.onSe1();
    }


    public void onNorth(View view) {
        Intent intent = new Intent(this, North.class);
        startActivity(intent);

        //アクティビティ遷移フェードイン
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        m.onSe1();

    }


    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("(" + xplace + "," + yplace + ")")
                        .setPositiveButton("OK", null).show();
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