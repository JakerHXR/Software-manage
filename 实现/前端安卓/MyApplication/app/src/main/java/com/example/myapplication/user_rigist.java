package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class user_rigist extends AppCompatActivity {
    String user_name;
    String user_pwd;
    String user_pwd_con;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_rigist);
        Button rig=findViewById(R.id.rigist);
        EditText user_name_edit=findViewById(R.id.username);
        EditText user_pwd_edit=findViewById(R.id.password);
        EditText user_pwd_con_edit=findViewById(R.id.new_password);

        rig.setOnClickListener(view -> {
            user_name=user_name_edit.getText().toString();
            user_pwd=user_pwd_edit.getText().toString();
            user_pwd_con=user_pwd_con_edit.getText().toString();

            if (!user_pwd.equals(user_pwd_con)) {

                AlertDialog dialog=new AlertDialog.Builder(user_rigist.this).setMessage("两次密码不一致").setPositiveButton("确认",null).create();
                dialog.show();
            }else {
                Thread ri=new Thread(rigist);
                ri.start();
                try {
                    ri.join();
                    AlertDialog dialog=new AlertDialog.Builder(user_rigist.this).setMessage("注册成功").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent();
                            intent.setClass(user_rigist.this,log_frm.class);
                            startActivity(intent);
                        }
                    }).create();
                    dialog.show();
                } catch (Exception e) {
                   e.printStackTrace();
                    AlertDialog dialog=new AlertDialog.Builder(user_rigist.this).setMessage("注册失败").setPositiveButton("确认",null).create();
                }
            }
        });
        findViewById(R.id.back).setOnClickListener(view -> {onBackPressed();});


    }
    Runnable rigist=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            RequestBody requestBody=new FormBody.Builder().add("user_name",user_name)
                    .add("user_pwd",user_pwd).build();
            final Request request=new Request.Builder().url("http://192.168.137.1:8080/userbase/sign/in/up").post(requestBody).build();
            Call call=okHttpClient.newCall(request);
            try {
                Response response=call.execute();
                response.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };
}
