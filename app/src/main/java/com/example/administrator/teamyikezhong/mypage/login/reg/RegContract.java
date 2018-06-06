package com.example.administrator.teamyikezhong.mypage.login.reg;


import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public interface RegContract {
    interface View extends BaseContract.BaseView {
        void regSuccess();
    }

    interface Presenter extends BaseContract.BasePersenter<View> {
        void reg(String mobile, String password);
    }
}
