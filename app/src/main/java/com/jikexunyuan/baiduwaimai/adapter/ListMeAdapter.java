package com.jikexunyuan.baiduwaimai.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jikexunyuan.baiduwaimai.R;

import com.jikexunyuan.baiduwaimai.model.melistData;

/**
 * Created by Administrator on 2015/12/23.
 */
public class ListMeAdapter extends RecyclerView.Adapter {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_content;
        public ImageView img_call;
        public RelativeLayout relative;
        public ImageView img_ic;

        public ImageView getImg_ic() {
            return img_ic;
        }

        public ViewHolder(View root) {
            super(root);
            tv_content = (TextView) root.findViewById(R.id.tv_content);
            relative = (RelativeLayout) root.findViewById(R.id.relative);
            img_ic = (ImageView) root.findViewById(R.id.img_ic);
            img_call = (ImageView) root.findViewById(R.id.img_call);


        }

        public TextView getTv_content() {
            return tv_content;
        }

        public ImageView getImg_call() {
            return img_call;
        }

        public RelativeLayout getRelative() {
            return relative;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_melist, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        melistData data = listDatas[position];
        if(data!=null) {
            vh.getImg_call().setImageResource(data.ctImg);
            vh.getTv_content().setText(data.ctContent);
        }else{
            vh.getTv_content().setText("");
            vh.getImg_call().setImageBitmap(null);
            vh.getImg_ic().setImageBitmap(null);
        }

        if(listDatas.length-1==position){
            vh.getImg_call().setPadding(200,0,0,0);
            vh.getImg_ic().setImageBitmap(null);
        }
    }

    @Override
    public int getItemCount() {
        return listDatas.length;
    }

    public melistData[] listDatas = new melistData[]{new melistData("我的送餐地址", R.drawable.mypage_list_icon_location), new melistData("我的代金劵", R.drawable.mypage_list_icon_daijinjuan), new melistData("我的退款", R.drawable.mypage_list_icon_refund), null, new melistData("我的消息", R.drawable.my_messages),new melistData("我的收藏", R.drawable.mypage_list_icon_star), new melistData("我的评论", R.drawable.mypage_list_icon_comment), null,new melistData("百度钱包", R.drawable.mypage_list_icon_wallet), new melistData("百度糯米", R.drawable.icon_nuomi), null,new melistData("客服-011-7777", R.drawable.mypage_list_icon_call)};
}
