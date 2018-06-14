package com.example.administrator.teamyikezhong.ui.tuijian.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.ui.tuijian.persenter.TongYongPersenter;
import com.example.administrator.teamyikezhong.utils.HearXinLayout;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosHodler> {
    private  TongYongPersenter mPersenters;
    private Context context;
    private VideosBean videosBean;
  /*  private boolean flag[];*/
    VideosBean.DataBean dataBean;
    public VideosAdapter(TongYongPersenter mPersenters, Context context, VideosBean videosBean) {
        this.mPersenters = mPersenters;
        this.context = context;
        this.videosBean = videosBean;
       /*  boolean[] flags = new boolean[1];*/
    }

    public VideosHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.tuijain_remen_item, null);
        VideosHodler videosHodler = new VideosHodler(view);
        return videosHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final VideosHodler holder, int position) {
        CircleImageView icon = holder.getImg();
        TextView name = holder.getName();
        TextView time = holder.getTime();
        JCVideoPlayerStandard videoplayer = holder.getVideoplayer();
       dataBean = videosBean.getData().get(position);

        String workDesc = dataBean.getUser().getNickname();
        if (workDesc == null || workDesc.length() > 8) {
            workDesc = "匿名用户";
        }
        String createTime = dataBean.getCreateTime();
        String videoUrl = dataBean.getVideoUrl();
        String url = dataBean.getUser().getIcon();

        final String id = String.valueOf(dataBean.getUid());
        final String wid = String.valueOf(dataBean.getWid());
        final String token = String.valueOf(SharedPreferencesUtils.getParam(context, "token", ""));

        if (url == null) {

        } else {
            String s = url.split("\\|")[0];
            Glide.with(context).load(s).into(icon);
        }
        name.setText(workDesc);
        time.setText(createTime);
        holder.mPb.setText(dataBean.getWorkDesc());

        holder.mVideoplayer.TOOL_BAR_EXIST = false;
        holder.mVideoplayer.setUp(videoUrl
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "视频播放");

        Glide.with(context).load(videoUrl)
                .into(holder.mVideoplayer.thumbImageView);
        holder.mVideoplayer.widthRatio = 4;//播放比例
        holder.mVideoplayer.heightRatio = 3;
/*
        holder.member_send_xing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag[0]) {
                    flag[0] = false;
                    holder.member_send_xing.setVisibility(View.VISIBLE);
                    mPersenters.cancelFavorite(id, wid, token);
                    holder.member_send_xing.setVisibility(View.GONE);
                    holder.member_send_xing.setImageResource(R.drawable.wujiaoxing);
                } else {
                    flag[0] = true;

                    holder.member_send_xing.setVisibility(View.GONE);
                    mPersenters.addFavorite(id, wid, token);
                    holder.member_send_xing.setVisibility(View.VISIBLE);

                    holder.member_send_xing.setImageResource(R.drawable.raw_1499947358);
                }


            }
        });*/
       /* //点赞
        holder.mTalkItemFloatingA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPersenters.getPraise(id, wid, token);
            }
        });*/
    }
  /*  public void onClick(View view) {
        VideosHodler holder;
        holder=new VideosHodler(view);
        final String uid = String.valueOf(SharedPreferencesUtils.getParam(context, "uid", ""));


        final String wid = String.valueOf(dataBean.getWid());
        final String token = String.valueOf(SharedPreferencesUtils.getParam(context, "token", ""));

        holder.member_send_xing.setVisibility(View.GONE);
        holder.member_send_xing2.setVisibility(View.VISIBLE);
        mPersenters.addFavorite(uid,wid,token);

}*/


    @Override
    public int getItemCount() {
        if (videosBean != null) {
            return videosBean.getData().size();
        }
        return 0;


    }

}

class VideosHodler extends RecyclerView.ViewHolder {
    public CircleImageView mRcImg;
    public TextView mRcName;
    public TextView mRcTime;
    public FloatingActionButton mTalkItemFloatingA;
    public FloatingActionButton mTalkItemFloatingB;
    public FloatingActionButton mTalkItemFloatingXihuan;
    public FloatingActionsMenu mTalkItemFloating;
    public TextView mPb;
    public JCVideoPlayerStandard mVideoplayer;


    public ImageView member_send_xing;
    public ImageView member_send_xing2;
    public LinearLayout mLinear;
    public ImageView mMemberSendGood;

    public View mView1;


    private boolean flag = true;
     private HearXinLayout heartLayout;

    public VideosHodler(View itemView) {
        super(itemView);
        mRcImg = itemView.findViewById(R.id.rc_img);
        mRcName = itemView.findViewById(R.id.rc_name);
        mRcTime = itemView.findViewById(R.id.rc_time);
        mTalkItemFloatingA = itemView.findViewById(R.id.talk_item_floating_a);
        mTalkItemFloatingB = itemView.findViewById(R.id.talk_item_floating_b);
        mTalkItemFloatingXihuan = itemView.findViewById(R.id.talk_item_floating_xihuan);
        mTalkItemFloating = itemView.findViewById(R.id.talk_item_floating);
        mPb = itemView.findViewById(R.id.tjPb);
        mVideoplayer = itemView.findViewById(R.id.videoplayer);
        member_send_xing = itemView.findViewById(R.id.member_send_xing);
        member_send_xing2 = itemView.findViewById(R.id.member_send_xing2);
        mMemberSendGood = itemView.findViewById(R.id.member_send_good);
        heartLayout = itemView.findViewById(R.id.heart_layout);

        mLinear = itemView.findViewById(R.id.linear);
        //点赞
        itemView.findViewById(R.id.member_send_good).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heartLayout.addFavor();

            }
        });

        mView1 = itemView.findViewById(R.id.view1);


    }

    public CircleImageView getImg() {
        return mRcImg;
    }

    public TextView getName() {
        return mRcName;
    }

    public TextView getTime() {
        return mRcTime;
    }

    public JCVideoPlayerStandard getVideoplayer() {
        return mVideoplayer;
    }
}