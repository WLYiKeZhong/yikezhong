package com.example.administrator.teamyikezhong.mypage.login.wangjipass;

import com.example.administrator.teamyikezhong.bean.UpdatePassBean;
import com.example.administrator.teamyikezhong.bean.UserBean;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginContract;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/6/9 0009.
 */

public interface UpdatePassContract {
    interface view extends BaseContract.BaseView{
        void getPassSuccess(UpdatePassBean updatePassBean);

    }
    interface presenter extends BaseContract.BasePersenter<view> {
        void getPass(String mobile, String newPass);

    }
}
