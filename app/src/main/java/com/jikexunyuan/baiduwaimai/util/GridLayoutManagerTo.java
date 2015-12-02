package com.jikexunyuan.baiduwaimai.util;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jikexunyuan.baiduwaimai.HomeFragment;
import com.jikexunyuan.baiduwaimai.adapter.MyAdapter;


public class GridLayoutManagerTo extends GridLayoutManager {
    private MyAdapter adapter;

    public GridLayoutManagerTo(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, final int widthSpec, final int heightSpec) {
        adapter = new MyAdapter();
        View view = recycler.getViewForPosition(0);
        measureChild(view, widthSpec, heightSpec);
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = View.MeasureSpec.getSize(widthSpec);
        //出于美观的考虑RecyclerView Heigut  设置时不在添加 边距
     //   int paddingHeight = HomeFragment.getRv().getPaddingBottom() + HomeFragment.getRv().getPaddingTop();
        int line = adapter.getItemCount() / getSpanCount();
        if (adapter.getItemCount() % getSpanCount() > 0) {
            line++;
        }
        setMeasuredDimension(measuredWidth, measuredHeight * line);
    }
}