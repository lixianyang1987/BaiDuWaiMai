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
import com.jikexunyuan.baiduwaimai.adapter.HeadFootAdapter;
import com.jikexunyuan.baiduwaimai.adapter.ListAdapter;
import com.jikexunyuan.baiduwaimai.adapter.MyAdapter;
import com.jikexunyuan.baiduwaimai.model.cellData;
import com.jikexunyuan.baiduwaimai.model.listData;
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

    private LinearLayout linearLayout;
    public cellData[] listDatas = new cellData[]{new cellData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new cellData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new cellData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new cellData(0.5, "丽华快餐丽华快", "起送￥30|配送￥6|平均45分钟", 1000, R.drawable.thumbnails), new cellData(1.5, "家常快餐", "起送￥20|配送￥6|平均55分钟", 2000, R.drawable.thumbnails), new cellData(2.5, "天天美食", "起送￥30|配送￥6|平均45分钟", 800, R.drawable.thumbnails), new cellData(3.5, "司机盒饭", "起送￥30|配送￥6|平均45分钟", 900, R.drawable.thumbnails), new cellData(4.5, "狂暴餐饮", "起送￥30|配送￥6|平均45分钟", 100000, R.drawable.thumbnails)};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        FrameLayout f = (FrameLayout) v.findViewById(R.id.home);

         linearLayout = (LinearLayout) v.findViewById(R.id.linearList);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        f.setBackgroundColor(getResources().getColor(R.color.colorGray));

        rvItem = (RecyclerView) v.findViewById(R.id.item);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManagerTo(getContext(), LinearLayoutManager.VERTICAL, false);

        rvItem.setLayoutManager(linearLayoutManager);
        rvItem.setAdapter(new HeadFootAdapter() {
            @Override
            public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int position) {


                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_recycler_itemo, parent, false);
                return new HeadViewHolder(view);
            }

            @Override
            public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int position) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_recycler_item, parent, false);
                return new ItemViewHolder(view);
            }

            @Override
            public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int position) {
                return null;
            }

            @Override
            public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
                HeadViewHolder vh = (HeadViewHolder) holder;
                rv=vh.getRecyclerView();
                rv.setBackgroundColor(getResources().getColor(R.color.colorWhiteSmoke));
                GridLayoutManager gridLayoutManager = new GridLayoutManagerTo(getContext(),4, LinearLayoutManager.VERTICAL, false);
                rv.setLayoutManager(gridLayoutManager);
                rv.setPadding(0, 30, 0, 0);
                rv.setAdapter(adapter);
            }

            @Override
            public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
                ItemViewHolder vh = (ItemViewHolder) holder;
                cellData data = listDatas[position];
                setLvs(data.lv, vh);
                vh.getTvXl().setText("月售" + data.ctXl + "份");
                vh.getImgCt().setImageResource(data.ctImg);
                if (data.ctName.length() > 6) {
                    data.ctName = data.ctName.substring(0, 6) + "....";
                }
                vh.getTvCt().setText(data.ctName);
                vh.getTvScContent().setText(data.ctContent);
            }

            @Override
            public void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getHeadViewCount() {
                return 1;
            }

            @Override
            public int getFootViewCount() {
                return 0;
            }

            @Override
            public int getItemViewCount() {
                return listDatas.length;
            }
        });
        rvItem.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        return v;
    }
    public static RecyclerView getRv() {
        return rv;
    }



    public void setLvs(double d, ItemViewHolder v) {
        for (int j=0;j<5;j++){
            v.getLv()[j].setImageResource(R.drawable.waimai_shoplist_item_icon_star_no);
        }
        if (d % 1 != 0) {
            for (int i = 0; i < d / 1; i++) {
                v.getLv()[i].setImageResource(R.drawable.waimai_shoplist_item_icon_star_full);
                if (i+1>d/1) {
                    v.getLv()[i].setImageResource(R.drawable.businesslistings_list_icon_star_half);
                    break;
                }
            }
        } else {
            for (int i = 0; i < d / 1; i++) {
                v.getLv()[i].setImageResource(R.drawable.waimai_shoplist_item_icon_star_full);
            }
        }
    }
}
