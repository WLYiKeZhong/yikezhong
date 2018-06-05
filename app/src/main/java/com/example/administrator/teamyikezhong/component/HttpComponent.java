package com.example.administrator.teamyikezhong.component;

import com.example.administrator.teamyikezhong.module.HttpModule;
import com.example.administrator.teamyikezhong.ui.tuijian.TuiJian_ReMen;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {


    void inject(TuiJian_ReMen tuiJian_reMen);
}
