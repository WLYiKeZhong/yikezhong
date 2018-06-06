package com.example.administrator.teamyikezhong.component;

import com.example.administrator.teamyikezhong.ui.duanzi.ParagraphFragment;
import com.example.administrator.teamyikezhong.module.HttpModule;
import com.example.administrator.teamyikezhong.mypage.login.reg.RegActivity;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.ui.tuijian.TuiJian_GuanZhu;
import com.example.administrator.teamyikezhong.ui.tuijian.TuiJian_ReMen;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(ParagraphFragment paragraphFragment);

    void inject(TuiJian_GuanZhu tuiJian_guanZhu);
    void inject(TuiJian_ReMen tuiJian_reMen);
    void inject(RegActivity regActivity);
    void inject(LoginRerActivity loginRerActivity);
}
