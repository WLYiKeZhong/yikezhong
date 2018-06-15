package com.example.administrator.teamyikezhong.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DetailBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.ui.detail.contract.DetailContract;
import com.example.administrator.teamyikezhong.ui.detail.persenter.DetailPersenter;
import com.example.administrator.teamyikezhong.ui.yonghuyemian.YongHuActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

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
    private ImageView mImgXin;
    private ImageView mSuiXin;
    private ImageView mFenXiang;
   private  boolean flag;
   private  boolean isFlag;
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
        Log.d("detail", detailBean.getMsg());
        String videoUrl = detailBean.getData().getVideoUrl();
        //视频判空
        if (videoUrl == null) {
            return;
        }

        mDetailVideos.setUp(videoUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
       /* mTvNum.setText(detailBean.getData().getPlayNum());*/
        mTvTime.setText(detailBean.getData().getCreateTime());

    }

    public void initData() {
        int wid = getIntent().getIntExtra("wid", 0);

        mPresenter.getVideoDetail(String.valueOf(wid));
    }

    private void initView() {
        mDetailVideos = (JCVideoPlayerStandard) findViewById(R.id.detailVideos);

        mTvNum = (TextView) findViewById(R.id.tv_num);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        detailSimle = findViewById(R.id.detailSimleView);
        fanhui = findViewById(R.id.fanhui);
        fanhui.setOnClickListener(this);
        detailSimle.setOnClickListener(this);


        mImgXin = (ImageView) findViewById(R.id.imgXin);
        mImgXin.setOnClickListener(this);
        mSuiXin = (ImageView) findViewById(R.id.suiXin);
        mSuiXin.setOnClickListener(this);
        mFenXiang = (ImageView) findViewById(R.id.fenXiang);
        mFenXiang.setOnClickListener(this);
    }

    /**
     * 点击按钮
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();//返回上一层
                break;
            case R.id.detailSimleView:
                //跳转用户页面
                Intent intent = new Intent(VideosDeailActivity.this, YongHuActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.imgXin:
                if (flag){
                    flag=false;
                    mImgXin.setImageResource(R.drawable.raw_1499933216);
                }else {
                    flag=true;
                    mImgXin.setImageResource(R.drawable.raw1499933215);

                }

                break;
            case R.id.suiXin:
                if (isFlag){
                    isFlag=false;
                    mSuiXin.setImageResource(R.drawable.raw_1499933217);
                }else {
                    isFlag=true;
                    mSuiXin.setImageResource(R.drawable.raw_149993321634);

                }
                break;
            case R.id.fenXiang:
                UMImage image = new UMImage(VideosDeailActivity.this, "http://img.zcool" +
                        ".cn/community/01d881579dc3620000018c1b430c4b.JPG@3000w_1l_2o_100sh.jpg");//网络图片

                new ShareAction(VideosDeailActivity.this).withMedia(image).setDisplayList
                        (SHARE_MEDIA.WEIXIN, SHARE_MEDIA
                                        .WEIXIN_CIRCLE,
                                SHARE_MEDIA.QQ,
                                SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();

                break;
        }
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
            Toast.makeText(VideosDeailActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(VideosDeailActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(VideosDeailActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
}
