package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextToVoiceActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_voice);

        textView = findViewById(R.id.text);
        button = findViewById(R.id.plaBtn);


        textToSpeech = new TextToSpeech(TextToVoiceActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textView.getText().toString();
                textToSpeech.speak(text , TextToSpeech.QUEUE_FLUSH , null, null);


            }
        });

    }
}