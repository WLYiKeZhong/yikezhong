package com.example.administrator.teamyikezhong.mypage.login.reg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.activity.MainActivity;


import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;

public class RegActivity extends BaseActivity<RegPresenter> implements View.OnClickListener,RegContract.View {

    private ImageView mImg2;
    /**
     * 忘记密码？
     */
    private TextView mTvZhuce;
    private ImageView mImg1;
    /**
     * 请输入手机号
     */
    private EditText mName;
    /**
     * 请输入密码
     */
    private EditText mPass;
    /**
     * 注册
     */
    private Button mBtnTijiao;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mImg2 = (ImageView) findViewById(R.id.img2);
        mTvZhuce = (TextView) findViewById(R.id.tv_wangji);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mName = (EditText) findViewById(R.id.et_name);
        mPass = (EditText) findViewById(R.id.et_pass);
        mBtnTijiao = (Button) findViewById(R.id.btn_zhuce);
        mBtnTijiao.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_zhuce:
                String mobile = mName.getText().toString();
                String password = mPass.getText().toString();
                mPresenter.reg(mobile, password);
                break;
            case R.id.tv_youke:
                Intent intent1 = new Intent(RegActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_reg;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void regSuccess() {
        Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
