package com.example.administrator.teamyikezhong.mypage.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;

public class LoginActivity extends AppCompatActivity {

    private ImageView mImg;
    private ImageView mQq;
    private ImageView mWeixin;
    private LinearLayout mLl;
    /**
     * 其他登陆方式
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mQq = (ImageView) findViewById(R.id.qq);
        mWeixin = (ImageView) findViewById(R.id.weixin);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LoginRerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
