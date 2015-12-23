package com.jikexunyuan.baiduwaimai.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jikexunyuan.baiduwaimai.R;
import com.jikexunyuan.baiduwaimai.model.listData;

/**
 * Created by Administrator on 2015/12/7.
 */
public class ListAdapter extends RecyclerView.Adapter {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvScContent, tvCt, tvXl;
        public ImageView imgCt;
        public ImageView lv1, lv2, lv3, lv4, lv5;
        public ImageView[] lv;

        public ViewHolder(View root) {
            super(root);
            tvScContent = (TextView) root.findViewById(R.id.tv_sc_content);
            tvCt = (TextView) root.findViewById(R.id.tv_ct);
            tvXl = (TextView) root.findViewById(R.id.tv_xl);
            imgCt = (ImageView) root.findViewById(R.id.img_ct);
            lv1 = (ImageView) root.findViewById(R.id.lv_1);
            lv2 = (ImageView) root.findViewById(R.id.lv_2);
            lv3 = (ImageView) root.findViewById(R.id.lv_3);
            lv4 = (ImageView) root.findViewById(R.id.lv_4);
            lv5 = (ImageView) root.findViewById(R.id.lv_5);
            lv = new ImageView[]{lv1, lv2, lv3, lv4, lv5};

        }

        public ImageView[] getLv() {
            return lv;
        }

        public TextView getTvScContent() {
            return tvScContent;
        }


        public ImageView getImgCt() {
            return imgCt;
        }

        public TextView getTvCt() {
            return tvCt;
        }

        public TextView getTvXl() {
            return tvXl;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_item, null));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        listData data = listDatas[position];
        setLvs(data.lv, vh);

        vh.getTvXl().setText("月售" + data.ctXl + "份");
        vh.getImgCt().setImageResource(data.ctImg);
        if (data.ctName.length() > 6) {
            data.ctName = data.ctName.substring(0, 6) + "....";
        }
        vh.getTvCt().setText(data.ctName);
        vh.getTvScContent().setText(data.ctContent);
    }

    @Override
    public int getItemCount() {
        return listDatas.length;
    }

    public void setLvs(double d, ViewHolder v) {
        for (int j=0;j<5;j++){
            v.getLv()[j].setImageResource(R.drawable.waimai_shoplist_item_icon_star_no);
        }
        if (d % 1 != 0) {
            for (int i = 0; i < d / 1; i++) {
                v.getLv()[i].setImageResource(R.drawable.waimai_shoplist_item_icon_star_full);
                if (i+1>d/1) {
                    v.getLv()[i].setImageResource(R.drawable.businesslistings_list_icon_star_half);
                    break;
                }
            }
        } else {
            for (int i = 0; i < d / 1; i++) {
                v.getLv()[i].setImageResource(R.drawable.waimai_shoplist_item_icon_star_full);
            }
        }
    }

    public listData[] listDatas = new listData[]{new listData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new listData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new listData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new listData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new listData(1.5, "家常快餐", "起送￥20|配送￥6|平均55分钟", 2000, R.drawable.thumbnails), new listData(2.5, "天天美食", "起送￥30|配送￥6|平均45分钟", 800, R.drawable.thumbnails), new listData(3.5, "司机盒饭", "起送￥30|配送￥6|平均45分钟", 900, R.drawable.thumbnails), new listData(4.5, "狂暴餐饮", "起送￥30|配送￥6|平均45分钟", 100000, R.drawable.thumbnails)};
}
