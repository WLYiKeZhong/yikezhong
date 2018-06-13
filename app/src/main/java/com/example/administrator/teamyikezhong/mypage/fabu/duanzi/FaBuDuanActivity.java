package com.example.administrator.teamyikezhong.mypage.fabu.duanzi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.guanzhu.MyFollowActivity;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

public class FaBuDuanActivity extends BaseActivity<DuanPresenter> implements View.OnClickListener,DuanContract.view {

    /**
     * 返回
     */
    private TextView mFanhui;
    /**
     * 发表
     */
    private TextView mFabiao;
    private EditText mEtCont;
    private ImageView mImgJia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mFabiao = (TextView) findViewById(R.id.fabiao);
        mFabiao.setOnClickListener(this);
        mEtCont = (EditText) findViewById(R.id.et_cont);
        mImgJia = (ImageView) findViewById(R.id.img_jia);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
            case R.id.fabiao:
                String trim = mEtCont.getText().toString().trim();

                String uid = (String) SharedPreferencesUtils.getParam(FaBuDuanActivity.this, "uid", "-1");
                String token = (String) SharedPreferencesUtils.getParam(FaBuDuanActivity.this, "token", "");
                if ("-1".equals(uid)){
                    Intent intent = new Intent(FaBuDuanActivity.this, LoginRerActivity.class);
                    intent.putExtra("flay",4);
                    startActivity(intent);
                }else {
                    mPresenter.publishJoke(uid, token,trim);
                }
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_fa_bu_duan;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void publishJoke(BaseBean baseBean) {
        Toast.makeText(FaBuDuanActivity.this,baseBean.getMsg(),Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(FaBuDuanActivity.this,DuanSuccessActivity.class);
        intent.putExtra("msg",baseBean.getMsg());
        startActivity(intent);

    }
}
