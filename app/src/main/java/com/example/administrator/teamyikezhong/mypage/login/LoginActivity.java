package com.example.administrator.teamyikezhong.mypage.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.activity.MainActivity;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {

    private ImageView mImg;
    private ImageView mQq;
    private ImageView mWeixin;
    private LinearLayout mLl;
    /**
     * 其他登陆方式
     */
    private TextView mTv;
    private final int two = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mQq = (ImageView) findViewById(R.id.qq);
        mQq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
            }
        });

        mWeixin = (ImageView) findViewById(R.id.weixin);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LoginRerActivity.class);
                intent.putExtra("flay",2);
                startActivity(intent);
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //分享或者登录的结果交给友盟处理
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();

            String name = data.get("name");
            String iconurl = data.get("iconurl");
            String uid = data.get("uid");

            SharedPreferencesUtils.setParam(LoginActivity.this, "name", name);
            SharedPreferencesUtils.setParam(LoginActivity.this, "iconUrl", iconurl);
            SharedPreferencesUtils.setParam(LoginActivity.this, "uid", uid);

           Intent intent = new Intent(LoginActivity.this,MainActivity.class);
         /*  intent.putExtra("name",name);

           intent.putExtra("iconUrl",iconurl);*/
           startActivity(intent);

          /*  Log.e("zzzzz",name+"   "+iconurl);
            Toast.makeText(LoginActivity.this, sb.toString(), Toast.LENGTH_LONG).show();

            //  mTv.setText(sb.toString());*/
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

}
