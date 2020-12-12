package com.sanju.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView myListview = (ListView)findViewById(R.id.myListview);
        ListView friendListview = (ListView)findViewById(R.id.friendListview);

        final ArrayList<String> myFamily = new ArrayList<String>();

        myFamily.add("Hello");
        myFamily.add("Hi");
        myFamily.add("What");
        myFamily.add("Who");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);
        myListview.setAdapter(arrayAdapter);

        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                parent.setVisibility(View.GONE);
                Log.i("Person tapped",myFamily.get(position));

            }
        });

        final ArrayList<String> frndListview = new ArrayList<String>(asList("Note","Book","xyz","abc"));

//        frndListview.add("Note");
//        frndListview.add("Book");
//        frndListview.add("xyz");
//        frndListview.add("abc");

        ArrayAdapter<String> array1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,frndListview);
        friendListview.setAdapter(array1);

        friendListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Hello " + frndListview.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }
}