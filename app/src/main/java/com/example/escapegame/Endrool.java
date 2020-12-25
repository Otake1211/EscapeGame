package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Endrool extends AppCompatActivity {

    private TextView textView;
    private Animation animationEndrool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endrool);

        animationEndrool = AnimationUtils.loadAnimation(this, R.anim.endrool);
        animationEndrool.setAnimationListener(animationListener_endrool);

        textView = (TextView) this.findViewById(R.id.textView);
        textView.startAnimation(animationEndrool);
    }

    ///    アニメーションリスナの登録
    private Animation.AnimationListener animationListener_endrool =
            new Animation.AnimationListener() {

                @Override//アニメーションの開始時
                public void onAnimationStart(Animation animation) {
                }

                @Override//アニメーションの繰り返し時
                public void onAnimationRepeat(Animation animation) {
                }

                @Override//アニメーションの終了時
                public void onAnimationEnd(Animation animation) {

                    Intent intent = new Intent(Endrool.this, MainActivity.class);
                    startActivity(intent);

                    //アクティビティ遷移フェードイン
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                    finish();
                }
            };
}