package com.example.administrator.teamyikezhong.ui.tuijian.contract;

import com.example.administrator.teamyikezhong.bean.AdBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface RecommendRenMenContract {
    interface  View extends  BaseContract.BaseView{
        void  onAdSuccess(AdBean adBean);

    }
    interface  Persenter extends BaseContract.BasePersenter<View>{
          void  getAd();
    }
}
