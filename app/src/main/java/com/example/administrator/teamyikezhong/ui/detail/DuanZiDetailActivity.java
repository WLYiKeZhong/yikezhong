package com.example.administrator.teamyikezhong.ui.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.JokeDetailBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.ui.detail.contract.JokeDetailContract;
import com.example.administrator.teamyikezhong.ui.detail.persenter.JokeDetailPersenter;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import de.hdodenhof.circleimageview.CircleImageView;

public class DuanZiDetailActivity extends BaseActivity<JokeDetailPersenter> implements JokeDetailContract.View, View.OnClickListener {

    private CircleImageView mRcImg;

    /**
     * 2017-06-21 14:35
     */
    private TextView mRcTime;
    private FloatingActionButton mTalkItemFloatingA;
    private FloatingActionButton mTalkItemFloatingB;
    private FloatingActionButton mTalkItemFloatingXihuan;
    private FloatingActionsMenu mTalkItemFloating;
    /**
     * 天气美美的适合郊游
     */
    private TextView mTvContent;
    private ImageView mJokeDetailSimpleView;
    private ImageView mFanhui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initdata();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        mRcImg = (CircleImageView) findViewById(R.id.rc_img);

        mRcTime = (TextView) findViewById(R.id.rc_time);
        mTalkItemFloatingA = (FloatingActionButton) findViewById(R.id.talk_item_floating_a);
        mTalkItemFloatingB = (FloatingActionButton) findViewById(R.id.talk_item_floating_b);
        mTalkItemFloatingXihuan = (FloatingActionButton) findViewById(R.id.talk_item_floating_xihuan);
        mTalkItemFloating = (FloatingActionsMenu) findViewById(R.id.talk_item_floating);
        mTvContent = (TextView) findViewById(R.id.tvContent);
        mJokeDetailSimpleView = findViewById(R.id.JokeDetail_simpleView);

        mFanhui = (ImageView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
    }

    /**
     * 获取数据
     */
    public void initdata() {
        int jid = getIntent().getIntExtra("jid", 0);
        mPresenter.getJokeDetail(String.valueOf(jid));
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_duan_zi_detail;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void onJokeDetailSuccess(JokeDetailBean jokeDetailBean) {
        Log.d("jike", jokeDetailBean.getMsg());
        JokeDetailBean.DataBean data = jokeDetailBean.getData();
        String icon = data.getUser().getIcon();
        Glide.with(this).load(icon).into(mRcImg);
        mRcTime.setText(data.getCreateTime());
        String imgUrls = data.getImgUrls();
        Glide.with(this).load(imgUrls).into(mJokeDetailSimpleView);
        mTvContent.setText(data.getContent());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
        }
    }
}
