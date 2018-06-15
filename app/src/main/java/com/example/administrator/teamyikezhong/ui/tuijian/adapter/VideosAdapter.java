package com.example.administrator.teamyikezhong.ui.tuijian.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.inter.OnVideoItemLintenr;
import com.example.administrator.teamyikezhong.ui.tuijian.persenter.TongYongPersenter;
import com.example.administrator.teamyikezhong.utils.HearXinLayout;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosHodler> {
    private  TongYongPersenter mPersenters;
    private Context context;
    private VideosBean videosBean;
    private boolean flag;
    VideosBean.DataBean dataBean;
    OnVideoItemLintenr onVideoItemLintenr;
    String uid;
    public VideosAdapter(TongYongPersenter mPersenters, Context context, VideosBean videosBean) {
        this.mPersenters = mPersenters;
        this.context = context;
        this.videosBean = videosBean;


    }

    public VideosHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.tuijain_remen_item, null);
        VideosHodler videosHodler = new VideosHodler(view);
        return videosHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final VideosHodler holder, final int position) {
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
         uid= String.valueOf(SharedPreferencesUtils.getParam(context, "uid", ""));

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
//**
        holder.member_send_xing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag) {
                    flag = false;
                    Toast.makeText(context,"    取消收藏",Toast.LENGTH_SHORT).show();

                  /*  mPersenters.cancelFavorite(id, wid, token);*/

                    holder.member_send_xing.setImageResource(R.drawable.wujiaoxing);
                } else {
                    flag = true;

                    Toast.makeText(context,"已收藏",Toast.LENGTH_SHORT).show();

                 /*   mPersenters.addFavorite(id, wid, token);*/


                    holder.member_send_xing.setImageResource(R.drawable.raw_1499947358);
                }


            }
        });

      //分享
        holder.mTalkItemFloatingXihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"热门开始分享",Toast.LENGTH_SHORT).show();
                UMImage image = new UMImage(context, "http://img.zcool" +
                        ".cn/community/01d881579dc3620000018c1b430c4b.JPG@3000w_1l_2o_100sh.jpg");//网络图片

                new ShareAction((Activity) context).withMedia(image).setDisplayList
                        (SHARE_MEDIA.WEIXIN, SHARE_MEDIA
                                        .WEIXIN_CIRCLE,
                                SHARE_MEDIA.QQ,
                                SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();

            }
        });
    }
    /**
     * 分享
     */
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    public void onClick(View view) {
        VideosHodler holder;
        holder=new VideosHodler(view);


        final String wid = String.valueOf(dataBean.getWid());
        final String token = String.valueOf(SharedPreferencesUtils.getParam(context, "token", ""));

     /*   holder.member_send_xing.setVisibility(View.GONE);
        holder.member_send_xing2.setVisibility(View.VISIBLE);
        mPersenters.addFavorite(uid,wid,token);*/

}


    @Override
    public int getItemCount() {
        if (videosBean != null) {
            return videosBean.getData().size();
        }
        return 0;


    }
    public  void  onVideosItemLintenr(OnVideoItemLintenr onVideoItemLintenr){
        this.onVideoItemLintenr=onVideoItemLintenr;
    }


}

class VideosHodler extends RecyclerView.ViewHolder {
    private Context context;
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