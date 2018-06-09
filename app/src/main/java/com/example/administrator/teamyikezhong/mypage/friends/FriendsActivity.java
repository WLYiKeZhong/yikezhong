package com.example.administrator.teamyikezhong.mypage.friends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.FriendsBean;
import com.example.administrator.teamyikezhong.bean.SouFriendsBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.collection.CollectionActivity;
import com.example.administrator.teamyikezhong.mypage.friends.adapter.FriendsAdapter;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendsActivity extends BaseActivity<FriendsPresenter> implements View.OnClickListener,FriendsContract.view {

    private ImageView mImg;
    /**
     * 返回
     */
    private TextView mFanhui;
    /**
     * 搜素id或者好友名
     */
    private EditText mSousuo;
    /**
     * 搜索
     */
    private TextView mTvSousuo;
    /**
     * 清空历史
     */
    private TextView mQingkong;
    private ListView mLv;
    private RecyclerView mRv;
    private SimpleAdapter adapter;
    private List<HashMap<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();


    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mSousuo = (EditText) findViewById(R.id.sousuo);
        mTvSousuo = (TextView) findViewById(R.id.tv_sousuo);
        mTvSousuo.setOnClickListener(this);
        mQingkong = (TextView) findViewById(R.id.qingkong);
        mQingkong.setOnClickListener(this);
        mLv = (ListView) findViewById(R.id.lv);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        String uid = (String) SharedPreferencesUtils.getParam(FriendsActivity.this, "uid", "-1");
        String token = (String) SharedPreferencesUtils.getParam(FriendsActivity.this, "token", "");

       /* if ("-1".equals(uid)){
            Intent intent = new Intent(FriendsActivity.this, LoginRerActivity.class);
            intent.putExtra("flay",4);
            startActivity(intent);
        }else {*/
            mPresenter.randomFriends();
       // }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                fileList();
                break;
            case R.id.tv_sousuo:
                String trim = mSousuo.getText().toString().trim();
                mPresenter.searchFriends(trim);
                break;
            case R.id.qingkong:
                list.clear();
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_friends;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void randomFriends(FriendsBean friendsBean) {
        Toast.makeText(FriendsActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
        List<FriendsBean.DataBean> data = friendsBean.getData();
        FriendsAdapter friendsAdapter = new FriendsAdapter(FriendsActivity.this,data);
        mRv.setAdapter(friendsAdapter);
    }

    @Override
    public void searchFriends(SouFriendsBean souFriendsBean) {

        List<SouFriendsBean.DataBean> data = souFriendsBean.getData();

// 1创建数据
        list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getMobile()!=null) {
                map.put("name", data.get(i).getMobile());
            }
            if (data.get(i).getIcon()!=null) {
                map.put("icon", data.get(i).getIcon());
            }
          /*  map.put("name","收到货空间");
            map.put("icon",R.drawable.raw_1499947389);*/

        }
        list.add(map);
        // 2创建适配器
        adapter = new SimpleAdapter(this, list,
                R.layout.soufriend_item, new String[] { "name", "icon" },
                new int[] { R.id.tv_name, R.id.img });
// 3 填充
        mLv.setAdapter(adapter);

    }
}
