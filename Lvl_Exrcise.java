package com.nbb.aaa.chess_tacticts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lvl_Exrcise extends AppCompatActivity implements View.OnClickListener {

    Button easy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl__exrcise);
        easy = findViewById(R.id.btneasy);
        easy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == easy)
        {
            Intent intent = new Intent(this,chess_build.class);
            startActivity(intent);
        }

    }
}
