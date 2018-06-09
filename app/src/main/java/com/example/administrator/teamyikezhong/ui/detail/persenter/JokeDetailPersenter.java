package com.example.administrator.teamyikezhong.ui.detail.persenter;

import com.example.administrator.teamyikezhong.bean.JokeDetailBean;
import com.example.administrator.teamyikezhong.net.JokeDetailApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;
import com.example.administrator.teamyikezhong.ui.detail.contract.JokeDetailContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public class JokeDetailPersenter extends BasePersenter<JokeDetailContract.View>implements JokeDetailContract.Persenter {
    private JokeDetailApi jokeDetailApi;
     @Inject
    public JokeDetailPersenter(JokeDetailApi jokeDetailApi) {
        this.jokeDetailApi = jokeDetailApi;
    }


    @Override
    public void getJokeDetail(String jid) {
        jokeDetailApi.getJokeDetail(jid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JokeDetailBean>() {
                    @Override
                    public void accept(JokeDetailBean jokeDetailBean) throws Exception {
                        mView.onJokeDetailSuccess(jokeDetailBean);
                    }
                });
    }
}
