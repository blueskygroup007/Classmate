package com.bluesky.classmate.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluesky.classmate.R;
import com.bluesky.classmate.bean.Sence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlueSky
 * @date 2022/4/11
 * Description:
 */
public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ItemClickListener mListener;

    List<Sence> mData=new ArrayList<>();
    final int SENCEITEM=1;
    final int FOOTER=2;


    interface ItemClickListener{
        void onItemClicked(int position);
        void onAddClicked();
    }

    public GridAdapter(List<Sence> data,ItemClickListener listener) {
        mListener = listener;
        mData = data;
    }

    public void setData(List<Sence> data){
        mData=data;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType==SENCEITEM){
            return new SenceViewHolder(inflater.inflate(R.layout.item_rv_sence, parent, false));
        }else{
            return new FooterViewHolder(inflater.inflate(R.layout.footer_rv_sence, parent, false));
        }
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof SenceViewHolder){
            String path = mData.get(position).getPath();
            //TODO 这里获取视频缩略图
            ((SenceViewHolder) holder).thumb.setImageResource(R.drawable.ic_launcher_foreground);
            ((SenceViewHolder) holder).desc.setText(mData.get(position).getName());
            ((SenceViewHolder) holder).root.setTag(position);
            ((SenceViewHolder) holder).root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked((Integer) v.getTag());
                }
            });
        }else if(holder instanceof FooterViewHolder){
            ((FooterViewHolder) holder).ivFooterAdd.setImageResource(R.drawable.ic_baseline_add_circle_48);
            ((FooterViewHolder) holder).root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onAddClicked();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getItemCount()-1){
            return FOOTER;
        }else{
            return SENCEITEM;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size()+1;
    }

    class SenceViewHolder extends RecyclerView.ViewHolder{
        ImageView thumb;
        TextView desc;
        LinearLayout root;
        public SenceViewHolder(@NonNull View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.iv_thumb);
            desc=itemView.findViewById(R.id.tv_desc);
            root=itemView.findViewById(R.id.ll_item);
        }
    }

    class FooterViewHolder extends  RecyclerView.ViewHolder{
        LinearLayout root;
        ImageView ivFooterAdd;

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFooterAdd =itemView.findViewById(R.id.iv_footer_add);
            root=itemView.findViewById(R.id.ll_footer);
        }
    }
}
