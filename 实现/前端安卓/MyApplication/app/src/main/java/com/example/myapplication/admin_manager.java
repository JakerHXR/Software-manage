package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.admin;
import com.example.myapplication.model.food;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class admin_manager extends AppCompatActivity implements admin_manager_dialog.refresh{
    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter ;
    List<admin> mAdmin = new ArrayList<>();
    int nowPosition;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_manager);
        Thread admin_thr=new Thread(get_admin);
        admin_thr.start();
        try {
            admin_thr.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mRecyclerView=findViewById(R.id.admin_acc_recyclerview);
        mMyAdapter= new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(admin_manager.this);
        mRecyclerView.setLayoutManager(layoutManager);
        ImageButton add=findViewById(R.id.add_admin);
        add.setOnClickListener(view -> {
            admin_manager_dialog tst=new admin_manager_dialog(admin_manager.this,null,null,mMyAdapter);
            tst.show();
        });

        ImageButton back= findViewById(R.id.back);
        back.setOnClickListener(view -> {
            onBackPressed();
        });


    }
    @Override
    public void refresh(){
        mAdmin.clear();
        Thread thread=new Thread(get_admin);
        thread.start();
        try {
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        mMyAdapter.notifyDataSetChanged();
    }

    Runnable get_admin=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONArray adminlist=null;
            final Request request=new Request.Builder().url("http://192.168.137.1:8080/admin/getall").get().build();
            Call call=okHttpClient.newCall(request);
            try {
                Response response=call.execute();
                String body=response.body().string();
                adminlist= new JSONArray(body);
                response.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            for (int i=0;i<adminlist.length();i++)
            {
                admin mf=new admin();
                try {
                    JSONObject admin=adminlist.getJSONObject(i);
                    mf.admin_id=admin.getString("admin_name");
                    mf.admin_pass=admin.getString("admin_pwd");
                    //Log.e("1",mf.food_name);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //  mf.food_name="1"+i;
                mAdmin.add(mf);
            }
        }
    };
    Runnable delete=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONObject admin=new JSONObject();
            try{
                admin.put("admin_name",mAdmin.get(nowPosition).admin_id);
                admin.put("admin_pwd",mAdmin.get(nowPosition).admin_pass);
                admin.put("create_date",null);
                MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
                RequestBody requestBody= RequestBody.Companion.create(admin.toString(),mediaType);
                final Request request=new Request.Builder().url("http://192.168.137.1:8080/admin/delete").delete(requestBody).build();
                Call call=okHttpClient.newCall(request);
                Log.e("123",call.execute().body().string());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    class MyAdapter extends RecyclerView.Adapter<admin_manager.MyViewHoder> {

        @NonNull
        @Override
        public admin_manager.MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(admin_manager.this, R.layout.admin_item, null);
            admin_manager.MyViewHoder myViewHoder = new admin_manager.MyViewHoder(view);

            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull admin_manager.MyViewHoder holder, int position) {
            admin thisadmin = mAdmin.get(position);
            Button change = holder.itemView.findViewById(R.id.chang_adminid);
            change.setOnClickListener(view -> {
                admin_manager_dialog tst=new admin_manager_dialog(admin_manager.this,thisadmin.admin_id,thisadmin.admin_pass,MyAdapter.this);
                tst.show();
                Log.e("1","onCreat:you click");
            });
            Button del=holder.itemView.findViewById(R.id.delete_admin);
            del.setOnClickListener(view -> {
                nowPosition= holder.getAdapterPosition();
                Log.e("1",""+holder.getAdapterPosition());
                Log.e("1",""+nowPosition);
                Thread thread=new Thread(delete);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                refresh();
            });

            holder.admin_id.setText("管理员id"+thisadmin.admin_id);
            holder.admin_pass.setText("管理员密码"+thisadmin.admin_pass);
        }

        @Override
        public int getItemCount() {
            return mAdmin.size();
        }
    }
    class MyViewHoder extends RecyclerView.ViewHolder {
        TextView admin_id;
        TextView admin_pass;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            admin_id = itemView.findViewById(R.id.admin_user);
            admin_pass = itemView.findViewById(R.id.admin_pass);
        }
    }
}
