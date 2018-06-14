package com.example.administrator.teamyikezhong.ui.videos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.VideosNearBean;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public class NearVideoAdapter extends RecyclerView.Adapter<NearVideoHolder> {
    private Context context;
    private List<VideosNearBean.DataBean> list;
    public OnItemLinter onItemLinter;
    public NearVideoAdapter(Context context, List<VideosNearBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public NearVideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.remen_hotvideos_item_fragment,null);
        NearVideoHolder nearVideoHolder=new NearVideoHolder(view);
        return nearVideoHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull NearVideoHolder holder, final int position) {
        String cover = list.get(position).getCover();
        holder.videosSimple.setImageURI(cover);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemLinter.onItemClick(position);
                onItemLinter.onLongItemClick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();

        }
        return 0;
    }
    public  void  onVideosItemLintenr(OnItemLinter onItemLinter){
        this.onItemLinter=onItemLinter;
    }
}
class  NearVideoHolder extends RecyclerView.ViewHolder{
    public SimpleDraweeView videosSimple;
    public NearVideoHolder(View itemView) {
        super(itemView);
        videosSimple = itemView.findViewById(R.id.videosSimple);
    }
}