package com.example.administrator.teamyikezhong.mypage.zuopin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/12 0012.
 */

public class BenDiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> data;
    public OnItemLinter onItemLinter;
    public BenDiAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.bendishipin_item,null);
        HotVideosHolder hotVideosHolder=new HotVideosHolder(view);
        return hotVideosHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HotVideosHolder hotVideosHolder= (HotVideosHolder) holder;
        String s = data.get(position);
        hotVideosHolder.videosSimple.setImageURI(s);
        hotVideosHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemLinter.onItemClick(position);
            }
        });
    }
    public  void  onVideosItemLintenr(OnItemLinter onItemLinter){
        this.onItemLinter=onItemLinter;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class  HotVideosHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView videosSimple;


        public HotVideosHolder(View itemView) {
            super(itemView);
            videosSimple = itemView.findViewById(R.id.videosSimple);
        }
    }
}
