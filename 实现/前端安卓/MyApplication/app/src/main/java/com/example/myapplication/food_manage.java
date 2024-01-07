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
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.food;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class food_manage extends AppCompatActivity implements food_manager_dialog.refresh{
    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter;
    List<food> mFood = new ArrayList<>();
    int nowPositon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_food_manage);
        mMyAdapter = new MyAdapter();
        mMyAdapter.setData(mFood);
        mRecyclerView = findViewById(R.id.food_recycleview);
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(food_manage.this);
        mRecyclerView.setLayoutManager(layoutManager);
        ImageButton back= findViewById(R.id.back);
        back.setOnClickListener(view -> {
            onBackPressed();
        });
        ImageButton add=findViewById(R.id.add_food);
        add.setOnClickListener(view -> {
            food_manager_dialog tst=new food_manager_dialog(food_manage.this,null,null,null,mMyAdapter);
            tst.show();
        });
       Thread food=new Thread(runnable);
       food.start();
        try {
            food.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SearchView searchView=findViewById(R.id.searchView2);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<food> sFood=new ArrayList<>();
                for (int i=0;i<mFood.size();i++)
                    if (mFood.get(i).food_name.indexOf(newText)>-1) sFood.add(mFood.get(i));
                mMyAdapter.setData(sFood);
                mMyAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    @Override
    public void refresh() {
        mFood.clear();
        Thread thread=new Thread(runnable);
        thread.start();
        try {
            thread.join();
            Log.e("1",mFood.get(0).food_name);
        }catch (Exception e){
            e.printStackTrace();
        }
        mMyAdapter.setData(mFood);
        mMyAdapter.notifyDataSetChanged();
    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            final Request request=new Request.Builder().url("http://192.168.137.1:8080/menufood/getall").get().build();
            Call call=okHttpClient.newCall(request);
            JSONArray foodlist=null;
            try {
                Response response=call.execute();
                String body=response.body().string();
                foodlist= new JSONArray(body);
                response.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            for (int i=1;i<=foodlist.length();i++)
            {
                food mf=new food();
                try {
                    JSONObject foodinfo=foodlist.getJSONObject(i-1);
                    mf.food_name=foodinfo.getString("menu_name");
                    mf.food_no=foodinfo.getString("menu_no");
                    //Log.e("1",mf.food_name);
                    mf.tag.add(foodinfo.getString("menu_feature"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                //  mf.food_name="1"+i;
                mf.tag.add("10"+i);
                mf.tag.add("100"+i);
                mFood.add(mf);
            }
        }
    };
    Runnable delete=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONObject food=new JSONObject();
            try{
                food.put("menu_no",food_manage.this.mFood.get(nowPositon).food_no);
                food.put("menu_name",food_manage.this.mFood.get(nowPositon).food_name);
                food.put("admin_name",null);
                food.put("menu_feature",food_manage.this.mFood.get(nowPositon).tag.get(0));
                MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
                RequestBody requestBody= RequestBody.Companion.create(food.toString(),mediaType);
                final Request request=new Request.Builder().url("http://192.168.137.1:8080/menufood/delete").delete(requestBody).build();
                Call call=okHttpClient.newCall(request);
                call.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

        List<food> mFood;
        void setData(List<food> mFood){
            this.mFood=mFood;
        }
        @NonNull
        @Override
        public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(food_manage.this, R.layout.food_manager_item, null);
            MyViewHoder myViewHoder = new MyViewHoder(view);
            return myViewHoder;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
            food thisfood = mFood.get(position);
            holder.food_name.setText(thisfood.food_name);
            Button change = holder.itemView.findViewById(R.id.main_food_change);
            change.setOnClickListener(view -> {
                food_manager_dialog tst=new food_manager_dialog(food_manage.this,thisfood.food_name,thisfood.tag.get(0),thisfood.food_no,mMyAdapter);
                tst.show();
                Log.e("1","onCreat:you click");
            });
            ImageButton del=holder.itemView.findViewById(R.id.delete);
            del.setOnClickListener(view -> {
                nowPositon= holder.getAdapterPosition();
                Log.e("1",""+holder.getAdapterPosition());
                Log.e("1",""+nowPositon);
                Thread thread=new Thread(delete);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                refresh();
            });
        }

        @Override
        public int getItemCount() {
            return mFood.size();
        }
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        TextView food_name;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            food_name = itemView.findViewById(R.id.main_food_name);


        }
    }
}
