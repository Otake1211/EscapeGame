package com.example.escapegame;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;

public class MyMedia {

    MediaPlayer mediaPlayer;
    SoundPool soundPool;

    int se1;
    int se2;
    int se3;
    int se4;
    int se5;
    int se6;
    int se7;
    int se8;
    int se9;
    int se10;
    int se11;
    int se12;
    int se13;
    int se14;
    int se15;


    public void onCreate(Context context, int id) {
        mediaPlayer = MediaPlayer.create(context, id);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1f, 1f);

        //効果音再生準備
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(5)
                    .build();
        }

        se1 = soundPool.load(context, R.raw.decision33, 1);
        se2 = soundPool.load(context, R.raw.foot, 1);
        se3 = soundPool.load(context, R.raw.decision4, 1);
        se4 = soundPool.load(context, R.raw.closeddoor, 1);
        se5 = soundPool.load(context, R.raw.enter, 1);
        se6 = soundPool.load(context, R.raw.key2, 1);
        se7 = soundPool.load(context, R.raw.closeddrawer, 1);
        se8 = soundPool.load(context, R.raw.rocker, 1);
        se9 = soundPool.load(context, R.raw.key, 1);
        se10 = soundPool.load(context, R.raw.tin, 1);
        se11 = soundPool.load(context, R.raw.fit, 1);
        se12 = soundPool.load(context, R.raw.drawer, 1);
        se13 = soundPool.load(context, R.raw.slidedoor, 1);
        se14 = soundPool.load(context, R.raw.decision31, 1);
        se15 = soundPool.load(context, R.raw.water, 1);


    }

    public void onSe1() {
        soundPool.play(se1, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe2() {
        soundPool.play(se2, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe3() {
        soundPool.play(se3, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe4() {
        soundPool.play(se4, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe5() {
        soundPool.play(se5, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe6() {
        soundPool.play(se6, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe7() {
        soundPool.play(se7, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe8() {
        soundPool.play(se8, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe9() {
        soundPool.play(se9, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe10() {
        soundPool.play(se10, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe11() {
        soundPool.play(se11, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe12() {
        soundPool.play(se12, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe13() {
        soundPool.play(se13, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe14() {
        soundPool.play(se14, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onSe15() {
        soundPool.play(se15, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void onResume() {
        mediaPlayer.start();
    }


    public void onPause() {
        mediaPlayer.pause();
    }


    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

}
