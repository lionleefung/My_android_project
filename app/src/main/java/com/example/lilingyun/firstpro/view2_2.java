package com.example.lilingyun.firstpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class view2_2 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecycleAdapter_2 adapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view2);
        mRecyclerView=findViewById(R.id.re);
        adapter=new RecycleAdapter_2(this);
        //List布局
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}

