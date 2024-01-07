package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class admin_manager_dialog extends Dialog {
    Activity context;
    String admin_id,admin_pwd;
    admin_manager.MyAdapter adapter;
    EditText admin_pwdtxt,admin_idtxt;
    public interface refresh{
        public void refresh();
    }
    refresh mRefresh;
    public admin_manager_dialog(Activity context,String admin_id,String admin_pwd,admin_manager.MyAdapter adapter){
        super(context);
        mRefresh=(refresh) context;
        this.context=context;
        this.admin_id=admin_id;
        this.admin_pwd=admin_pwd;
        this.adapter=adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.change_admin_dialog);
        Window dialogWindow = this.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(p);
        admin_idtxt=findViewById(R.id.text_name);
        admin_pwdtxt=findViewById(R.id.text_mobile);
        admin_idtxt.setText(admin_id);
        admin_pwdtxt.setText(admin_pwd);
        this.setCancelable(true);
        Button button=findViewById(R.id.btn_save_pop);
        button.setOnClickListener(view->{
            if (admin_id==null){
                    Thread thread=new Thread(add_admin);
                    thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Thread  thread=new Thread(change_admin);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mRefresh.refresh();
            dismiss();
        });
    }

    Runnable change_admin=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONObject update_admin=new JSONObject();
            try{
                update_admin.put("admin_name",admin_id);
                update_admin.put("admin_pwd",admin_pwdtxt.getText().toString());
                update_admin.put("creat_data",null);
                MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
                RequestBody requestBody= RequestBody.Companion.create(update_admin.toString(),mediaType);
                final Request request=new Request.Builder().url("http://192.168.137.1:8080/admin/update").put(requestBody).build();
                Call call=okHttpClient.newCall(request);
                call.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };
    Runnable add_admin=new Runnable() {
        @Override
        public void run() {
            OkHttpClient okHttpClient=new OkHttpClient();
            JSONObject update_admin=new JSONObject();
            try{
                update_admin.put("admin_name",admin_idtxt.getText().toString());
                update_admin.put("admin_pwd",admin_pwdtxt.getText().toString());
                update_admin.put("creat_data",null);
                MediaType mediaType=MediaType.Companion.parse("application/json;charset=utf-8");
                RequestBody requestBody= RequestBody.Companion.create(update_admin.toString(),mediaType);
                final Request request=new Request.Builder().url("http://192.168.137.1:8080/admin/sign/in/up").post(requestBody).build();
                Call call=okHttpClient.newCall(request);
                call.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };



}
