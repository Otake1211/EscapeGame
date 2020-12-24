package com.example.escapegame;

import androidx.appcompat.app.AppCompatActivity;

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
                @Override
                public void onAnimationStart(Animation animation) {
                    //    アニメーションの開始時
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    //    アニメーションの繰り返し時
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    //    アニメーションの終了時
                    finish(); // スケジュールされるだけ
                }
            };
}