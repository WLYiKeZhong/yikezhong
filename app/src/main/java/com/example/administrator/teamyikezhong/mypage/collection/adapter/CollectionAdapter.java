package com.example.administrator.teamyikezhong.mypage.collection.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.MyCollectionBean;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class CollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MyCollectionBean.DataBean> data;
    private final LayoutInflater inflater;

    public CollectionAdapter(Context context, List<MyCollectionBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.myshoucang, null);
        CollectionViewHolder collectionViewHolder = new CollectionViewHolder(view);
        return collectionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CollectionViewHolder collectionViewHolder = (CollectionViewHolder) holder;
        MyCollectionBean.DataBean dataBean = data.get(position);
        Glide.with(context).load(dataBean.getUser().getIcon().split("\\|")[0]).into(collectionViewHolder.mRcImg);
        collectionViewHolder.mRcName.setText(dataBean.getUser().getNickname());
        collectionViewHolder.mRcTime.setText(dataBean.getCreateTime());
        collectionViewHolder.mPb.setText(dataBean.getWorkDesc());
        collectionViewHolder.mVideoplayer.setUp(dataBean.getVideoUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "视频播放");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class CollectionViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView mRcImg;
        public TextView mRcName;
        public TextView mRcTime;
        public FloatingActionButton mTalkItemFloatingA;
        public   FloatingActionButton mTalkItemFloatingB;
        public FloatingActionButton mTalkItemFloatingXihuan;
        public FloatingActionsMenu mTalkItemFloating;
        public TextView mPb;
        public JCVideoPlayerSimple mVideoplayer;
        public TextView mScAa;

        public ImageView mMemberSendGood;
        public LinearLayout mLinear;


        public View mView1;


        private boolean flag = true;
        public CollectionViewHolder(View itemView) {
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
    }
}
