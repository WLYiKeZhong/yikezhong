package com.example.administrator.teamyikezhong.mypage.fabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.mypage.fabu.duanzi.FaBuDuanActivity;
import com.example.administrator.teamyikezhong.mypage.fabu.shipin.VideoActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import javax.inject.Inject;

public class FaBuActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mShipin;
    private SimpleDraweeView mDuanzi;

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
                Intent intent1 = new Intent(FaBuActivity.this,VideoActivity.class);
                startActivity(intent1);
                break;
            case R.id.duanzi:
                Intent intent = new Intent(FaBuActivity.this, FaBuDuanActivity.class);
                startActivity(intent);
                break;
        }
    }
}
