package com.jikexunyuan.baiduwaimai;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/28.
 */
public class HeadViewHolder extends RecyclerView.ViewHolder {


    public RecyclerView recyclerView;
    public HeadViewHolder(View root) {
        super(root);
         recyclerView= (RecyclerView) root.findViewById(R.id.itemo);

    }



    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
