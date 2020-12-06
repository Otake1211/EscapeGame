package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class South_saferight extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int touchcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_saferight);

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
                        backimage.setImageResource(R.drawable.south_rockerrighton);
                    } else {
                        //アイテムない時の画像
                        backimage.setImageResource(R.drawable.south_rockerrightoff);
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
}