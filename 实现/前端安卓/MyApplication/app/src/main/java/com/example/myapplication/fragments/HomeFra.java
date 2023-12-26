package com.example.myapplication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class HomeFra extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_menu,container,false);
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

    @Override
    public void onResume() {
        super.onResume();
        Log.e("1", "onCreate:frageOnResume方法 " );
    }
}
