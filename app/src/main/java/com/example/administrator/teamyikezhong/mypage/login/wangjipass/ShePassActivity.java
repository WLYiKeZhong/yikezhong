package com.example.administrator.teamyikezhong.mypage.login.wangjipass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.UpdatePassBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;

public class ShePassActivity extends BaseActivity<UpdatePassPresenter> implements View.OnClickListener,UpdatePassContract.view {

    private ImageView mWangji2Fan;
    /**
     * 已有账号?
     */
    private TextView mWangji2Yi;
    /**
     * 输入大小写和数字,密码不能超过8位
     */
    private EditText mWangji2Mima;
    /**
     * 请再次输入密码
     */
    private EditText mWangji2Pwd;
    /**
     * 完成
     */
    private Button mWangji2Wan;
    /**
     * 游客登录
     */
    private TextView mWangji2You;
    private String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        tel = intent.getStringExtra("tel");

        initView();
    }

    private void initView() {
        mWangji2Fan = (ImageView) findViewById(R.id.wangji2_fan);
        mWangji2Yi = (TextView) findViewById(R.id.wangji2_yi);
        mWangji2Mima = (EditText) findViewById(R.id.wangji2_mima);
        mWangji2Pwd = (EditText) findViewById(R.id.wangji2_pwd);
        mWangji2Wan = (Button) findViewById(R.id.wangji2_wan);
        mWangji2Wan.setOnClickListener(this);
        mWangji2You = (TextView) findViewById(R.id.wangji2_you);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.wangji2_wan:
                String newpass = mWangji2Mima.getText().toString().trim();

                mPresenter.getPass(tel,newpass);


                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_she_pass;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void getPassSuccess(UpdatePassBean updatePassBean) {
        Toast.makeText(ShePassActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
        finish();
    }
}
