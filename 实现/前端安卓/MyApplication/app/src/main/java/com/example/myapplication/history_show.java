package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.food;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class history_show extends AppCompatActivity {
    ArrayList<food> mFood=new ArrayList<>();
    RecyclerView mRecyclerView;
    history_show.MyAdapter mMyAdapter ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_search);
        ImageButton back=findViewById(R.id.back);
        back.setOnClickListener((view -> {
                    onBackPressed();
                })
        );
        fillfood();
        mMyAdapter = new history_show.MyAdapter();
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(history_show.this);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    //填充food
    void fillfood(){
        Thread his= new Thread(history);
        his.start();
        try {
            his.join();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //HTTP请求
    Runnable history=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONObject user=new JSONObject();

            JSONArray foodlist=null;
            try {
                user.put("user_name",log_frm.user_name);
                user.put("user_pwd",log_frm.user_pwd);
                MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
                RequestBody requestBody= RequestBody.Companion.create(user.toString(),mediaType);
                final Request request=new Request.Builder().url("http://192.168.137.1:8080/log/getall").post(requestBody).build();
                Call call=okHttpClient.newCall(request);
                Response response=call.execute();
                String body=response.body().string();
                foodlist= new JSONArray(body);
                response.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            for (int i=0;i<foodlist.length();i++)
            {
                food mf=new food();
                try {
                    JSONObject foodinfo=foodlist.getJSONObject(i);
                    mf.food_name=foodinfo.getString("select_name");
                    mf.food_no=foodinfo.getString("select_no");
                    //Log.e("1",mf.food_name);
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


    //循环视图
    class MyAdapter extends RecyclerView.Adapter<history_show.MyViewHoder> {

        @NonNull
        @Override
        public history_show.MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(history_show.this, R.layout.food_list_item, null);
            history_show.MyViewHoder myViewHoder = new history_show.MyViewHoder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull history_show.MyViewHoder holder, int position) {
            food thisfood = mFood.get(position);
            // Log.e("wrng","onCreate:第"+position);
            holder.food_name.setText(thisfood.food_name);
            holder.food_tag1.setVisibility(View.INVISIBLE);
            holder.food_tag2.setVisibility(View.INVISIBLE);
        }

        @Override
        public int getItemCount() {
            return mFood.size();
        }
    }
    class MyViewHoder extends RecyclerView.ViewHolder {
        TextView food_name;
        TextView food_tag1;
        TextView food_tag2;
        int position;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            food_name = itemView.findViewById(R.id.main_food_name);
            food_tag1 = itemView.findViewById(R.id.main_food_tag1);
            food_tag2=itemView.findViewById(R.id.main_food_tag2);
            Log.e("1","wrng");
            itemView.setOnClickListener(view -> {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("menu_name",mFood.get(getAdapterPosition()).food_name);
                bundle.putStringArrayList("menu_tag",mFood.get(getAdapterPosition()).tag);
                intent.putExtras(bundle);
                intent.setClass(history_show.this, food_intro.class);
                startActivity(intent);
            });
        }
    }



}
