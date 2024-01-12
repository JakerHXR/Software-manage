package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class log_frm extends AppCompatActivity {
    public static String user_name;
    private Handler handler;
    public static String user_pwd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_frm);
        log();
        rigist();
        forget_pass();
       // user_name="test_user";
      //  user_pwd="12345";
        getSupportActionBar().hide();
        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                if (msg.what==1) no_user();
            };
        };
    }
    Runnable log=new Runnable() {
        @Override
        public void run() {
            OkHttpClient client=new OkHttpClient();
            RequestBody body=new FormBody.Builder().add("id",user_name).add("pwd",user_pwd).build();
            final Request request=new Request.Builder().url("http://192.168.137.1:8080/signup").post(body).build();
            Call call=client.newCall(request);
            try {
                Response response=call.execute();
                String identify = response.body().string();
                if (identify.indexOf("1")>-1) admin();
                else if(identify.indexOf("2")>-1) user();
                else { handler.sendEmptyMessage(1);   }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };


    private void log(){
        Button log_button= findViewById(R.id.login_button);
        log_button.setOnClickListener((view -> {
            EditText name=findViewById(R.id.username);
            EditText pwd=findViewById(R.id.password);
            user_name=name.getText().toString();
            user_pwd=pwd.getText().toString();
            Thread thread=new Thread(log);
            thread.start();
            //Intent intent=new Intent();
           // intent.setClass(this, MainActivity.class);
          //  intent.setClass(this, admin_main.class);
          //  startActivity(intent);
        }));
    }
    private void admin(){
        Intent intent=new Intent();
        intent.setClass(this, admin_main.class);
        startActivity(intent);
    }
    private void no_user(){
        Log.e("1","in");
        new AlertDialog.Builder(log_frm.this).setMessage("账号或密码错误").show();
    }


    private void user(){
        Intent intent=new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
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
