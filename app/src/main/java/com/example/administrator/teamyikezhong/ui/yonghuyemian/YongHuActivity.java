package com.example.administrator.teamyikezhong.ui.yonghuyemian;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.ui.duanzi.contract.DuanZiContract;
import com.example.administrator.teamyikezhong.ui.duanzi.persenter.DuaiZiPersenter;
import com.example.administrator.teamyikezhong.ui.yonghuyemian.adapyter.adapter.MeAdapter;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.List;

public class YongHuActivity extends BaseActivity<DuaiZiPersenter> implements DuanZiContract.View, View.OnClickListener {

    private ImageView mImageView;
    private LinearLayout linearBian;
    private ImageView mImagFan;

    private SimpleDraweeView mCircleImageView;
    /**
     * + 关注
     */
    private Button mButtonGuan;
    private ImageView mImageDian;
    String page="1";
    /**
     * 17
     */

    private TextView mDianNum;
    private RecyclerView mRecyView;
    private GoodView goodView;
    private List<DuanZiBean.DataBean> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_yong_hu);
        initView();
        goodView = new GoodView(this);

        String token= String.valueOf(SharedPreferencesUtils.getParam(YongHuActivity.this,"token",""));
        mPresenter.getJokes(page,token);
    }


    @Override
    public int getContentLayout() {
        return R.layout.activity_yong_hu;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImagFan = (ImageView) findViewById(R.id.imagFan);
        mImagFan.setOnClickListener(this);
        mCircleImageView = (SimpleDraweeView) findViewById(R.id.circleImageView);
        mButtonGuan = (Button) findViewById(R.id.buttonGuan);
        mButtonGuan.setOnClickListener(this);
        mImageDian = (ImageView) findViewById(R.id.imageDian);
        linearBian =  findViewById(R.id.linearBian);

        linearBian.setOnClickListener(this);
        mDianNum = (TextView) findViewById(R.id.dianNum);
        mRecyView = (RecyclerView) findViewById(R.id.recyView);

    }
/**
 * 点击事件

 */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imagFan:
                finish();
                break;
            case R.id.buttonGuan:

                break;
            case R.id.linearBian:

                goodView.setImage(getResources().getDrawable(R.drawable.dianzan2));
                goodView.show(v);
               /* int num=17;
                mDianNum.setText(num);*/
                break;
        }
    }

    @Override
    public void onJokesSuccess(DuanZiBean duanZiBean) {
        data = duanZiBean.getData();
        MeAdapter meAdapter=new MeAdapter(YongHuActivity.this, data);
        mRecyView.setAdapter(meAdapter);
        mRecyView.setLayoutManager(new LinearLayoutManager(YongHuActivity.this));
    }
}
