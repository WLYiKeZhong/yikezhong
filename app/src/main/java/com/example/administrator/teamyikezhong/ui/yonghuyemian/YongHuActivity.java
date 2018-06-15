package com.example.administrator.teamyikezhong.ui.yonghuyemian;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.DuanZiBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.ui.duanzi.contract.DuanZiContract;
import com.example.administrator.teamyikezhong.ui.duanzi.persenter.DuaiZiPersenter;
import com.example.administrator.teamyikezhong.ui.yonghuyemian.adapyter.adapter.MeAdapter;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.List;

public class YongHuActivity extends BaseActivity<DuaiZiPersenter> implements DuanZiContract.View, View.OnClickListener {

    private ImageView mImageView;
    private LinearLayout linearBian;
    private ImageView mImagFan;

    private SimpleDraweeView mCircleImageView;
    /**
     * + 关注
     */
    private TextView  mButtonGuan;
    private ImageView fenxiang;
    private ImageView mImageDian;

    String page="1";
    /**
     * 17
     */
    int num;
    private TextView mDianNum;
    private RecyclerView mRecyView;
    private GoodView goodView;
    private List<DuanZiBean.DataBean> data=new ArrayList<>();
  private  boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_yong_hu);
        initView();
        initData();
        goodView = new GoodView(this);


    }


    @Override
    public int getContentLayout() {
        return R.layout.activity_yong_hu;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImagFan = (ImageView) findViewById(R.id.imagFan);
        mImagFan.setOnClickListener(this);
        mCircleImageView = (SimpleDraweeView) findViewById(R.id.circleImageView);
        mButtonGuan = (TextView) findViewById(R.id.buttonGuan);
        mButtonGuan.setOnClickListener(this);
        mImageDian = (ImageView) findViewById(R.id.imageDian);
        fenxiang = (ImageView) findViewById(R.id.fenxiang);
        fenxiang.setOnClickListener(this);

        linearBian =  findViewById(R.id.linearBian);

        linearBian.setOnClickListener(this);
        mDianNum = (TextView) findViewById(R.id.dianNum);
        mRecyView = (RecyclerView) findViewById(R.id.recyView);

    }
    public void  initData(){
        String token = String.valueOf(SharedPreferencesUtils.getParam(YongHuActivity.this, "token", ""));
   mPresenter.getJokes(page,token);

    }
/**
 * 点击事件

 */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imagFan:
                finish();
                break;
            case R.id.buttonGuan:
               if (flag){
                   flag =false;
                   mButtonGuan.setBackgroundColor(Color.GRAY);
                   mButtonGuan.setText("+关注");
               }else {
                    flag=true;
                   mButtonGuan.setBackgroundColor(Color.GREEN);
                   mButtonGuan.setText("已关注");
               }

                break;
            case R.id.linearBian:
                if (num==18){
                    mDianNum.setText("18");
                    linearBian.setBackgroundColor(Color.GREEN);
                }else {
                    mDianNum.setText("19");
                    linearBian.setBackgroundColor(Color.YELLOW);

                }

                goodView.setImage(getResources().getDrawable(R.drawable.dianzan2));
                goodView.show(v);


                break;
            case  R.id.fenxiang:


                UMImage image = new UMImage(YongHuActivity.this, "http://img.zcool" +
                        ".cn/community/01d881579dc3620000018c1b430c4b.JPG@3000w_1l_2o_100sh.jpg");//网络图片

                new ShareAction(YongHuActivity.this).withMedia(image).setDisplayList
                        (SHARE_MEDIA.WEIXIN, SHARE_MEDIA
                                        .WEIXIN_CIRCLE,
                                SHARE_MEDIA.QQ,
                                SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();


//                Intent textIntent = new Intent(Intent.ACTION_SEND);
//                textIntent.setType("text/plain");
//                textIntent.putExtra(Intent.EXTRA_TEXT, "这是一段分享的文字");
//                startActivity(Intent.createChooser(textIntent, "分享"));
                break;
        }
    }

    @Override
    public void onJokesSuccess(DuanZiBean duanZiBean) {
        data = duanZiBean.getData();
        MeAdapter meAdapter=new MeAdapter(YongHuActivity.this, data);
        mRecyView.setAdapter(meAdapter);
        mRecyView.setLayoutManager(new LinearLayoutManager(YongHuActivity.this));
    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(YongHuActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(YongHuActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(YongHuActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };


}
