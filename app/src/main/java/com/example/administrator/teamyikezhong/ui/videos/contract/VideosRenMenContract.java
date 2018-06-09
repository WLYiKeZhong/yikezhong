package com.example.administrator.teamyikezhong.ui.videos.contract;

import com.example.administrator.teamyikezhong.bean.HotVideosBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public interface VideosRenMenContract {
    interface  View extends BaseContract.BaseView{
        void  onHotVideosSuccess(HotVideosBean hotVideosBean);
    }
    interface  Persenter extends  BaseContract.BasePersenter<View>{
        void  getHotVideos(String page,String token);
    }
}
