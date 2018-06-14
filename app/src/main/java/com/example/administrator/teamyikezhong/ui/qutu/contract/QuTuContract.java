package com.example.administrator.teamyikezhong.ui.qutu.contract;

import com.example.administrator.teamyikezhong.bean.VideosBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public interface QuTuContract {
    interface  View extends  BaseContract.BaseView{

        void   onVideosSuccess(VideosBean videosBean);


    }
    interface  Persenter extends BaseContract.BasePersenter<View>{

          void  getVideos(String uid, String type, String page);
    }
}
