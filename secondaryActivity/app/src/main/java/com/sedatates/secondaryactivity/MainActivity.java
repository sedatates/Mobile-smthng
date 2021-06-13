package com.sedatates.secondaryactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.net.ssl.HandshakeCompletedEvent;

public class MainActivity extends AppCompatActivity {

    String username;
    EditText editText;
    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName3);
        username = "";
        textView = findViewById(R.id.textView3);
        number = 0;
        button = findViewById(R.id.buttonstart);
        button2 = findViewById(R.id.buttonstop);
        button2.setEnabled(false);
    }

    public void changeActivity(View view) {
        textView = findViewById(R.id.textView);
        username = editText.getText().toString();
        textView.setText(username);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("userInput", username);
        startActivity(intent);
    }

    public void start(View view) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time : " + number);
                number++;
                textView.setText("Time : " + number);
                handler.postDelayed(runnable,50);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);
        button2.setEnabled(true);
    }

    public void stop(View view) {
        button.setEnabled(true);
        button2.setEnabled(false);
        handler.removeCallbacks(runnable);
        textView.setText("Time : "+ number);
    }


}