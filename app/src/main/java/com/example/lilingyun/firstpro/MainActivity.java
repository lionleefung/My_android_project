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
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        //找到ViewPager控件
        vp = findViewById(R.id.vp);
        views = new ArrayList<View>();
        //初始化view
        initView();
        //设置ViewPager的适配器
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(views, this);
        vp.setAdapter(adapter);

        //设置ViewPager滑动监听
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                switch (arg0) {
                    case 0:
                        //设置button的背景颜色
                        button.setBackgroundColor(50000000);
                        button2.setBackgroundColor(50000000);
                        break;
                    case 1:
                        button.setBackgroundColor(50000000);
                        button2.setBackgroundColor(50000000);
                        break;
                    default:
                        break;
                }

            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
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
                System.out.println(" ");
                System.out.print(222);
                vp.setCurrentItem(0);
                break;
            case R.id.button:
                System.out.println(" ");
                System.out.print(333);
                vp.setCurrentItem(1);
               break;
            default:
                break;
        }
    }

}
