package com.example.administrator.teamyikezhong.mypage.login.reg;



import com.example.administrator.teamyikezhong.bean.RegBean;
import com.example.administrator.teamyikezhong.net.ProjectApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class RegPresenter extends BasePersenter<RegContract.View> implements RegContract.Presenter{
    ProjectApi projectApi;
    @Inject
    public RegPresenter(ProjectApi projectApi) {
        this.projectApi=projectApi;
    }

    @Override
    public void reg(String mobile, String password) {
        projectApi.reg(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        mView.regSuccess();
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
