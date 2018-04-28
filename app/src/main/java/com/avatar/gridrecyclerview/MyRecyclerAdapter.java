package com.avatar.gridrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xuhan on 18-4-27.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<String> mDataList;
    private final static int SPAN_COUNT = 8;
    private String[] weeks = {" ", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    private String[] days = {"上午", "下午"};
    private SparseIntArray mDutyArray; //值班天数


    public MyRecyclerAdapter(Context context, List<String> datalist) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = datalist;
    }

    public void setDutyArray(SparseIntArray dutyArray) {
        this.mDutyArray = dutyArray;
    }

    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, int position) {
        if (position < SPAN_COUNT) {
            holder.mTextView.setText(weeks[position]);
            // 设置 星期 背景颜色
            holder.mTextView.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
        } else if (position == SPAN_COUNT) {
            holder.mTextView.setText(days[0]);
        } else if (position == SPAN_COUNT * 2) {
            holder.mTextView.setText(days[1]);
        } else {
            holder.mTextView.setText(mDataList.get(position));
            for (int i = 0; i < mDutyArray.size(); i++) {
                if (position == mDutyArray.get(i)) {
                    holder.mImageView.setImageResource(R.mipmap.icon_xuanze);
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_tv);
            mImageView = itemView.findViewById(R.id.item_image);
        }
    }
}
