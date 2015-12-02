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

        adapter = (MyAdapter) HomeFragment.getRv().getAdapter();
        View view = recycler.getViewForPosition(0);
        measureChild(view, widthSpec, heightSpec);
        if (adapter != null && adapter.getItemHeight() > 0) {
            int measuredWidth = View.MeasureSpec.getSize(widthSpec);
            int measuredHeight = adapter.getItemHeight() +  HomeFragment.getRv().getPaddingBottom() +  HomeFragment.getRv().getPaddingTop();
            int line = adapter.getItemCount() / getSpanCount();
            if (adapter.getItemCount() % getSpanCount() > 0) line++;
            setMeasuredDimension(measuredWidth, measuredHeight * line);
        } else {
            super.onMeasure(recycler, state, widthSpec, heightSpec);
        }

    }
}