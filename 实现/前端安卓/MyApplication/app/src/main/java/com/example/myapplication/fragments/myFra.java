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

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.log_frm;

public class myFra extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.user_set,container,false);
        ConstraintLayout cons=root.findViewById(R.id.exit);
        cons.setOnClickListener(view -> {
            Intent intent=new Intent();
            intent.setClass(getActivity(),log_frm.class);
            startActivity(intent);
        });

        return root;

    }
    public interface StartButton{
        void  myButton();
    }
    StartButton callback;
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callback=(StartButton) context;
        Log.e("1", "onCreate:OnAttach方法 " );
    }

    @Override
    public void onStart() {
        super.onStart();
        callback.myButton();
    }
}
