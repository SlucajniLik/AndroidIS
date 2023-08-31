package com.example.ispitt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Drawable extends AppCompatActivity {
    Draww draww;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_drawable);
        Intent intent = getIntent();
        int num=intent.getIntExtra("message_key",0);
        draww = new Draww(this);
draww.setDuzina(num);
draww.setBoja("yellow");
        setContentView(draww);

    }
}