package com.inossem.bannerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnYouth, btnBGA , btnUltra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnYouth = findViewById(R.id.btn_youth_banner);
        btnBGA = findViewById(R.id.btn_BGA_banner);
        btnUltra = findViewById(R.id.btn_Ultra);

        btnBGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BGA_Activity.class);
                startActivity(intent);
            }
        });

        btnYouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YouthActivity.class);
                startActivity(intent);
            }
        });

        btnUltra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UltraviewpagerActivity.class);
                startActivity(intent);
            }
        });



    }
}
