package com.avatar.gridrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerAdapter myRecyclerAdapter;
    private List<String> mDataList = new ArrayList<>();
    private final static int SPAN_COUNT = 8;
    private SparseIntArray mDutyArray = new SparseIntArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        initData();
        initView();
    }

    private void initView(){
        recyclerView.setLayoutManager(new GridLayoutManager(this,SPAN_COUNT));
        // R.color.colorPrimary 分割线颜色
        recyclerView.addItemDecoration(new GridDivider(this, SPAN_COUNT,1, R.color.colorPrimary));
        myRecyclerAdapter = new MyRecyclerAdapter(this, mDataList);
        myRecyclerAdapter.setDutyArray(mDutyArray);
        recyclerView.setAdapter(myRecyclerAdapter);
    }

    private void initData(){
        for (int i = 0; i < 24; i++) {
            mDataList.add(" ");
        }

        mDutyArray.append(0,10);
        mDutyArray.append(1,14);
        mDutyArray.append(2,19);
        mDutyArray.append(3,21);
    }
}
