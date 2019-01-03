package com.dfms.android7;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Long° Engagement on 2018/12/17.
 */

public class Recycler_variety_Adapter extends RecyclerView.Adapter {
    public static final int TYPE_PULL_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    public static final int TYPE_THREE_IMAGE = 2;
    private List<MoreTypeBean> mData;

    public Recycler_variety_Adapter(List<MoreTypeBean> mData) {
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        //根据viewtype来创建条目
        if (viewType == TYPE_PULL_IMAGE) {
            view =View.inflate(parent.getContext(),R.layout.item_pull_img,null);
            return new PullImageHolder(view);
        } else if (viewType == TYPE_RIGHT_IMAGE) {
            view =View.inflate(parent.getContext(),R.layout.item_right_img,null);
            return new RightImageHolder(view);
        } else {
            view =View.inflate(parent.getContext(),R.layout.item_three_img,null);
            return new ThreeImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                   //判断数据类型
        if (holder instanceof PullImageHolder){
            PullImageHolder pullImageHolder = (PullImageHolder) holder;
            pullImageHolder.onrtv.setText(mData.get(position).name);
        }
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        //这是随机产生类型
     /*   MoreTypeBean moreTypeBean = mData.get(position);
        if (moreTypeBean.type == 0) {
            return TYPE_PULL_IMAGE;
        } else if (moreTypeBean.type == 1) {
            return TYPE_RIGHT_IMAGE;
        } else {
            return TYPE_THREE_IMAGE;
        }*/
        if(position%3==0){
            return TYPE_PULL_IMAGE;
        }else if(position%3==1){
            return TYPE_RIGHT_IMAGE;
        }else{
            return TYPE_THREE_IMAGE;
        }

    }
    private class PullImageHolder extends RecyclerView.ViewHolder {
        TextView onrtv;
        public PullImageHolder(View itemView) {
            super(itemView);
            onrtv = itemView.findViewById(R.id.onrtv);
        }
    }

    private class RightImageHolder extends RecyclerView.ViewHolder {

        public RightImageHolder(View itemView) {
            super(itemView);
        }
    }

    private class ThreeImageHolder extends RecyclerView.ViewHolder {

        public ThreeImageHolder(View itemView) {
            super(itemView);
        }
    }
}
