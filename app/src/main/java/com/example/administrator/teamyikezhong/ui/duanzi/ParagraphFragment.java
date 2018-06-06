package com.example.administrator.teamyikezhong.ui.duanzi;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.duanzi.adapter.MyDuanZiRCAdapter;
import com.example.administrator.teamyikezhong.ui.duanzi.contract.DuanZiContract;
import com.example.administrator.teamyikezhong.ui.duanzi.persenter.DuaiZiPersenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class ParagraphFragment extends BaseFragment<DuaiZiPersenter> implements  DuanZiContract.View{
    int page=1;
    String token="9BBCB950B0FBE903DB17C5EC71D74340";
    ProgressDialog progressDialog;
    private static final String TAG = "ParagraphFragment";
    private XRecyclerView xrecy;
  private  List<DuanZiBean.DataBean> list=new ArrayList<>();
    private MyDuanZiRCAdapter myDuanZiRCAdapter;

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
public void  initData(int page){

    //token = CommonUtils.getString("token");



    mPersenter.getJokes(String.valueOf(page), token);
    xrecy.setLayoutManager(new LinearLayoutManager(getActivity()));
    showProgressDialog("提示", "正在加载......");

}
    @Override
    public void initView(View view) {
        xrecy = view.findViewById(R.id.xrecy);
        initData( page);
        xrecy.setLoadingMoreEnabled(true);
        xrecy.setPullRefreshEnabled(true);
        //刷新数据
        xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                initData(page);
                xrecy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
               page++;
               initData(page);

            }
        });
    }

    @Override
    public void onJokesSuccess(DuanZiBean duanZiBean) {
    xrecy.loadMoreComplete();

        List<DuanZiBean.DataBean> data = duanZiBean.getData();
        Log.d(TAG, "Chenggong: ------------"+data);
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i));
        }
        myDuanZiRCAdapter = new MyDuanZiRCAdapter(getActivity(), list);
        xrecy.setAdapter(myDuanZiRCAdapter);
        myDuanZiRCAdapter.notifyDataSetChanged();

        hideProgressDialog();
    }

    private void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            //    progressDialog.hide();
        }
    }
    public void showProgressDialog(String title, String message) {

        if (progressDialog == null) {

            progressDialog = ProgressDialog.show(getActivity(), title,
                    message, true, false);


        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);

        }
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

}
