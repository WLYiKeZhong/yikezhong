package com.example.administrator.teamyikezhong.ui.detail.persenter;

import com.example.administrator.teamyikezhong.bean.DetailBean;
import com.example.administrator.teamyikezhong.net.DetailApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.detail.contract.DetailContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public class DetailPersenter extends BasePersenter<DetailContract.View>implements DetailContract.Persenter {
    private DetailApi detailApi;
     @Inject
    public DetailPersenter(DetailApi detailApi) {
        this.detailApi = detailApi;
    }

    @Override
    public void getVideoDetail(String wid) {
   detailApi.getVideoDetai(wid)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(new Consumer<DetailBean>() {
               @Override
               public void accept(DetailBean detailBean) throws Exception {
                   mView.onDetailSuccess(detailBean);
               }
           });
    }
}
