package com.jikexunyuan.baiduwaimai.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/12/28.
 */
public abstract class HeadFootAdapter<HeadViewHolder extends RecyclerView.ViewHolder, FootViewHolder extends RecyclerView.ViewHolder, ItemViewHolder extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static int TYPE_HEAD = 0;
    static int TYPE_ITEM = 1;
    static int TYPE_FOOT = 2;

    /**
     *头部ViewHolder
     **/
    public abstract HeadViewHolder onCreateHeaderViewHolder(ViewGroup parent, int position);

    public abstract ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int position);

    public abstract FootViewHolder onCreateFooterViewHolder(ViewGroup parent, int position);

    public abstract void onBindHeaderViewHolder(HeadViewHolder holder, int position);

    public abstract void onBindItemViewHolder(ItemViewHolder holder, int position);

    public abstract void onBindFooterViewHolder(FootViewHolder holder, int position);

    /**
     *根据viewType来创建不同的ViewHolder
     **/@Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType){
            case 0:
            return onCreateHeaderViewHolder(viewGroup,viewType);
            case 1:
            return onCreateItemViewHolder(viewGroup, viewType);
            default:
                return onCreateFooterViewHolder(viewGroup,viewType);
        }
    }

    /**
     *根据ViewType绑定数据  这里重新计算了position，使每个部分的position都从0开始
     **/@Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {


        int headCount = getHeadViewCount();
        int itemViewCount = getItemViewCount();
        int itemType = getItemViewType(i);
        switch (itemType){
            case 0:
            onBindHeaderViewHolder((HeadViewHolder) viewHolder,i);
            break;
            case 1:
            onBindItemViewHolder((ItemViewHolder) viewHolder,i-headCount);
            break;
            case 2:
            onBindFooterViewHolder((FootViewHolder) viewHolder,i-itemViewCount-headCount);
            break;

        }
    }


    /**
     *adapter会调用这个方法来获取item的总数
     *因为在这里  总数为上中下三部分数量加起来  不需要重写
     *所以标志为final
     *返回所有View的数量
     **/@Override
    public final int getItemCount(){
        return  getHeadViewCount() + getFootViewCount() + getItemViewCount();
    }

    /**
     *返回头部View的数量
     **/
    public abstract int getHeadViewCount();


    /**
     *返回底部View的数量
     **/
    public abstract int getFootViewCount();


    /**
     *返回中间View的数量
     **/
    public abstract int getItemViewCount();

    /**
     *这句话是关键  根据position来判断item的类型
     *adapter会将此方法的返回值传入onCreateViewHolder
     **/@Override
    public int getItemViewType(int position) {
        //   return super.getItemViewType(position);
        int headCount = getHeadViewCount();
        int itemCount = getItemViewCount();

        if(position<headCount){
            return TYPE_HEAD;
        }
        if(position>headCount+itemCount-1){
            return TYPE_FOOT;
        }
        return TYPE_ITEM;

    }
}
