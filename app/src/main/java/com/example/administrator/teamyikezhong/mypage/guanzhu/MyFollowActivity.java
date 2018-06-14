package com.example.administrator.teamyikezhong.mypage.guanzhu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.guanzhu.adapter.MyFollowAdapter;
import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.HotFollowActivity;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

import java.util.List;

public class MyFollowActivity extends BaseActivity<MyFollowPresenter> implements View.OnClickListener,MyFollowContract.view {

    private ImageView mImg;
    /**
     * 返回
     */
    private TextView mFanhui;
    /**
     * 热门关注
     */
    private TextView mRemen;
    private RecyclerView mRv;
    private final int one = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mRemen = (TextView) findViewById(R.id.remen);
        mRemen.setOnClickListener(this);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        String uid = (String) SharedPreferencesUtils.getParam(MyFollowActivity.this, "uid", "-1");
        String token = (String) SharedPreferencesUtils.getParam(MyFollowActivity.this, "token", "");
        if ("-1".equals(uid)){
            Intent intent = new Intent(MyFollowActivity.this, LoginRerActivity.class);
            intent.putExtra("flay",1);
            startActivity(intent);
        }else {
            mPresenter.getFollowUsers(uid, token);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
            case R.id.remen:

            Intent intent = new Intent(MyFollowActivity.this, HotFollowActivity.class);
            startActivity(intent);
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_my_follow;
    }

    @Override
    public void inject() {
       DaggerHttpComponent.builder()
               .build()
               .inject(this);

    }

    @Override
    public void getFollowUsers(FollowUsersBean followUsersBean) {
        Toast.makeText(MyFollowActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
        List<FollowUsersBean.DataBean> data = followUsersBean.getData();
        MyFollowAdapter adapter = new MyFollowAdapter(MyFollowActivity.this,data);
        mRv.setAdapter(adapter);

    }
}
