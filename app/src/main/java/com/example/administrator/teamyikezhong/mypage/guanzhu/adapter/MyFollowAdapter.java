package com.example.administrator.teamyikezhong.mypage.guanzhu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class MyFollowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<FollowUsersBean.DataBean> data;
    private final LayoutInflater inflater;

    public MyFollowAdapter(Context context, List<FollowUsersBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.myfollow_item, null);
        FollowViewHolder followViewHolder = new FollowViewHolder(view);
        return followViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FollowViewHolder followViewHolder = (FollowViewHolder) holder;
        FollowUsersBean.DataBean dataBean = data.get(position);
        followViewHolder.tv_name.setText(dataBean.getUsername());
        followViewHolder.tv_time.setText(dataBean.getCreatetime());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

class FollowViewHolder extends RecyclerView.ViewHolder{

    private final SimpleDraweeView sdv;
    private final TextView tv_name;
    private final TextView tv_con;
    private final TextView tv_time;

    public FollowViewHolder(View itemView) {
        super(itemView);
        sdv = itemView.findViewById(R.id.sdv);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_con = itemView.findViewById(R.id.tv_con);
        tv_time = itemView.findViewById(R.id.tv_time);


    }
}

}
