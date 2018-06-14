package com.example.administrator.teamyikezhong.ui.tuijian.persenter;

import com.example.administrator.teamyikezhong.bean.ParsieBean;
import com.example.administrator.teamyikezhong.net.ShouCangApi;
import com.example.administrator.teamyikezhong.net.TongYongApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.tuijian.contract.TongYongContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class TongYongPersenter extends BasePersenter<TongYongContract.View> implements  TongYongContract.Persenter  {
    private TongYongApi tongYongApi;
    private ShouCangApi shouCangApi;
          @Inject
    public TongYongPersenter(TongYongApi tongYongApi, ShouCangApi shouCangApi) {
        this.tongYongApi = tongYongApi;
              this.shouCangApi = shouCangApi;
    }
    @Override
    public void getPraise(String uid, String wid, String token) {
        tongYongApi.getTongYong(uid,wid,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ParsieBean>() {
                    @Override
                    public void accept(ParsieBean parsieBean) throws Exception {
                         mView.onTongyongSuccess(parsieBean);
                    }
                });
    }

    @Override
    public void addFavorite(String uid, String wid, String token) {
         shouCangApi.addFavorite(uid,wid,token)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<ParsieBean>() {
                     @Override
                     public void accept(ParsieBean parsieBean) throws Exception {
                         mView.onShouCangSuccess(parsieBean);
                     }
                 });
    }

    @Override
    public void cancelFavorite(String uid, String wid, String token) {

        shouCangApi.cancelFavorite(uid,wid,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ParsieBean>() {
                    @Override
                    public void accept(ParsieBean parsieBean) throws Exception {
                        mView.onQuXiaoSuccess(parsieBean);
                    }
                });
    }
}
