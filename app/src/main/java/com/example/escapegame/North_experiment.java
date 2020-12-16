package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

public class North_experiment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_experiment);

        //ボタンの画像読み込み
        new btnload().refresh();
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