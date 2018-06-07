package com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.HotFollowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HotFollowBean.DataBean> data;
    private final LayoutInflater inflater;

    public RvAdapter(Context context, List<HotFollowBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.myfollow_item, null);
        HotViewHolder hotViewHolder = new HotViewHolder(view);
        return hotViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotViewHolder hotViewHolder = (HotViewHolder) holder;
        HotFollowBean.DataBean dataBean = data.get(position);
        HotFollowBean.DataBean.UserBean user = dataBean.getUser();
        hotViewHolder.sdv.setImageURI(user.getIcon());
        hotViewHolder.tv_con.setText(dataBean.getWorkDesc());
        hotViewHolder.tv_name.setText(user.getNickname());
        hotViewHolder.tv_time.setText(dataBean.getCreateTime());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class HotViewHolder extends RecyclerView.ViewHolder{
        private final SimpleDraweeView sdv;
        private final TextView tv_name;
        private final TextView tv_con;
        private final TextView tv_time;
        public HotViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_con = itemView.findViewById(R.id.tv_con);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
}
