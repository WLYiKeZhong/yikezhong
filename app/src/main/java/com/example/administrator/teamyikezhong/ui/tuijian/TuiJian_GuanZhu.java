package com.example.administrator.teamyikezhong.ui.tuijian;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.bean.ParsieBean;
import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.inter.OnVideoItemLintenr;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.tuijian.adapter.VideosAdapter;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.RecommendRenMenContract;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.TongYongContract;
import com.example.administrator.teamyikezhong.ui.tuijian.persenter.RenMenPersenter;
import com.example.administrator.teamyikezhong.ui.tuijian.persenter.TongYongPersenter;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class TuiJian_GuanZhu extends BaseFragment<RenMenPersenter> implements RecommendRenMenContract.View,TongYongContract.View {

    private RecyclerView guanZhurecyView;
    TongYongPersenter mPersenters;
    @Override
    public int getContentLayout() {
        return R.layout.tuijian_guanzhu_fragment;
    }

    @Override
    public void inject() {
       DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        guanZhurecyView = view.findViewById(R.id.guanZhurecyView);
        initVideos();


    }
    public void initVideos() {
        String uid = String.valueOf(SharedPreferencesUtils.getParam(getActivity(), "uid", ""));


        //String uid = "10206";

        String type = "1";
        String page = "1";

        mPersenter.getVideos(uid, type, page);
    }
    @Override
    public void onAdSuccess(AdBean adBean) {

    }

    @Override
    public void onVideosSuccess(VideosBean videosBean) {
        Log.d("videos", videosBean.getMsg());

        VideosAdapter videosAdapter = new VideosAdapter(mPersenters,getActivity(), videosBean);
        guanZhurecyView.setAdapter(videosAdapter);
        guanZhurecyView.setLayoutManager(new LinearLayoutManager(getActivity()));
        videosAdapter.onVideosItemLintenr(new OnVideoItemLintenr() {

            @Override
            public void onVideoItemClick(View view, int postion) {
                Toast.makeText(getActivity(),"关注开始分享",Toast.LENGTH_SHORT).show();

                UMImage image = new UMImage(getActivity(), "http://img.zcool" +
                        ".cn/community/01d881579dc3620000018c1b430c4b.JPG@3000w_1l_2o_100sh.jpg");//网络图片

                new ShareAction(getActivity()).withMedia(image).setDisplayList
                        (SHARE_MEDIA.WEIXIN, SHARE_MEDIA
                                        .WEIXIN_CIRCLE,
                                SHARE_MEDIA.QQ,
                                SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();
            }
        });
    }
    /**
     * 分享
     */
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(getActivity(),"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(getActivity(),"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(getActivity(),"取消了",Toast.LENGTH_LONG).show();

        }
    };
    @Override
    public void onTongyongSuccess(ParsieBean parsieBean) {
        int code = Integer.parseInt(parsieBean.getCode());
        if (code==0){
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onShouCangSuccess(ParsieBean parsieBean) {
        int code = Integer.parseInt(parsieBean.getCode());
        if (code==0){

            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onQuXiaoSuccess(ParsieBean parsieBean) {
        int code = Integer.parseInt(parsieBean.getCode());
        if (code==0){

            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(),parsieBean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }
}
