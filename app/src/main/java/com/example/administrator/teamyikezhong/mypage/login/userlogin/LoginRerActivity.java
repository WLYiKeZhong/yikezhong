package com.example.administrator.teamyikezhong.mypage.login.userlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.activity.MainActivity;
import com.example.administrator.teamyikezhong.bean.UserBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.collection.CollectionActivity;
import com.example.administrator.teamyikezhong.mypage.fabu.duanzi.FaBuDuanActivity;
import com.example.administrator.teamyikezhong.mypage.friends.FriendsActivity;
import com.example.administrator.teamyikezhong.mypage.guanzhu.MyFollowActivity;
import com.example.administrator.teamyikezhong.mypage.login.reg.RegActivity;
import com.example.administrator.teamyikezhong.mypage.login.wangjipass.WjPassActivity;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

public class LoginRerActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.view {

    private ImageView mImg2;
    /**
     * 注册账号
     */
    private TextView mTvZhuce;
    private ImageView mImg1;
    private EditText mName;
    private EditText mPass;
    /**
     * 登陆
     */
    private Button mBtnTijiao;
    /**
     * 忘记密码
     */
    private TextView mTvWangjimima;
    /**
     * 游客登陆
     */
    private TextView mTvYouke;
    private int flay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        flay = intent.getIntExtra("flay",-1);
        initView();


    }

    private void initView() {
        mImg2 = (ImageView) findViewById(R.id.img2);
        mTvZhuce = (TextView) findViewById(R.id.tv_zhuce);
        mTvZhuce.setOnClickListener(this);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mBtnTijiao = (Button) findViewById(R.id.btn_tijiao);
        mBtnTijiao.setOnClickListener(this);
        mTvWangjimima = (TextView) findViewById(R.id.tv_wangjimima);
        mTvWangjimima.setOnClickListener(this);
        mTvYouke = (TextView) findViewById(R.id.tv_youke);
        mTvYouke.setOnClickListener(this);
        mImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_tijiao:
                String mobile = mName.getText().toString();
                String password = mPass.getText().toString();
                mPresenter.login(mobile, password);
                break;
            case R.id.tv_zhuce:
                Intent intent = new Intent(LoginRerActivity.this,RegActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_youke:

                finish();
                break;
            case R.id.tv_wangjimima:
                Intent intent1 = new Intent(LoginRerActivity.this, WjPassActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login_rer;
    }

    @Override
    public void inject() {
      DaggerHttpComponent.builder()
              .build()
              .inject(this);


    }

    @Override
    public void loginSuccess(UserBean userBean) {
        UserBean.DataBean data = userBean.getData();
        String mobile = data.getMobile();
        SharedPreferencesUtils.setParam(this, "uid", userBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(this, "name", userBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(this, "iconUrl", userBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(this, "token", userBean.getData().getToken() + "");

        if (flay==1){
            finish();
            Intent intent = new Intent(LoginRerActivity.this, MyFollowActivity.class);
            startActivity(intent);
        }else if (flay==2) {

            Intent intent = new Intent(LoginRerActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(flay==3){
            finish();
            Intent intent = new Intent(LoginRerActivity.this, CollectionActivity.class);
            startActivity(intent);
        }else  if(flay==4){
            finish();
            Intent intent = new Intent(LoginRerActivity.this, FaBuDuanActivity.class);
            startActivity(intent);
        }

    }
}
