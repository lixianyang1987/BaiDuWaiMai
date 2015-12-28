package com.jikexunyuan.baiduwaimai.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.jikexunyuan.baiduwaimai.HomeFragment;
import com.jikexunyuan.baiduwaimai.MainActivity;
import com.jikexunyuan.baiduwaimai.adapter.ListAdapter;
import com.jikexunyuan.baiduwaimai.adapter.MyAdapter;

/**
 * Created by Administrator on 2015/12/7.
 */
public class LinearLayoutManagerTo extends LinearLayoutManager {
    private ListAdapter adapter;

    public LinearLayoutManagerTo(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public LinearLayoutManagerTo(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public LinearLayoutManagerTo(Context context) {
        super(context);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        View view = recycler.getViewForPosition(0);

        if (view != null) {
            measureChild(view, widthSpec, heightSpec);
            int measuredWidth = View.MeasureSpec.getSize(widthSpec);
            int measuredHeight = MainActivity.getCoordinatorLayout().getMeasuredHeight() - MainActivity.getTabLayout().getMeasuredHeight()-MainActivity.getToolbar().getMeasuredHeight() ;
            setMeasuredDimension(measuredWidth, measuredHeight);
        }

    }
}
