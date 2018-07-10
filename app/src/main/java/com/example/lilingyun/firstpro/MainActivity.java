package com.example.lilingyun.firstpro;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {
    private ViewPager vp;
    private List<View> views;
    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到button按钮控件
        button=  findViewById(R.id.button);
        button2= findViewById(R.id.button2);
        //找到ViewPager控件
        vp = findViewById(R.id.vp);
        views=new ArrayList<View>();
        //初始化view
        initView();
        //设置ViewPager的适配器
        MyViewPagerAdapter adapter=new MyViewPagerAdapter(views, this);
        vp.setAdapter(adapter);
        //设置监听
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        //设置默认页面
        //button.setBackgroundColor(Color.RED);
        vp.setCurrentItem(0);
    }
    //初始化view
    private void initView() {
        //创建view布局
        View view1=View.inflate(this, R.layout.view1, null);
        View view2=View.inflate(this, R.layout.view2, null);
        //把view布局添加到集合
        views.add(view1);
        views.add(view2);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                vp.setCurrentItem(0);
                break;
            case R.id.button:
                vp.setCurrentItem(1);
               break;
            default:
                break;
        }

    }

}