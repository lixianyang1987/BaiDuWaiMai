package com.jikexunyuan.baiduwaimai.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.jikexunyuan.baiduwaimai.R;

/**
 * Created by Administrator on 2015/12/24.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if( parent.getChildCount()==12){
          View v=  parent.getChildAt(3);
            v.setBackgroundColor(view.getResources().getColor(R.color.colorGray));
           v.setPadding(0, -30, 0, 0);
         v=  parent.getChildAt(7);
            v.setBackgroundColor(view.getResources().getColor(R.color.colorGray));
           v.setPadding(0, -30, 0, 0);
           v=  parent.getChildAt(10);
            v.setBackgroundColor(view.getResources().getColor(R.color.colorGray));
           v.setPadding(0, -30, 0, 0);

        }

    }
}
