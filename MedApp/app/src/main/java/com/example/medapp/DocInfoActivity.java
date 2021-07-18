package com.example.medapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DocInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_info);

        ImageView tye = findViewById(R.id.three_bars);

        tye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(DocInfoActivity.this, "TITLE", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DocInfoActivity.this, TitleActivity.class);
                startActivity(intent);

            }
        });
    }
}