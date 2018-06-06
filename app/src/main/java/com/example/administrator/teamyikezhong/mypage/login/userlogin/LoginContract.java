package com.example.administrator.teamyikezhong.mypage.login.userlogin;


import com.example.administrator.teamyikezhong.bean.UserBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/5/8 0008.
 */

public interface LoginContract {
    interface view extends BaseContract.BaseView{
        void loginSuccess(UserBean userBean);
       /* String getName();
        String getPass();*/
    }
    interface presenter extends BaseContract.BasePersenter<view> {
        void login(String mobile, String password);

    }
}
