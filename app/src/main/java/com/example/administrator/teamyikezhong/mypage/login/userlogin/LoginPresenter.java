package com.example.administrator.teamyikezhong.mypage.login.userlogin;

import android.util.Log;



import com.example.administrator.teamyikezhong.bean.UserBean;
import com.example.administrator.teamyikezhong.net.ProjectApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/8 0008.
 */

public class LoginPresenter extends BasePersenter<LoginContract.view> implements LoginContract.presenter {
    ProjectApi projectApi;
    @Inject
    public LoginPresenter(ProjectApi projectApi) {
        this.projectApi=projectApi;
    }

    @Override
    public void login(String mobile, String password) {
        projectApi.login(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                    mView.loginSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                       // Toast.makeText(LoginPresenter.this,"", Toast.LENGTH_SHORT).show();
                        Log.e("zzz","错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
