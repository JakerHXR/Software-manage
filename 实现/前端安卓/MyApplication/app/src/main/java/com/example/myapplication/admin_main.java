package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class admin_main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_main);
        ConstraintLayout admin_manager=findViewById(R.id.admin_manager);
        admin_manager.setOnClickListener(view -> {
            Intent intent=new Intent();
            intent.setClass(this, admin_manager.class);
            startActivity(intent);
        });

        ConstraintLayout food_manager=findViewById(R.id.admin_food_manager);
        food_manager.setOnClickListener(view -> {
            Intent intent=new Intent();
            intent.setClass(this, food_manage.class);
            startActivity(intent);
        });

        ConstraintLayout myset=findViewById(R.id.mySetting);
        myset.setOnClickListener(view -> {
           Intent intent=new Intent();
           intent.setClass(admin_main.this,log_frm.class);
           startActivity(intent);
        });


    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient();
            String json="{\"admin_name\":\"test\",\"admin_pwd\":\"112\",\"create_data\":\"null\"}";
            MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
            RequestBody requestBody=RequestBody.Companion.create(json,mediaType);
            //HttpUrl.Builder url=HttpUrl.parse("http://192.168.137.1:8080/admin/pwd").newBuilder().addQueryParameter("admin_name","test")
                   // .addQueryParameter("admin_pwd","111")
                    //.addQueryParameter("create_data",null);
            final Request request=new Request.Builder().url("http://192.168.137.1:8080/admin/pwd").post(requestBody).build();
            Call call=client.newCall(request);
            try {
                //Log.e("1","onCreate:"+url.build().toString());
                Response response=call.execute();
                String body=response.body().string();
                //JSONArray js=new JSONArray(body);
                Log.e("1","onCreate:"+body);
                response.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    };

}


