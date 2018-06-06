package com.example.administrator.teamyikezhong.ui.duanzi;

import android.util.Log;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;

import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.duanzi.contract.DuanZiContract;
import com.example.administrator.teamyikezhong.ui.duanzi.persenter.DuaiZiPersenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class ParagraphFragment extends BaseFragment<DuaiZiPersenter> implements  DuanZiContract.View{


    private XRecyclerView xrecy;

    @Override
    public int getContentLayout() {
        return R.layout.paragraphfragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        xrecy = view.findViewById(R.id.xrecy);
    }

    @Override
    public void onJokesSuccess(DuanZiBean duanZiBean) {
        Log.d("duanzi",duanZiBean.getMsg());
    }
}
