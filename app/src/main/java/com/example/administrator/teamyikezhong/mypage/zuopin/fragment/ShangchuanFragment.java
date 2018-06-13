package com.example.administrator.teamyikezhong.mypage.zuopin.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.teamyikezhong.R;

/**
 * Created by Administrator on 2018/6/10 0010.
 */

public class ShangchuanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shangchuan_item, null);
        return view;
    }
}
