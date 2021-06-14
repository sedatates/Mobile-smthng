package com.sedatates.erenyeager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        ArrayList <String> landmarkNames = new ArrayList<>();
        landmarkNames.add("pisa");
        landmarkNames.add("colosseo");
        landmarkNames.add("london bridge");
        landmarkNames.add("eiffel");

        ArrayList <String> countryNames = new ArrayList<>();
        countryNames.add("italy");
        countryNames.add("italy");
        countryNames.add("england");
        countryNames.add("france");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap colosseo = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colosseo);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);

        ArrayList <Bitmap> landmarkImages = new ArrayList<>();

        landmarkImages.add(pisa);
        landmarkImages.add(colosseo);
        landmarkImages.add(londonBridge);
        landmarkImages.add(eiffel);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent (getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",countryNames.get(i));
                intent.putExtra("lane",landmarkNames.get(i));
                //intent.putExtra("img",landmarkImages.get(i));

                startActivity(intent);

            }
        });
    }
}