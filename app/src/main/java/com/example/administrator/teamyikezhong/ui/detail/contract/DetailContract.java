package com.example.administrator.teamyikezhong.ui.detail.contract;

import com.example.administrator.teamyikezhong.bean.DetailBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public interface DetailContract {
    interface  View extends BaseContract.BaseView{
        void onDetailSuccess(DetailBean detailBean);
    }
    interface  Persenter extends  BaseContract.BasePersenter<View>{
        void  getVideoDetail(String wid);
    }
}
