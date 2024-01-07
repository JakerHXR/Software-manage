package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class log_frm extends AppCompatActivity {
    public static String user_name;

    public static String user_pwd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_frm);
        log();
        rigist();
        forget_pass();
        user_name="test_user";
        user_pwd="12345";
        getSupportActionBar().hide();
    }
    private void log(){
        Button log_button= findViewById(R.id.login_button);
        log_button.setOnClickListener((view -> {
            Intent intent=new Intent();
           // intent.setClass(this, MainActivity.class);
            intent.setClass(this, admin_main.class);
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
        TextView forget=findViewById(R.id.forget_password_txt);
        forget.setOnClickListener((view -> {
            Intent intent=new Intent();
            intent.setClass(this, forget_pass.class);
            startActivity(intent);
        }));
    }


}
