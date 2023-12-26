package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class log_frm extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_frm);
        log();
        rigist();
    }
    private void log(){
        Button log_button= findViewById(R.id.login_button);
        log_button.setOnClickListener((view -> {
            Intent intent=new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        }));
    }
    private void rigist(){
        Button rig_button= findViewById(R.id.regist_button);
        rig_button.setOnClickListener((view -> {
            Intent intent=new Intent();
            intent.setClass(this, user_rigist.class);
            startActivity(intent);
        }));
    }
    private void forget_pass(){

    }

}
