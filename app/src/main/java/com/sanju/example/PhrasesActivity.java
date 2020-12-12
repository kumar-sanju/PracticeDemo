package com.sanju.example;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases_activity);
    }

    public void buttonTapped(View view){
        int id = view.getId();
        String name = "";
        name = view.getResources().getResourceEntryName(id);

        int resourceId = getResources().getIdentifier(name,"raw","com.sanju.example");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, resourceId);
        mediaPlayer.start();

        Log.i("Button tapped",name);
    }

}