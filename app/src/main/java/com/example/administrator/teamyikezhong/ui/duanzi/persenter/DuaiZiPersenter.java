package com.example.administrator.teamyikezhong.ui.duanzi.persenter;

import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.net.DuanZiApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.duanzi.contract.DuanZiContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class DuaiZiPersenter extends BasePersenter<DuanZiContract.View> implements  DuanZiContract.Persenter  {

    private DuanZiApi duanZiApi;
          @Inject
    public DuaiZiPersenter( DuanZiApi duanZiApi) {
        this.duanZiApi = duanZiApi;

    }



    @Override
    public void getJokes(String page, String token) {
        duanZiApi.getJokes(page,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<DuanZiBean>() {
                   @Override
                   public void accept(DuanZiBean duanZiBean) throws Exception {
                       mView.onJokesSuccess(duanZiBean);
                   }
               });
    }
}
