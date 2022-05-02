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
public class SenceRecyclerAdapter extends RecyclerView.Adapter<SenceRecyclerAdapter.ViewHolder> {

    private List<Sence> mData=new ArrayList<>();

    public void setData(List<Sence> data){
        mData=data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.item_rv_sence,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String path = mData.get(position).getPath();
        //TODO 这里获取视频缩略图
        holder.thumb.setImageResource(R.drawable.ic_launcher_foreground);
        holder.desc.setText(mData.get(position).getName());
        holder.root.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView thumb;
        TextView desc;
        LinearLayout root;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.iv_thumb);
            desc=itemView.findViewById(R.id.tv_desc);
            root=itemView.findViewById(R.id.ll_item);
        }
    }
}
