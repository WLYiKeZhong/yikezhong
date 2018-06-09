package com.example.administrator.teamyikezhong.mypage.collection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.MyCollectionBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.collection.adapter.CollectionAdapter;
import com.example.administrator.teamyikezhong.mypage.guanzhu.MyFollowActivity;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

import java.util.List;

public class CollectionActivity extends BaseActivity<CollectionPresenter> implements View.OnClickListener,CollectionContract.view {

    private ImageView mImg;
    /**
     * 返回
     */
    private TextView mFanhui;
    /**
     * 删除
     */
    private TextView mShanchu;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mShanchu = (TextView) findViewById(R.id.shanchu);
        mShanchu.setOnClickListener(this);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        String uid = (String) SharedPreferencesUtils.getParam(CollectionActivity.this, "uid", "-1");
        String token = (String) SharedPreferencesUtils.getParam(CollectionActivity.this, "token", "");

        if ("-1".equals(uid)){
            Intent intent = new Intent(CollectionActivity.this, LoginRerActivity.class);
            intent.putExtra("flay",3);
            startActivity(intent);
        }else {
            mPresenter.getFavorites(uid, token);
        }
        //mPresenter.getFavorites(uid,token);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
            case R.id.shanchu:

                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_collection;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void getFavorites(MyCollectionBean myCollectionBean) {
        Toast.makeText(CollectionActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
        List<MyCollectionBean.DataBean> data = myCollectionBean.getData();
        Log.e("zzzzzz",data.size()+"");
        CollectionAdapter adapter = new CollectionAdapter(CollectionActivity.this,data);
        mRv.setAdapter(adapter);
    }
}
