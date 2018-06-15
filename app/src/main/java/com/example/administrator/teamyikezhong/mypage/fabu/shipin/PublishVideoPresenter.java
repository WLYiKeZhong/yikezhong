package com.example.administrator.teamyikezhong.mypage.fabu.shipin;

import android.util.Log;

import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.net.UsersFollowApi;
import com.example.administrator.teamyikezhong.ui.base.BasePersenter;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/6/14 0014.
 */

public class PublishVideoPresenter extends BasePersenter<PublishVideoContract.View> implements PublishVideoContract.Presenter {
    UsersFollowApi usersFollowApi;
    @Inject
    public PublishVideoPresenter( UsersFollowApi usersFollowApi) {
        this.usersFollowApi=usersFollowApi;
    }
    @Override
    public void publishVideo(String uid, String filePath,String coverFile, String token) {

        int i = coverFile.lastIndexOf("/");
        String fileName = coverFile.substring(i+1);
        Log.e("zzzzzz",fileName);
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), new File(filePath));
        RequestBody file1 = RequestBody.create(MediaType.parse("application/octet-stream"), new File(coverFile));

        MediaType textType = MediaType.parse("text/plain");
        RequestBody u = RequestBody.create(textType, uid);
        RequestBody t = RequestBody.create(textType, token);
        MultipartBody.Part f = MultipartBody.Part.createFormData("videoFile", filePath, file);
        MultipartBody.Part c = MultipartBody.Part.createFormData("file1", coverFile, file1);



        usersFollowApi.publishVideo(u,f,c,t)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                    if (mView!=null){
                        mView.publishVideo(baseBean);
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
