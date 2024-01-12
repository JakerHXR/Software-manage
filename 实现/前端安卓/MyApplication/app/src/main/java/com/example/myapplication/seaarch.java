package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.food;

import java.util.ArrayList;

public class seaarch extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_food);
        SearchView searchView=findViewById(R.id.searchView3);
        EditText tag=findViewById(R.id.search_tags);

        ImageButton button=findViewById(R.id.back);
        button.setOnClickListener(view -> {
            onBackPressed();
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("1","test");
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("search_name",query);
                bundle.putString("search_tag", tag.getText().toString());
                intent.putExtras(bundle);
                intent.setClass(seaarch.this,search_result.class);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });


    }


}
