package com.jikexunyuan.baiduwaimai.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.jikexunyuan.baiduwaimai.HomeFragment;
import com.jikexunyuan.baiduwaimai.MainActivity;
import com.jikexunyuan.baiduwaimai.MeFragment;
import com.jikexunyuan.baiduwaimai.adapter.ListAdapter;
import com.jikexunyuan.baiduwaimai.adapter.ListMeAdapter;

/**
 * Created by Administrator on 2015/12/7.
 */
public class LinearLayoutManagerMeTo extends LinearLayoutManager {
    private ListMeAdapter adapter;
    public LinearLayoutManagerMeTo(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public LinearLayoutManagerMeTo(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }
    public LinearLayoutManagerMeTo(Context context) {
        super(context);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        View view = recycler.getViewForPosition(0);
        if(view != null){
            measureChild(view, widthSpec, heightSpec);
            int measuredWidth = View.MeasureSpec.getSize(widthSpec);
            int measuredHeight = MainActivity.getCoordinatorLayout().getMeasuredHeight()-MainActivity.getTabLayout().getMeasuredHeight()- MeFragment.getLine().getMeasuredHeight()-10;
            setMeasuredDimension(measuredWidth,measuredHeight);
        }

    }
}
