package com.example.administrator.teamyikezhong.ui.tuijian.persenter;

import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.net.AdApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.RecommendRenMenContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class RenMenPersenter extends BasePersenter<RecommendRenMenContract.View> implements  RecommendRenMenContract.Persenter  {
    private AdApi adApi;
          @Inject
    public RenMenPersenter(AdApi adApi) {
        this.adApi = adApi;
    }

    @Override
    public void getAd() {
     adApi.getAd()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Consumer<AdBean>() {
                 @Override
                 public void accept(AdBean adBean) throws Exception {
                     mView.onAdSuccess(adBean);
                 }
             });
    }
}
