package com.example.administrator.teamyikezhong.component;


import com.example.administrator.teamyikezhong.mypage.collection.CollectionActivity;
import com.example.administrator.teamyikezhong.mypage.fabu.duanzi.FaBuDuanActivity;
import com.example.administrator.teamyikezhong.mypage.friends.FriendsActivity;
import com.example.administrator.teamyikezhong.mypage.guanzhu.MyFollowActivity;

import com.example.administrator.teamyikezhong.mypage.guanzhu.hotfollow.fragment.HotFragment;
import com.example.administrator.teamyikezhong.ui.detail.DuanZiDetailActivity;
import com.example.administrator.teamyikezhong.ui.detail.VideosDeailActivity;
import com.example.administrator.teamyikezhong.mypage.login.wangjipass.ShePassActivity;
import com.example.administrator.teamyikezhong.ui.duanzi.ParagraphFragment;
import com.example.administrator.teamyikezhong.module.HttpModule;
import com.example.administrator.teamyikezhong.mypage.login.reg.RegActivity;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.ui.tuijian.TuiJian_GuanZhu;
import com.example.administrator.teamyikezhong.ui.tuijian.TuiJian_ReMen;
import com.example.administrator.teamyikezhong.ui.videos.VideosFuJin;
import com.example.administrator.teamyikezhong.ui.videos.VideosRenMen;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(ParagraphFragment paragraphFragment);
   void  inject(VideosRenMen videosRenMen);
    void inject(TuiJian_GuanZhu tuiJian_guanZhu);
    void inject(TuiJian_ReMen tuiJian_reMen);
    void inject(RegActivity regActivity);
    void inject(LoginRerActivity loginRerActivity);
    void inject(VideosFuJin videosFuJin);
   void  inject(VideosDeailActivity videosDeailActivity);
    void  inject(DuanZiDetailActivity duanZiDetailActivity);

    void inject(MyFollowActivity myFollowActivity);
    void inject(HotFragment hotFragment);
    void inject(CollectionActivity collectionActivity);
    void inject(FriendsActivity friendsActivity);
    void inject(ShePassActivity shePassActivity);
    void inject(FaBuDuanActivity faBuDuanActivity);


}
