package com.jikexunyuan.baiduwaimai;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/28.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView tvScContent, tvCt, tvXl;
    public ImageView imgCt;
    public ImageView lv1, lv2, lv3, lv4, lv5;
    public ImageView[] lv;

    public ItemViewHolder(View root) {
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
