package com.example.administrator.teamyikezhong.mypage.login.wangjipass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class WjPassActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private ImageView mWangjiFan;
    /**
     * 已有账号?
     */
    private TextView mWangjiYi;
    /**
     * 86+  |  请输入手机号
     */
    private EditText mWangjiZhang;
    /**
     * 获取验证码
     */
    private TextView mWangjiYan;
    /**
     * 请输入验证码
     */
    private EditText mWangjiYanzheng;
    /**
     * 下一步
     */
    private Button mWangjiBu;
    /**
     * 游客登录
     */
    private TextView mWangjiYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wj_pass);
        initView();

    }

    private void initView() {
        mWangjiFan =  findViewById(R.id.wangji2_fan);
        mWangjiYi = (TextView) findViewById(R.id.wangji_yi);
        mWangjiZhang = (EditText) findViewById(R.id.wangji_zhang);
        mWangjiYan = (TextView) findViewById(R.id.wangji_yan);
        mWangjiYan.setOnClickListener(this);
        mWangjiYanzheng = (EditText) findViewById(R.id.wangji_yanzheng);
        mWangjiBu = (Button) findViewById(R.id.wangji_bu);
        mWangjiBu.setOnClickListener(this);
        mWangjiYou = (TextView) findViewById(R.id.wangji_you);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.wangji_bu:
                String trim1 = mWangjiZhang.getText().toString().trim();
                String trim2 = mWangjiYanzheng.getText().toString().trim();
                submitCode("86",trim1,trim2);
              /*  Intent intent = new Intent(WjPassActivity.this,ShePassActivity.class);
                startActivity(intent);*/

                break;
            case R.id.wangji_yan:
                String trim = mWangjiZhang.getText().toString().trim();
                sendCode("86",trim);
                break;
        }
    }


    // 请求验证码，其中country表示国家代码，如“86”；phone表示手机号码，如“13800138000”
    public void sendCode(String country, String phone) {
        // 注册一个事件回调，用于处理发送验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理成功得到验证码的结果
                    // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                } else{
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.getVerificationCode(country, phone);
    }

    // 提交验证码，其中的code表示验证码，如“1357”
    public void submitCode(String country, String phone, String code) {
        // 注册一个事件回调，用于处理提交验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理验证成功的结果
                    String mZhang = mWangjiZhang.getText().toString().trim();

                    Intent intent = new Intent(WjPassActivity.this,ShePassActivity.class);
                    intent.putExtra("tel",mZhang);
                    startActivity(intent);


                } else{
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.submitVerificationCode(country, phone, code);
    }

    protected void onDestroy() {
        super.onDestroy();
        //用完回调要注销掉，否则可能会出现内存泄露
        SMSSDK.unregisterAllEventHandler();
    };

}
