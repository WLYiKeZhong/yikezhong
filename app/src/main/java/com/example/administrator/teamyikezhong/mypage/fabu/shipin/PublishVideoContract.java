package com.example.administrator.teamyikezhong.mypage.fabu.shipin;

import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/6/14 0014.
 */

public interface PublishVideoContract {
    interface View extends BaseContract.BaseView{
        void publishVideo(BaseBean baseBean);
    }

    interface Presenter extends BaseContract.BasePersenter<View>{
        void publishVideo(String uid, String filePath,String coverFile,String token);
    }
}
