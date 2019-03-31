package com.example.administrator.ui;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button b1;

    private Button b2;

    private Button b3;

    private Button b4;

    private Intent i = new Intent();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);

        b2 = (Button) findViewById(R.id.b2);

        b3 = (Button) findViewById(R.id.b3);

        b4 = (Button) findViewById(R.id.b4);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                i.setClass(com.example.administrator.ui.MainActivity.this, listViewl.class);

                startActivity(i);

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                i.setClass(com.example.administrator.ui.MainActivity.this, alertDialog.class);

                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                i.setClass(com.example.administrator.ui.MainActivity.this, menu.class);
                startActivity(i);
            }

        });

        b4.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                i.setClass(com.example.administrator.ui.MainActivity.this, actionmode.class);
                startActivity(i);
            }
        });
    }
}

