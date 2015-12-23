package com.jikexunyuan.baiduwaimai;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jikexunyuan.baiduwaimai.adapter.ListAdapter;
import com.jikexunyuan.baiduwaimai.adapter.MyAdapter;
import com.jikexunyuan.baiduwaimai.util.DividerItemDecoration;
import com.jikexunyuan.baiduwaimai.util.GridLayoutManagerTo;
import com.jikexunyuan.baiduwaimai.util.LinearLayoutManagerTo;

public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */


    public HomeFragment() {
        // Required empty public constructor

    }

    private static RecyclerView rv, rvItem;
    private static MyAdapter adapter = new MyAdapter();
    private static ListAdapter adapterlist = new ListAdapter();
    public static  RelativeLayout relativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        FrameLayout f = (FrameLayout) v.findViewById(R.id.home);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.linear);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        f.setBackgroundColor(getResources().getColor(R.color.colorGray));
        rv = new RecyclerView(getContext());
        rvItem = new RecyclerView(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManagerTo(getContext(), 4, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManagerTo(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        rvItem.setLayoutManager(linearLayoutManager);
        rv.setBackgroundColor(getResources().getColor(R.color.colorWhiteSmoke));
        rvItem.setBackgroundColor(getResources().getColor(R.color.colorWhiteSmoke));
        rv.setPadding(0, 30, 0, 0);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        rv.setAdapter(adapter);
        rvItem.setAdapter(adapterlist);
        rvItem.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        linearLayout.addView(rv, layoutParams);
        linearLayout.addView(rvItem, layoutParams);
         relativeLayout = (RelativeLayout) v.findViewById(R.id.relative);

        return v;
    }

    public static RecyclerView getRv() {
        return rv;
    }

    public static RecyclerView getRvItem() {
        return rvItem;
    }

    public static RelativeLayout getRelativeLayout() {
        return relativeLayout;
    }
}
