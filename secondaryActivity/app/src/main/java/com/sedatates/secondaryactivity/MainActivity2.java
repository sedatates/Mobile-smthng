package com.sedatates.secondaryactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.editTextTextPersonName);

        Intent intent = getIntent();

        String userName = intent.getStringExtra("userInput");
        textView.setText(userName);
        
    }

    public void changeFirst (View view){
        Intent intent = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
}