package com.example.administrator.teamyikezhong.ui.tuijian.contract;

import com.example.administrator.teamyikezhong.bean.ParsieBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface TongYongContract {
    interface  View extends  BaseContract.BaseView{
        void  onTongyongSuccess(ParsieBean parsieBean);
        void  onShouCangSuccess(ParsieBean parsieBean);
        void  onQuXiaoSuccess(ParsieBean parsieBean);


    }
    interface  Persenter extends BaseContract.BasePersenter<View>{
        void  getPraise(String uid,String wid,String token);
        void  addFavorite(String uid,String wid,String token);
        void  cancelFavorite(String uid,String wid,String token);

    }
}
