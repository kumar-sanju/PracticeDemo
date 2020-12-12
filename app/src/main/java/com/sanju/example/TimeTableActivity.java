package com.sanju.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class TimeTableActivity extends AppCompatActivity {

    ListView timeTableListview;

    public void generateTimeTable(int timetable){
//        int timetable = 10;
        ArrayList<String> timetableContent = new ArrayList<String>();

        for (int i=1; i<=10; i++){
            timetableContent.add(Integer.toString(i * timetable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timetableContent);
        timeTableListview.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        final SeekBar timeTableSeekbar = (SeekBar)findViewById(R.id.timeTableSeekbar);
        timeTableListview = (ListView)findViewById(R.id.timeTableListview);

        timeTableSeekbar.setMax(20);
        timeTableSeekbar.setProgress(10);
        timeTableSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                if(progress < min){
                    timesTable = min;
//                    timeTableSeekbar.setProgress(min);
                }else {
                    timesTable = progress;
                }
//                Log.i("Seekbar value", Integer.toString(timesTable));
                generateTimeTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimeTable(10);
    }
}