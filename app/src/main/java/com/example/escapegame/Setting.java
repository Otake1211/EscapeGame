package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

    }

    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // ファイルの準備
        SharedPreferences lib = getSharedPreferences("game_data", MODE_PRIVATE);


        //データ削除
        SharedPreferences.Editor editor = lib.edit();

        editor.remove("west").apply();
        editor.remove("west_aquarium").apply();
        editor.remove("west_drawerleft").apply();
        editor.remove("west_drawerright").apply();
        editor.remove("west_flask").apply();
        editor.remove("west_scale").apply();

        editor.remove("north").apply();
        editor.remove("north_preparationroom").apply();

        editor.remove("south").apply();
        editor.remove("south_saferight").apply();
        editor.remove("south_rockerright").apply();
        editor.remove("south_rockerleft").apply();
        editor.remove("south_safeleft").apply();

        editor.remove("east").apply();
        editor.remove("east_box").apply();
        editor.remove("east_exit").apply();
        editor.remove("east_drawer").apply();
        editor.remove("east_rbox").apply();
        editor.remove("east_bbox").apply();
        editor.remove("east_wave").apply();

        editor.remove("itemboxnum").apply();
        editor.remove("itembox1").apply();
        editor.remove("itembox2").apply();
        editor.remove("itembox3").apply();
        editor.remove("itembox4").apply();
        editor.remove("itembox5").apply();
        editor.remove("itembox6").apply();
        editor.remove("itembox7").apply();
        editor.remove("itembox8").apply();
        editor.remove("itembox9").apply();
        editor.remove("itembox10").apply();
        editor.remove("itembox11").apply();
        editor.remove("itembox12").apply();

    }


}