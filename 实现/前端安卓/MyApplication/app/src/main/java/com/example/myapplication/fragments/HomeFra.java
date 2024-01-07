package com.example.myapplication.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.log_frm;
import com.example.myapplication.seaarch;

public class HomeFra extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_menu,container,false);
        TextView username=root.findViewById(R.id.username);
        Log.e("1",log_frm.user_name);
        username.setText(log_frm.user_name);
        SearchView searchView=root.findViewById(R.id.searchView);
        searchView.setOnClickListener(view -> {
            Intent intent=new Intent();
            intent.setClass(getActivity(), seaarch.class);
            startActivity(intent);
        });
        return root;
    }

    public interface StartHomeAction{
        void  StartHome();
    }
    private StartHomeAction callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callback=(StartHomeAction) context;
        Log.e("1", "onCreate:OnAttach方法 " );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("1", "onCreate:frageOnStart方法 " );
        callback.StartHome();

    }



}
