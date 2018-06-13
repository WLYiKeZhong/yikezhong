package com.example.administrator.teamyikezhong.mypage.fabu.duanzi;

import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.bean.FollowUsersBean;
import com.example.administrator.teamyikezhong.mypage.guanzhu.MyFollowContract;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/6/10 0010.
 */

public interface DuanContract {
    interface view extends BaseContract.BaseView{
        void publishJoke(BaseBean baseBean);

    }
    interface presenter extends BaseContract.BasePersenter<view> {
        void publishJoke(String uid, String token,String content);

    }
}
