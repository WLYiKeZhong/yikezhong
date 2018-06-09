package com.example.administrator.teamyikezhong.ui.videos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.HotVideosBean;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public class HotVideosAdapter extends RecyclerView.Adapter<HotVideosHolder>{
    private Context context;
    private List<HotVideosBean.DataBean> list;
    public OnItemLinter onItemLinter;
    public HotVideosAdapter(Context context, List<HotVideosBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HotVideosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.remen_hotvideos_item_fragment,null);
        HotVideosHolder hotVideosHolder=new HotVideosHolder(view);
        return hotVideosHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotVideosHolder holder, final int position) {
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
      return  0;
    }
    public  void  onVideosItemLintenr(OnItemLinter onItemLinter){
        this.onItemLinter=onItemLinter;
    }
}
class  HotVideosHolder extends RecyclerView.ViewHolder{

    public SimpleDraweeView videosSimple;


    public HotVideosHolder(View itemView) {
        super(itemView);
        videosSimple = itemView.findViewById(R.id.videosSimple);
    }


}
