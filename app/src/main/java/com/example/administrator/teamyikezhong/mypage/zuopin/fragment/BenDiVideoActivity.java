package com.example.administrator.teamyikezhong.mypage.zuopin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.administrator.teamyikezhong.R;
import com.facebook.drawee.view.SimpleDraweeView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class BenDiVideoActivity extends AppCompatActivity {

    private ImageView mFanhui;
    private SimpleDraweeView mDetailSimle;
    private LinearLayout mLinearLayout;
    private VideoView mDetailVideos;
    /**
     * 女子翻墙
     */
    private TextView mTvTitle;
    /**
     * 1916
     */
    private TextView mTvNum;
    /**
     * 21.41
     */
    private TextView mTvTime;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ben_di_video);

        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        Log.e("zzzzzz", path);
        initView();
    }

    private void initView() {
        mFanhui = (ImageView) findViewById(R.id.fanhui);
        mDetailSimle = (SimpleDraweeView) findViewById(R.id.detailSimle);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mDetailVideos = findViewById(R.id.detailVideos);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvNum = (TextView) findViewById(R.id.tv_num);
        mTvTime = (TextView) findViewById(R.id.tv_time);
      //  mDetailVideos.setUp(path, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
        mDetailVideos.setVideoPath(path);
        MediaController mediaController = new MediaController(BenDiVideoActivity.this);
        mDetailVideos.setMediaController(mediaController);
        mediaController.setAnchorView(mDetailVideos);
        mDetailVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDetailVideos.start();
            }
        });

        mFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }
}
