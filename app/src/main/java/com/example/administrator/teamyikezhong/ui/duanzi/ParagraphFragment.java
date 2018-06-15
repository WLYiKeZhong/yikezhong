package com.example.administrator.teamyikezhong.ui.duanzi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.example.administrator.teamyikezhong.ui.base.BaseFragment;
import com.example.administrator.teamyikezhong.ui.detail.DuanZiDetailActivity;
import com.example.administrator.teamyikezhong.ui.duanzi.adapter.MyDuanZiRCAdapter;
import com.example.administrator.teamyikezhong.ui.duanzi.contract.DuanZiContract;
import com.example.administrator.teamyikezhong.ui.duanzi.persenter.DuaiZiPersenter;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class ParagraphFragment extends BaseFragment<DuaiZiPersenter> implements DuanZiContract.View {
    int page = 1;
    // String token="9BBCB950B0FBE903DB17C5EC71D74340";
    String token;
    ProgressDialog progressDialog;
    private static final String TAG = "ParagraphFragment";
    private XRecyclerView xrecy;
    private List<DuanZiBean.DataBean> list = new ArrayList<>();
    private MyDuanZiRCAdapter myDuanZiRCAdapter;
    private View view;

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

    public void initData(int page) {

        token = String.valueOf(SharedPreferencesUtils.getParam(getActivity(), "token", ""));


        mPersenter.getJokes(String.valueOf(page), token);
        xrecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        showProgressDialog("", "正在加载......");

    }

    @Override
    public void initView(View view) {
        xrecy = view.findViewById(R.id.xrecy);
        initData(page);
        xrecy.setLoadingMoreEnabled(true);
        xrecy.setPullRefreshEnabled(true);
        //刷新数据
        xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
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


    @Override
    public void onJokesSuccess(DuanZiBean duanZiBean) {
        xrecy.loadMoreComplete();

        final List<DuanZiBean.DataBean> data = duanZiBean.getData();
        Log.d(TAG, "Chenggong: ------------" + data);
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i));
        }
        myDuanZiRCAdapter = new MyDuanZiRCAdapter(getActivity(), list);
        xrecy.setAdapter(myDuanZiRCAdapter);
        myDuanZiRCAdapter.notifyDataSetChanged();

        //跳转详情
        myDuanZiRCAdapter.onVideosItemLintenr(new OnItemLinter() {
            @Override
            public void onItemClick(int postion) {
                Intent intent = new Intent(getActivity(), DuanZiDetailActivity.class);
                intent.putExtra("jid", data.get(postion).getJid());
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(int postion) {

            }

        });

        hideProgressDialog();
    }
}
