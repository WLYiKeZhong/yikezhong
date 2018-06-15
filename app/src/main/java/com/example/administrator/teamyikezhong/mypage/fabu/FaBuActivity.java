package com.example.administrator.teamyikezhong.mypage.fabu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.mypage.fabu.duanzi.FaBuDuanActivity;
import com.example.administrator.teamyikezhong.mypage.fabu.shipin.VideoActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;

import javax.inject.Inject;

public class FaBuActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mShipin;
    private SimpleDraweeView mDuanzi;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_bu);
        initView();
    }

    private void initView() {
        mShipin = (SimpleDraweeView) findViewById(R.id.shipin);
        mShipin.setOnClickListener(this);
        mDuanzi = (SimpleDraweeView) findViewById(R.id.duanzi);
        mDuanzi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.shipin:
               /* Intent intent1 = new Intent(FaBuActivity.this,VideoActivity.class);
                startActivity(intent1);*/
                // 激活系统的照相机进行录像
                Intent intent = new Intent();
                intent.setAction("android.media.action.VIDEO_CAPTURE");
                intent.addCategory("android.intent.category.DEFAULT");

                // 保存录像到指定的路径
                File file = new File("/sdcard/video.3pg");
                Uri uri = Uri.fromFile(file);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                path = file.getPath();
                startActivityForResult(intent, 0);
                break;
            case R.id.duanzi:
                Intent intent1 = new Intent(FaBuActivity.this, FaBuDuanActivity.class);
                startActivity(intent1);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(this, "调用照相机完毕", Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);

        Intent intent = new Intent(FaBuActivity.this,VideoActivity.class);
        intent.putExtra("path",path);
        startActivity(intent);



    }
}
