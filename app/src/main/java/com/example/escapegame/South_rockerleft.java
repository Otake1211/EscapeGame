package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class South_rockerleft extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int touchcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_rockerleft);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
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

    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき

                ImageView backimage = ((ImageView) findViewById(R.id.backimage));
                if (touchcount == 0) {
                    // 開く操作
                    if (true) {
                        //アイテムある時の画像
                        backimage.setImageResource(R.drawable.south_rockerlefton);
                    } else {
                        //アイテムない時の画像
                        backimage.setImageResource(R.drawable.south_rockerleftoff);
                    }
                    touchcount = 2;
                } else {
                    //開いた後の操作
                    if (850 < xplace && xplace < 940 && 540 < yplace && yplace < 646) {
                        //アイテムとった判定
                    }
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
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem2(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton2);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem3(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton3);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem4(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton4);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem5(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton5);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem6(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton6);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem7(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton7);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem8(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton8);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem9(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton9);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem10(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton10);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem11(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton11);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    public void onitem12(View view) {

        //他のボタンを使えるようにする
        new otherable().reable(view);

        //このボタンを使えないようにする
        ImageButton imageButton = findViewById(R.id.itembutton12);
        imageButton.setEnabled(false);
        imageButton.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

        //選択しているアイテムを変更

    }

    class otherable {

        public void reable(View view) {
            ImageButton imageButton1 = findViewById(R.id.itembutton1);
            imageButton1.setEnabled(true);
            imageButton1.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton2 = findViewById(R.id.itembutton1);
            imageButton2.setEnabled(true);
            imageButton2.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton3 = findViewById(R.id.itembutton1);
            imageButton3.setEnabled(true);
            imageButton3.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton4 = findViewById(R.id.itembutton1);
            imageButton4.setEnabled(true);
            imageButton4.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton5 = findViewById(R.id.itembutton1);
            imageButton5.setEnabled(true);
            imageButton5.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton6 = findViewById(R.id.itembutton1);
            imageButton6.setEnabled(true);
            imageButton6.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton7 = findViewById(R.id.itembutton1);
            imageButton7.setEnabled(true);
            imageButton7.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton8 = findViewById(R.id.itembutton1);
            imageButton8.setEnabled(true);
            imageButton8.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton9 = findViewById(R.id.itembutton1);
            imageButton9.setEnabled(true);
            imageButton9.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton10 = findViewById(R.id.itembutton1);
            imageButton10.setEnabled(true);
            imageButton10.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton11 = findViewById(R.id.itembutton1);
            imageButton11.setEnabled(true);
            imageButton11.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);

            ImageButton imageButton12 = findViewById(R.id.itembutton1);
            imageButton12.setEnabled(true);
            imageButton12.setColorFilter(0x88888888, PorterDuff.Mode.SRC_ATOP);
        }
    }

}