package com.example.administrator.teamyikezhong.ui.qutu;

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
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class QutuAdapter extends RecyclerView.Adapter<QuTuHodler> {
    private  TongYongPersenter mPersenters;
    private Context context;
    private VideosBean videosBean;
    private boolean flag ;

    public QutuAdapter(Context context, VideosBean videosBean) {
        this.context = context;
        this.videosBean = videosBean;

    }

    @NonNull
    @Override
    public QuTuHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.qutu_item, null);
        QuTuHodler videosHodler = new QuTuHodler(view);
        return videosHodler;
    }


    @Override
    public void onBindViewHolder(@NonNull final QuTuHodler holder, int position) {
        CircleImageView icon = holder.getImg();
        TextView name = holder.getName();
        TextView time = holder.getTime();

        VideosBean.DataBean dataBean = videosBean.getData().get(position);

        String workDesc = dataBean.getUser().getNickname();
        if (workDesc == null || workDesc.length() > 8) {
            workDesc = "匿名用户";
        }
        String createTime = dataBean.getCreateTime();

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
        holder.qutuView.setImageURI(dataBean.getCover());



    }


    @Override
    public int getItemCount() {
        if (videosBean != null) {
            return videosBean.getData().size();
        }
        return 0;


    }

}

class QuTuHodler extends RecyclerView.ViewHolder {
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

     private HearXinLayout hearXinLayout;
    public View mView1;


    private boolean flag = true;
     private HearXinLayout heartLayout;
    public final SimpleDraweeView qutuView;

    public QuTuHodler(View itemView) {
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
        member_send_xing = itemView.findViewById(R.id.member_send_xing);
        mMemberSendGood = itemView.findViewById(R.id.member_send_good);
        heartLayout = itemView.findViewById(R.id.heart_layout);
        qutuView = itemView.findViewById(R.id.qutuView);

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