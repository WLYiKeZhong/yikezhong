package com.example.administrator.teamyikezhong.ui.base;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface BaseContract {
    interface  BasePersenter<T extends BaseView> {
        void attchView(T view);

        void detachView();

    }
    interface  BaseView{
        void showLoading();

        void dismissLoading();
    }
}
