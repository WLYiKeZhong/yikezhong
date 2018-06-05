package com.example.administrator.teamyikezhong.ui.tuijian;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.RecommendRenMenContract;
import com.example.administrator.teamyikezhong.ui.tuijian.persenter.RenMenPersenter;
import com.example.administrator.teamyikezhong.utils.MyBanner;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class TuiJian_ReMen extends BaseFragment<RenMenPersenter> implements RecommendRenMenContract.View {
    private View view;
    private Banner mReMenbanner;
    private RecyclerView mRMView;

    @Override
    public int getContentLayout() {
        return R.layout.tuijian_renmen_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {

        mReMenbanner = (Banner) view.findViewById(R.id.reMenbanner);
        mRMView = (RecyclerView) view.findViewById(R.id.rM_View);
        mPersenter.getAd();
    }

    /**
     * 轮播图
     * @param adBean
     */
    @Override
    public void onAdSuccess(AdBean adBean) {
        List<AdBean.DataBean> data = adBean.getData();
         List<String> imageList=new ArrayList<>();
         for (int i=0; i<data.size();i++){
             String icon = data.get(i).getIcon();
             imageList.add(icon);
         }
         mReMenbanner.setImageLoader(new MyBanner());
         mReMenbanner.setImages(imageList);
         mReMenbanner.start();
    }


}
