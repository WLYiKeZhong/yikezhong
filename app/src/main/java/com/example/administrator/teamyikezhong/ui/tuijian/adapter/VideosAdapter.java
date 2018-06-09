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
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosHodler> {
    private Context context;
    private VideosBean videosBean;
    private  boolean flag=false;
    public VideosAdapter(Context context, VideosBean videosBean) {
        this.context = context;
        this.videosBean = videosBean;
    }

    @NonNull
    @Override
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
        VideosBean.DataBean dataBean = videosBean.getData().get(position);

        String workDesc = dataBean.getUser().getNickname();
        if (workDesc == null|| workDesc.length()>8) {
            workDesc = "匿名用户";
        }
        String createTime = dataBean.getCreateTime();
        String videoUrl = dataBean.getVideoUrl();
        String url = dataBean.getUser().getIcon();
        final int id = dataBean.getUid();
        final int wid = dataBean.getWid();
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
                .into( holder.mVideoplayer.thumbImageView);
        holder.mVideoplayer.widthRatio = 4;//播放比例
        holder.mVideoplayer.heightRatio = 3;
        holder.mMemberSendGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    holder.mMemberSendGood.setImageDrawable(R.drawable.);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        if(videosBean!=null){
            return videosBean.getData().size();
        }
            return 0;


    }

}

class VideosHodler extends RecyclerView.ViewHolder {
    public  CircleImageView mRcImg;
    public TextView mRcName;
    public TextView mRcTime;
    public FloatingActionButton mTalkItemFloatingA;
    public   FloatingActionButton mTalkItemFloatingB;
    public FloatingActionButton mTalkItemFloatingXihuan;
    public FloatingActionsMenu mTalkItemFloating;
    public TextView mPb;
    public JCVideoPlayerStandard mVideoplayer;
    public TextView mScAa;

    public ImageView mMemberSendGood;
    public LinearLayout mLinear;


    public View mView1;


    private boolean flag = true;
    public VideosHodler(View itemView) {
        super(itemView);
        mRcImg = itemView.findViewById(R.id.rc_img);
        mRcName = itemView.findViewById(R.id.rc_name);
       mRcTime = itemView.findViewById(R.id.rc_time);
        mTalkItemFloatingA = itemView.findViewById(R.id.talk_item_floating_a);
        mTalkItemFloatingB = itemView.findViewById(R.id.talk_item_floating_b);
        mTalkItemFloatingXihuan = itemView.findViewById(R.id.talk_item_floating_xihuan);
        mTalkItemFloating = itemView.findViewById(R.id.talk_item_floating);
        mPb = itemView.findViewById(R.id.pb);
        mVideoplayer = itemView.findViewById(R.id.videoplayer);
        mScAa = itemView.findViewById(R.id.sc_aa);

        mMemberSendGood = itemView.findViewById(R.id.member_send_good);
        mLinear = itemView.findViewById(R.id.linear);




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