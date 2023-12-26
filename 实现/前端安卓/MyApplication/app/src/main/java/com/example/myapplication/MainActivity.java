package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.fragments.HomeFra;
import com.example.myapplication.model.food;
import com.example.myapplication.util.dpUtil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeFra.StartHomeAction{
    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter ;
    List<food> mFood = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_nav);



        // 获取页面上的底部导航栏控件
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // 配置navigation与底部菜单之间的联系
        // 底部菜单的样式里面的item里面的ID与navigation布局里面指定的ID必须相同，否则会出现绑定失败的情况
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,R.id.navigation_edit,R.id.navigation_user)
                .build();
        // 建立fragment容器的控制器，这个容器就是页面的上的fragment容器
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // 启动
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Log.e("1", "onCreate:OnCreat方法 " );
    }

    //循环视图实现
    @Override
    protected void onStart() {
        super.onStart();

        fillFood();

    }
    @Override
    public void StartHome() {
        mMyAdapter = new MyAdapter();
        Log.e("1","onCreate:OnStart方法 "+(mMyAdapter==null)+(mRecyclerView==null));
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    //食物数据填充
    void fillFood(){
           for (int i=1;i<=10;i++)
           {
               food mf=new food();
               mf.food_name="1"+i;
               mf.tag.add("10"+i);
               mf.tag.add("100"+i);
               mFood.add(mf);
           }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

        @NonNull
        @Override
        public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(MainActivity.this, R.layout.food_list_item, null);
            MyViewHoder myViewHoder = new MyViewHoder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
            food thisfood = mFood.get(position);
            holder.food_name.setText(thisfood.food_name);
            holder.food_tag1.setText(thisfood.tag.get(0));
            holder.food_tag2.setText(thisfood.tag.get(1));
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
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            food_name = itemView.findViewById(R.id.main_food_name);
            food_tag1 = itemView.findViewById(R.id.main_food_tag1);
            food_tag2=itemView.findViewById(R.id.main_food_tag2);
        }
    }
}

   /* ConstraintLayout fillFood(ConstraintLayout constraintLayout, String imageSrc, String food_name,String[] tags){


        TextView divid=new TextView(this);
        ConstraintLayout.LayoutParams params=new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                dpUtil.dpTOpx(this,2)
        );
        divid.setLayoutParams(params);
        divid.setBackgroundColor(Color.GRAY);
        constraintLayout.addView(divid);

        ImageButton love=new ImageButton(this);
        params=new ConstraintLayout.LayoutParams(
                dpUtil.dpTOpx(this,40),
                dpUtil.dpTOpx(this,40)
        );
        love.setLayoutParams(params);
        love.setScaleType(ImageView.ScaleType.FIT_XY);
        love.setImageResource(R.drawable.love);
        constraintLayout.addView(love);

        ImageView food_image_view=new ImageView(this);
        food_image_view.setImageResource(R.drawable.love);
        params=new ConstraintLayout.LayoutParams(
                dpUtil.dpTOpx(this,150),
                dpUtil.dpTOpx(this,120)
        );
        food_image_view.setLayoutParams(params);
        constraintLayout.addView(food_image_view);


        TextView food_name_view=new TextView(this);
        food_name_view.setText(food_name);
        params=new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        food_name_view.setLayoutParams(params);
        food_name_view.setMaxWidth(dpUtil.dpTOpx(this,200));
        food_name_view.setMinWidth(dpUtil.dpTOpx(this,200));
        food_name_view.setGravity(Gravity.CENTER);
        food_name_view.setTextSize(dpUtil.dpTOpx(this,30));
        constraintLayout.addView(food_name_view);

        TextView food_tag1_view=new TextView(this);
        food_name_view.setText(tags[0]);
        params=new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        food_tag1_view.setLayoutParams(params);
        food_tag1_view.setTextSize(dpUtil.dpTOpx(this,));

        TextView food_tag2_view=new TextView(this);






        ConstraintSet constraintSet=new ConstraintSet();
        constraintSet.clone(constraintLayout);

        return constraintLayout;
    }
   }
*/



