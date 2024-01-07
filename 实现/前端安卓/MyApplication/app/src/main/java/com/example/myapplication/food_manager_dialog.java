package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.SearchView;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class food_manager_dialog extends Dialog {
    Activity context;
    String name;
    String tag;
    String no;
    EditText food_name,food_tag;
    food_manage.MyAdapter myAdapter;
    refresh re;
    public interface refresh{
        public void refresh();
    }
    public food_manager_dialog(Activity context, String food_name, String food_tag, String no, food_manage.MyAdapter myAdapter){
        super(context);
        this.context=context;
        name=food_name;
        tag=food_tag;
        this.no=no;
        this.myAdapter=myAdapter;
        re=(refresh) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.change_food_dialog);
        Window dialogWindow = this.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(p);
        this.setCancelable(true);
        Button save=findViewById(R.id.btn_save_pop);
        food_name=findViewById(R.id.text_name);
        food_tag=findViewById(R.id.text_info);
        food_name.setText(name);
        food_tag.setText(tag);
        save.setOnClickListener(view -> {
            if (name!=null) {
                Thread thread=new Thread(change);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {
                Thread thread=new Thread(add);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            re.refresh();
            dismiss();
        });


    }
    Runnable change=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONObject update_food=new JSONObject();
            try{
                update_food.put("menu_no",no);
                update_food.put("menu_name",food_name.getText().toString());
                update_food.put("admin_name",null);
                update_food.put("menu_feature",food_tag.getText().toString());
                MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
                RequestBody requestBody= RequestBody.Companion.create(update_food.toString(),mediaType);
                final Request request=new Request.Builder().url("http://192.168.137.1:8080/menufood/update").put(requestBody).build();
                Call call=okHttpClient.newCall(request);
                call.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };
    Runnable add=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONObject update_food=new JSONObject();
            try{
                update_food.put("menu_no",null);
                update_food.put("menu_name",food_name.getText().toString());
                update_food.put("admin_name",null);
                update_food.put("menu_feature",food_tag.getText().toString());
                MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
                RequestBody requestBody= RequestBody.Companion.create(update_food.toString(),mediaType);
                final Request request=new Request.Builder().url("http://192.168.137.1:8080/menufood/insert").put(requestBody).build();
                Call call=okHttpClient.newCall(request);
                call.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };




}
