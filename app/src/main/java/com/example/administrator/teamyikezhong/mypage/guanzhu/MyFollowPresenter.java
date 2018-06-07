package com.example.administrator.teamyikezhong.mypage.guanzhu;

import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.example.administrator.teamyikezhong.net.ProjectApi;
import com.example.administrator.teamyikezhong.net.UsersFollowApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class MyFollowPresenter extends BasePersenter<MyFollowContract.view> implements MyFollowContract.presenter {
    UsersFollowApi usersFollowApi;
    @Inject
    public MyFollowPresenter( UsersFollowApi usersFollowApi) {
        this.usersFollowApi=usersFollowApi;
    }
    @Override
    public void getFollowUsers(String uid, String token) {
        usersFollowApi.getFollowUsers(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FollowUsersBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FollowUsersBean followUsersBean) {
                        if (mView!=null){
                            mView.getFollowUsers(followUsersBean);
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
