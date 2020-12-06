package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

    String seleitem;

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
                SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);

                int envcount = lib.getInt("saferight", 0);

                ImageView backimage = ((ImageView) findViewById(R.id.backimage));
                if (envcount == 0) {
                    // 開く操作
                    if (seleitem == "item_siyakukey") {

                        //効果音
                    SharedPreferences.Editor editor = lib.edit();
                    editor.putInt("saferight", 1).apply();
                    }
                    else {
                        //効果音

                    }
                }

                if (envcount == 1) {
                    //アイテム有の画像
                    backimage.setImageResource(R.drawable.south_rockerrighton);
                    //効果音

                    if (0 < xplace && 0 < yplace){
                        AlertDialog.Builder siyaku = new AlertDialog.Builder(this);
                                 siyaku.setMessage("試薬")
                                .setPositiveButton("OK", null).show();
                        //アイテムなしの画像
                        backimage.setImageResource(R.drawable.south_rockerrightoff);
                        SharedPreferences.Editor editor = lib.edit();
                        editor.putInt("saferight", 2).apply();
                    }
                }

                if (envcount == 2){
                    //アイテムなしの画像
                    backimage.setImageResource(R.drawable.south_rockerrightoff);
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