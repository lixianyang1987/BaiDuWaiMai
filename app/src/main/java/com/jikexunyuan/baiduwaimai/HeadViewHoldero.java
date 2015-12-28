package com.jikexunyuan.baiduwaimai;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/28.
 */
public class HeadViewHoldero extends RecyclerView.ViewHolder {

    public TextView tvContent;
    public ImageView imgView;

    public HeadViewHoldero(View root) {
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
