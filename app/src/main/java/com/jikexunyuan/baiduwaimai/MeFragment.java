package com.jikexunyuan.baiduwaimai;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jikexunyuan.baiduwaimai.adapter.ListAdapter;
import com.jikexunyuan.baiduwaimai.adapter.ListMeAdapter;
import com.jikexunyuan.baiduwaimai.util.DividerItemDecoration;
import com.jikexunyuan.baiduwaimai.util.LinearLayoutManagerMeTo;
import com.jikexunyuan.baiduwaimai.util.LinearLayoutManagerTo;


/**

 */
public class MeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    // TODO: Rename and change types of parameters



    private static RecyclerView rvItem;
    private static ListMeAdapter adaptermelist = new ListMeAdapter();
    public static LinearLayout line;
    public MeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_me, container, false);
        FrameLayout f = (FrameLayout) v.findViewById(R.id.me);
        line = (LinearLayout) v.findViewById(R.id.me_line);
        f.setBackgroundColor(getResources().getColor(R.color.colorGray));
        LinearLayout meList = (LinearLayout) v.findViewById(R.id.me_list);
        rvItem = new RecyclerView(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManagerMeTo(getContext(), LinearLayoutManager.VERTICAL, false);
        rvItem.setLayoutManager(linearLayoutManager);
        rvItem.setBackgroundColor(getResources().getColor(R.color.colorWhiteSmoke));
        rvItem.setAdapter(adaptermelist);

        rvItem.addItemDecoration(new DividerItemDecoration(getContext(), 1));

        meList.addView(rvItem);

        return v;
    }



    public static LinearLayout getLine() {
        return line;
    }
}
