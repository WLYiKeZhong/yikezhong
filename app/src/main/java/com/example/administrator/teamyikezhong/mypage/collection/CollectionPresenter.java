package com.example.administrator.teamyikezhong.mypage.collection;

import com.example.administrator.teamyikezhong.bean.MyCollectionBean;
import com.example.administrator.teamyikezhong.net.UsersFollowApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class CollectionPresenter extends BasePersenter<CollectionContract.view> implements CollectionContract.presenter{
    UsersFollowApi usersFollowApi;
    @Inject
    public CollectionPresenter( UsersFollowApi usersFollowApi) {
        this.usersFollowApi=usersFollowApi;
    }
    @Override
    public void getFavorites(String uid,String token) {
        usersFollowApi.getFavorites(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MyCollectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyCollectionBean myCollectionBean) {
                        if (mView!=null){
                            mView.getFavorites(myCollectionBean);
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
