package com.example.escapegame;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;




class loadpack extends AppCompatActivity{

    public void loadbtn() {

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

    public void reable() {

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