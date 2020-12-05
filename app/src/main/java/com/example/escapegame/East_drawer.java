package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class East_drawer extends AppCompatActivity {

    int screenWidth;
    int screenHeight;
    int touchcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_east_drawer);
    }

    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void onEast(View view) {
        Intent intent = new Intent(this, East.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        int xplace = (int) (motionEvent.getX() * 1000 / screenWidth);
        int yplace = (int) (motionEvent.getY() * 2000 / screenHeight);

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: //タップしたとき


                if (touchcount == 0) {
                    // 開く操作
                    if (true) {
                        //アイテムある時の画像
                        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
                        backimage.setImageResource(R.drawable.east_draweron);
                    } else {
                        //アイテムない時の画像
                        ImageView backimage = ((ImageView) findViewById(R.id.backimage));
                        backimage.setImageResource(R.drawable.east_draweroff);
                    }
                    touchcount = 2;
                } else {
                    //開いた後の操作
                    if (850 < xplace && xplace < 940 && 540 < yplace && yplace < 646) {
                        AlertDialog.Builder west_shiryou = new AlertDialog.Builder(this);
                        west_shiryou.setMessage("アイテム")
                                .setPositiveButton("OK", null).show();//アイテムとった判定
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