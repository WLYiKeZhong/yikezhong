package com.example.administrator.teamyikezhong.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DetailBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.ui.detail.contract.DetailContract;
import com.example.administrator.teamyikezhong.ui.detail.persenter.DetailPersenter;
import com.facebook.drawee.view.SimpleDraweeView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 视频详情
 */
public class VideosDeailActivity extends BaseActivity<DetailPersenter> implements DetailContract.View, View.OnClickListener {
    private JCVideoPlayerStandard mDetailVideos;

    /**
     * 1916
     */
    private TextView mTvNum;
    /**
     * 21.41
     */
    private TextView mTvTime;
    private SimpleDraweeView detailSimle;
    private ImageView fanhui;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView();
        initData();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_videos_deail;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void onDetailSuccess(DetailBean detailBean) {
        Log.d("detail",detailBean.getMsg());
        String videoUrl = detailBean.getData().getVideoUrl();
        //视频判空
        if(videoUrl==null){
            return;
        }

        mDetailVideos.setUp(videoUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
       /* mTvNum.setText(detailBean.getData().getPlayNum());*/
        mTvTime.setText(detailBean.getData().getCreateTime());
        detailSimle.setImageURI(detailBean.getData().getUser().getIcon());

    }

    public void initData() {
    /*  SharedPreferencesUtils.getParam(this,"wid",)*/
        int wid = getIntent().getIntExtra("wid", 0);

        mPresenter.getVideoDetail(String.valueOf(wid));
    }

    private void initView() {
        mDetailVideos = (JCVideoPlayerStandard) findViewById(R.id.detailVideos);

        mTvNum = (TextView) findViewById(R.id.tv_num);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        detailSimle = findViewById(R.id.detailSimle);
        fanhui = findViewById(R.id.fanhui);
        fanhui.setOnClickListener(this);

    }

    /**
     * 点击按钮
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fanhui:
                finish();//返回上一层
                break;
        }
    }
}
