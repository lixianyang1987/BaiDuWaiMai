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
import com.jikexunyuan.baiduwaimai.adapter.MyAdapter;
import com.jikexunyuan.baiduwaimai.util.GridLayoutManagerTo;


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
    private static RecyclerView rv;
    private static MyAdapter adapter=new MyAdapter();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        FrameLayout f= (FrameLayout) v.findViewById(R.id.home);
        f.setPadding(0, 20, 0, 10);
        f.setBackgroundColor(getResources().getColor(R.color.colorGray));
        rv = new RecyclerView(getContext());
        GridLayoutManager gridLayoutManager =new GridLayoutManagerTo(getContext(), 4, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setBackgroundColor(getResources().getColor(R.color.colorWhiteSmoke));
        rv.setPadding(0, 30, 0, 0);
        RecyclerView.LayoutParams layoutParams =new RecyclerView.LayoutParams( RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
        rv.setAdapter(adapter);
        f.addView(rv,layoutParams);

        return v;
    }
    public static RecyclerView getRv() {
        return rv;
    }


}
