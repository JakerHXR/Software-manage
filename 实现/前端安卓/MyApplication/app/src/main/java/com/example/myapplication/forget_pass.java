package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class forget_pass extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        ImageButton back=findViewById(R.id.back);
        back.setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setClass(this, log_frm.class);
            startActivity(intent);
        });
    }

}
