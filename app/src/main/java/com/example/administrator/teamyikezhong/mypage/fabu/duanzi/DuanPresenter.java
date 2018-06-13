package com.example.administrator.teamyikezhong.mypage.fabu.duanzi;

import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.net.UsersFollowApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/10 0010.
 */

public class DuanPresenter extends BasePersenter<DuanContract.view> implements DuanContract.presenter {
    UsersFollowApi usersFollowApi;
    @Inject
    public DuanPresenter( UsersFollowApi usersFollowApi) {
        this.usersFollowApi=usersFollowApi;
    }
    @Override
    public void publishJoke(String uid, String token, String content) {
        usersFollowApi.publishJoke(uid, token, content)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        if (mView!=null) {
                            mView.publishJoke(baseBean);
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
