package com.example.administrator.teamyikezhong.ui.yonghuyemian.adapyter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 兰昊琼 on 2018/6/6.
 */

public class MeAdapter extends RecyclerView.Adapter<MeHolder> {
    private Context context;
    private List<DuanZiBean.DataBean> list;
    public OnItemLinter onItemLinter;
    public MeAdapter(Context context, List<DuanZiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.meyemian_item, null);
        MeHolder myDuanZiRCHolder = new MeHolder(view);
        return myDuanZiRCHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MeHolder holder, final int position) {
        String url = list.get(position).getUser().getIcon();
        if (url == null) {

        } else {
            String s = url.split("\\|")[0];
            Glide.with(context).load(s).into(holder.rcImg);
        }
        String imgUrls = String.valueOf(list.get(position).getImgUrls());
        holder.meImage.setImageURI(imgUrls);
       holder.rcName.setText(list.get(position).getUser().getNickname());
        holder.rcTime.setText(list.get(position).getCreateTime());
        holder.dzContent.setText(list.get(position).getContent());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemLinter.onLongItemClick(position);
                onItemLinter.onItemClick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public  void  onVideosItemLintenr(OnItemLinter onItemLinter){
        this.onItemLinter=onItemLinter;
    }

}

class MeHolder extends RecyclerView.ViewHolder {
  public CircleImageView rcImg;
    public  TextView rcName;
    public TextView rcTime;
    public SimpleDraweeView meImage;

    public  FloatingActionButton talkItemFloatingA;
    public  FloatingActionButton talkItemFloatingB;
    public FloatingActionButton talkItemFloatingXihuan;
    public   FloatingActionsMenu talkItemFloating;
    public  TextView dzContent;
    public MeHolder(View itemView) {
        super(itemView);
        rcImg = itemView.findViewById(R.id.rc_img);
      rcName = itemView.findViewById(R.id.rc_name);
      rcTime = itemView.findViewById(R.id.rc_time);
       talkItemFloatingA = itemView.findViewById(R.id.talk_item_floating_a);
      talkItemFloatingB = itemView.findViewById(R.id.talk_item_floating_b);
     talkItemFloatingXihuan = itemView.findViewById(R.id.talk_item_floating_xihuan);
      talkItemFloating = itemView.findViewById(R.id.talk_item_floating);
      dzContent = itemView.findViewById(R.id.dzContent);
        meImage = itemView.findViewById(R.id.meImage);

    }
}