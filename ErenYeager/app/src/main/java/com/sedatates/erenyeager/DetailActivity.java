package com.sedatates.erenyeager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView landmarkTextName = findViewById(R.id.landmarkNameTExt);
        TextView countryTextName = findViewById(R.id.countryNameText);

        Intent intent = getIntent();

        String countryText = intent.getStringExtra("name");
        String landText = intent.getStringExtra("lane");
        countryTextName.setText(countryText);
        landmarkTextName.setText(landText);

    }



}