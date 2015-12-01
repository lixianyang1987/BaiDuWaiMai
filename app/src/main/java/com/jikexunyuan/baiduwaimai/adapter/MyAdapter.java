package com.jikexunyuan.baiduwaimai.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.jikexunyuan.baiduwaimai.R;
import com.jikexunyuan.baiduwaimai.model.cellData;

public class MyAdapter extends RecyclerView.Adapter {

public  class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvContent;
        public ImageView imgView;

        public ViewHolder(View root) {
            super(root);
            tvContent = (TextView) root.findViewById(R.id.tv_content);
            imgView = (ImageView) root.findViewById(R.id.img_call);
        }

        public TextView getTvContent() {
            return tvContent;
        }

        public ImageView getImgView() {
            return imgView;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        parent.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {

                itemHeight =parent.getMeasuredHeight();
                return true;
            }
        });
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler, null));
    }

    private int itemHeight;

    public int getItemHeight() {
        return itemHeight;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        cellData data = cellDatas[position];
        vh.getTvContent().setText(data.tvContent);
        vh.getImgView().setImageResource(data.imgId);
        if (position == 0 || position == 1) {
            vh.getImgView().setPadding(20, 0, 0, 0);
        }
    }

    @Override
    public int getItemCount() {
        return cellDatas.length;
    }

    public cellData[] cellDatas = new cellData[]{new cellData("餐饮", R.drawable.cy), new cellData("超市购", R.drawable.csg), new cellData("水果生鲜", R.drawable.sgsx), new cellData("下午茶", R.drawable.xwc), new cellData("土豪特供", R.drawable.thtg), new cellData("质享生活", R.drawable.pzsh), new cellData("百度配送", R.drawable.bdps), new cellData("送药上门", R.drawable.sysm)};


}
