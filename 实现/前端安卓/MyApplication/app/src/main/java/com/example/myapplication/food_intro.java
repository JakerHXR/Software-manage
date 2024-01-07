package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class food_intro extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_intro);
        ImageButton imageButton=findViewById(R.id.back);
        Bundle bundle=this.getIntent().getExtras();
        TextView foodintro=findViewById(R.id.foodIntroduce);
        ArrayList<String> tags=bundle.getStringArrayList("menu_tag");
        String intro="菜品名称："+bundle.getString("menu_name")+"\n"+"菜品tag：";
        for (String tag:tags){
            intro+=tag+",";
        }
        intro+="\n";
        foodintro.setText(intro);
        imageButton.setOnClickListener(view -> {
            Intent intent=new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
