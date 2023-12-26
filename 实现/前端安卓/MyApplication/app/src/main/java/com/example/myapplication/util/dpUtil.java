package com.example.myapplication.util;

import android.content.Context;

public class dpUtil {
    public static int dpTOpx(Context context,float dp){
        //获取当前手机像素密度
        float scale=context.getResources().getDisplayMetrics().density;
        return (int) (dp*scale+0.5f);
    }

}
