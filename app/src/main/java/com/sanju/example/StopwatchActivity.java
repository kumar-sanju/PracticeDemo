package com.sanju.example;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView timerTextview;
    Boolean CounterIsActive = false;
    Button button;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextview.setText("0:30");
        seekBar.setProgress(30);
        countDownTimer.cancel();
        button.setText("Go");
        seekBar.setEnabled(true);
        CounterIsActive = false;
    }

    public void updateTimer(int secondsLeft){
        int minutes = (int)secondsLeft/60;
        int seconds = secondsLeft - minutes * 60;
        String secondString = Integer.toString(seconds);
        if(seconds <= 9) {
            secondString = "0" + secondString;
        }
        timerTextview.setText(Integer.toString(minutes)+":"+secondString);
    }

    public void controlTimer(View view){

        if(CounterIsActive ==false){
            CounterIsActive = true;
            seekBar.setEnabled(false);
            button.setText("Stop");
            Log.i("Button pressed","Pressed");
            countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000 + 100,1000){

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    resetTimer();
                    timerTextview.setText("0:00");
                    Log.i("Finished","timer done");
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                    mplayer.start();
                }
            }.start();
        } else {
            resetTimer();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        timerTextview = (TextView)findViewById(R.id.timerTextview);
        button = (Button)findViewById(R.id.button);
        seekBar = (SeekBar)findViewById(R.id.timerSeekbar);
        seekBar.setMax(600);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}