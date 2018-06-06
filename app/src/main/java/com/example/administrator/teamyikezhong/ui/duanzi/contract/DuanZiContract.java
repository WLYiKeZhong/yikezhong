package com.example.administrator.teamyikezhong.ui.duanzi.contract;

import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface DuanZiContract {
    interface  View extends  BaseContract.BaseView{

        void   onJokesSuccess(DuanZiBean duanZiBean);


    }
    interface  Persenter extends BaseContract.BasePersenter<View>{

          void  getJokes(  String page,String token);
    }
}
