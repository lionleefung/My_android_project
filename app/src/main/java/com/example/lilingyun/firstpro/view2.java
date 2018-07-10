package com.example.lilingyun.firstpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class view2 extends AppCompatActivity {
    private RecyclerView recycle;
    private boolean moving,readyMove;
    private LinearLayoutManager grid;
    private RecycleAdapter adapter;
    private List<String> list = new ArrayList<String>();
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2);
        recycle=findViewById(R.id.re);
        //  纵向滑动
       grid = new LinearLayoutManager(this);
        recycle.setLayoutManager(grid);
       //      获取数据，向适配器传数据，绑定适配器
        initView();
        list = initData();
        adapter = new RecycleAdapter(view2.this, list);
        recycle.setAdapter(adapter);
       //      添加动画
        recycle.setItemAnimator(new DefaultItemAnimator());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              添加自带默认动画
                adapter.addData(list.size());
            }
        });

        recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView,newState);
                if(newState== RecyclerView.SCROLL_STATE_IDLE){
                    moving=false;
                }
                if(moving==false&&readyMove==true){
                    int firstItem=grid.findFirstVisibleItemPosition();
                    int top =recycle.getChildAt(50- firstItem).getTop();
                    recycle.smoothScrollBy(0,top);
                    moving=true;
                    readyMove=false;
                }
            }
@Override
public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView,dx,dy);
            }
    });

    }
    private void initView() {
        btn = findViewById(R.id.button6);
        recycle =findViewById(R.id.re);
    }
    protected ArrayList<String> initData() {
        ArrayList<String> mDatas = new ArrayList<String>();
        for (int i = 0; i < 1; i++) {
            mDatas.add("我是商品" + i);
        }
        return mDatas;
    }
}
