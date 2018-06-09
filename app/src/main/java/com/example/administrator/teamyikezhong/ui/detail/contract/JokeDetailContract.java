package com.example.administrator.teamyikezhong.ui.detail.contract;

import com.example.administrator.teamyikezhong.bean.JokeDetailBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public interface JokeDetailContract {
    interface  View extends BaseContract.BaseView{
        void onJokeDetailSuccess(JokeDetailBean jokeDetailBean);
    }
    interface  Persenter extends  BaseContract.BasePersenter<View>{
        void  getJokeDetail(String jid);
    }
}
