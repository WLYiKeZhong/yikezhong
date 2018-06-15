package com.example.administrator.teamyikezhong.mypage.fabu.shipin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.fabu.duanzi.DuanSuccessActivity;
import com.example.administrator.teamyikezhong.mypage.fabu.duanzi.FaBuDuanActivity;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoActivity extends BaseActivity<PublishVideoPresenter> implements PublishVideoContract.View, View.OnClickListener {

    private JCVideoPlayerStandard mVideoplayer;
    /**
     * 下一步
     */
    private Button mXiayibu;
    private String path;
    private String uid;
    private String token;
    private String iconUrl;
    private String imgpath = Environment.getExternalStorageDirectory()+"/tou.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        uid = (String) SharedPreferencesUtils.getParam(VideoActivity.this, "uid", "-1");
        token = (String) SharedPreferencesUtils.getParam(VideoActivity.this, "token", "");
        iconUrl = (String) SharedPreferencesUtils.getParam(VideoActivity.this, "iconUrl", "");

        path = intent.getStringExtra("path");
        Log.e("zzzzzz",path);
        initView();
        mVideoplayer.TOOL_BAR_EXIST = false;
        mVideoplayer.setUp(path,
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, " ");

        mVideoplayer.widthRatio = 4;//播放比例
        mVideoplayer.heightRatio = 3;


    }

    private void initView() {
        mVideoplayer = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);

        mXiayibu = (Button) findViewById(R.id.xiayibu);
        mXiayibu.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        this.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.xiayibu:
                mPresenter.publishVideo(uid,path,iconUrl,token);
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_video;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void publishVideo(BaseBean baseBean) {
        Toast.makeText(VideoActivity.this,"发布视频成功",Toast.LENGTH_SHORT).show();
        Log.e("zzzzz", baseBean.getMsg());
        Intent intent = new Intent(VideoActivity.this, DuanSuccessActivity.class);
        intent.putExtra("msg", baseBean.getMsg());
        startActivity(intent);
    }
}
