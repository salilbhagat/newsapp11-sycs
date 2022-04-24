package com.example.newsapp11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class live_channels extends AppCompatActivity {
    private Button Button1, Button2,Button3,Button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_channels);

        Button1 = (Button) findViewById(R.id.btn1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_ddnews();
            }
        });
        Button2 = (Button) findViewById(R.id.btn2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_republic();
            }
        });
        Button3 = (Button) findViewById(R.id.btn3);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_ndtv();
            }
        });
        Button4 = (Button) findViewById(R.id.btn4);
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_ecot();
            }
        });
    }
    public void openactivity_ddnews(){
        Intent intent = new Intent(this, ddnews.class);
        startActivity(intent);
    }
    public void openactivity_republic(){
        Intent intent = new Intent(this, republic.class);
        startActivity(intent);
    }
    public void openactivity_ndtv(){
        Intent intent = new Intent(this, ndtv.class);
        startActivity(intent);
    }
    public void openactivity_ecot(){
        Intent intent = new Intent(this, ecot.class);
        startActivity(intent);
    }
}