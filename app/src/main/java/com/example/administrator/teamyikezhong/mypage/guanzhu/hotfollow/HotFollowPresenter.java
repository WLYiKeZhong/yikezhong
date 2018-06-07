package com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow;

import com.example.administrator.teamyikezhong.bean.HotFollowBean;
import com.example.administrator.teamyikezhong.net.UsersFollowApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class HotFollowPresenter extends BasePersenter<HotFollowContract.view> implements HotFollowContract.presenter {
    UsersFollowApi usersFollowApi;
    @Inject
    public HotFollowPresenter(UsersFollowApi usersFollowApi) {
        this.usersFollowApi=usersFollowApi;
    }
    @Override
    public void getHotVideos(String page, String token) {
        usersFollowApi.getHotVideos(page, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HotFollowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotFollowBean hotFollowBean) {
                        if (mView!=null){
                            mView.getHotVideos(hotFollowBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
