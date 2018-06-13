package com.example.administrator.teamyikezhong.mypage.fabu.duanzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;

public class DuanSuccessActivity extends AppCompatActivity {

    private TextView mTvSuccess;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duan_success);
        Intent intent = getIntent();
        msg = intent.getStringExtra("msg");
        initView();
    }

    private void initView() {
        mTvSuccess = (TextView) findViewById(R.id.tv_success);
        mTvSuccess.setText(msg);
    }
}
