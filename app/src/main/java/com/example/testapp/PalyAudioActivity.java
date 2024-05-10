package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class PalyAudioActivity extends AppCompatActivity {

    Button offlineAudioBtn , onlineAudioBtn ;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paly_audio);


        offlineAudioBtn = findViewById(R.id.offlineAudioBtn);
        onlineAudioBtn = findViewById(R.id.onlineAudioBtn);


        offlineAudioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer !=null) mediaPlayer.release();

                mediaPlayer = MediaPlayer.create(PalyAudioActivity.this , R.raw.cat_audio);
                mediaPlayer.start();
            }
        });


        onlineAudioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer !=null) mediaPlayer.release();


                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("https://appslabbd.buzz/test/cat_audio.mp3");
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });



    }
}