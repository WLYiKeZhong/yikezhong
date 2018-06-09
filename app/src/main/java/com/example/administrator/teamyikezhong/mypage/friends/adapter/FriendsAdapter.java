package com.example.administrator.teamyikezhong.mypage.friends.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.FriendsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class FriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FriendsBean.DataBean> data;
    private final LayoutInflater inflater;

    public FriendsAdapter(Context context, List<FriendsBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.friends_item, null);
        FriendsViewHolder friendsViewHolder = new FriendsViewHolder(view);
        return friendsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FriendsViewHolder friendsViewHolder = (FriendsViewHolder) holder;
        FriendsBean.DataBean dataBean = data.get(position);
        friendsViewHolder.tv_name.setText(dataBean.getUsername());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

class FriendsViewHolder extends RecyclerView.ViewHolder{
    private final SimpleDraweeView sdv;
    private final TextView tv_name;
    private final TextView tv_con;
    public FriendsViewHolder(View itemView) {
        super(itemView);
        sdv = itemView.findViewById(R.id.sdv);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_con = itemView.findViewById(R.id.tv_con);


    }
}

}
