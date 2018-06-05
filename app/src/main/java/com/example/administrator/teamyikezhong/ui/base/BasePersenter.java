package com.example.administrator.teamyikezhong.ui.base;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public class BasePersenter<T extends BaseContract.BaseView> implements  BaseContract.BasePersenter<T> {
  protected  T mView;
    @Override
    public void attchView(T view) {
        this.mView=view;
    }

    @Override
    public void detachView() {
         if (mView!=null){
             mView=null;
         }
    }
}
