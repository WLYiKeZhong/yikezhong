package com.example.administrator.teamyikezhong.ui.videos.contract;

import com.example.administrator.teamyikezhong.bean.VideosNearBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by 兰昊琼 on 2018/6/7.
 */

public interface VideosFuJinContract {
    interface  View extends BaseContract.BaseView{
        void  onNearVideosSuccess(VideosNearBean videosNearBean);
    }
    interface  Persenter extends  BaseContract.BasePersenter<View>{
        void  getNearVideos(String page, String token);
    }
}
