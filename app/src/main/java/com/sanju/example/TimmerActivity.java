package com.sanju.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class TimmerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timmer);

        new CountDownTimer(10000,1000){
            public void onTick(long milisecondUntillDone){
                //counter is counting done every second
                Log.i("second left",String.valueOf(milisecondUntillDone / 1000));
            }
            public void onFinish(){
                //counter is finish faster 10 second
                Log.i("Done", "Countdown timer finished");
            }
        }.start();

//        final Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//
//                // inster code to be run every second
//
//                Log.i("Runneble has run", "a second must have passed...");
//
//                handler.postDelayed(this,1000);
//            }
//        };
//
//        handler.post(run);
    }
}