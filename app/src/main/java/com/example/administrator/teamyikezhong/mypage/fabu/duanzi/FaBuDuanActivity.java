package com.example.administrator.teamyikezhong.mypage.fabu.duanzi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.bean.BaseBean;
import com.example.administrator.teamyikezhong.component.DaggerHttpComponent;
import com.example.administrator.teamyikezhong.mypage.login.userlogin.LoginRerActivity;
import com.example.administrator.teamyikezhong.ui.base.BaseActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FaBuDuanActivity extends BaseActivity<DuanPresenter> implements View.OnClickListener, DuanContract.view {

    /**
     * 返回
     */
    private TextView mFanhui;
    /**
     * 发表
     */
    private TextView mFabiao;
    private EditText mEtCont;
    private ImageView mImgJia;
    private ImageView tupian;
    private GridView mGridview;
    private static final int IMG_COUNT = 8;
    private static final String IMG_ADD_TAG = "a";
    private GVAdapter adapter;
    private ImageView img;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        //Glide.with(this).load(iconUrl).into(mIv);
       // setContentView(R.layout.activity_fa_bu_duan);
        initData();
    }

    private void upLoad() {
        Bitmap bitmap;
        Bitmap bmpCompressed;
        for (int i = 0; i < list.size() - 1; i++) {
            bitmap = BitmapFactory.decodeFile(list.get(i));
            bmpCompressed = Bitmap.createScaledBitmap(bitmap, 640, 480, true);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bmpCompressed.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            byte[] data = bos.toByteArray();
            System.out.println(data);
        }

    }

    private void initData() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(IMG_ADD_TAG);
        }
        adapter = new GVAdapter();
        mGridview.setAdapter(adapter);
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).equals(IMG_ADD_TAG)) {
                    if (list.size() < IMG_COUNT) {
                        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, 0);
                    } else
                        Toast.makeText(FaBuDuanActivity.this, "最多只能选择7张照片！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        refreshAdapter();
    }

    private void refreshAdapter() {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (adapter == null) {
            adapter = new GVAdapter();
        }
        adapter.notifyDataSetChanged();
    }

    private class GVAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplication()).inflate(R.layout.activity_add_photo_gv_items, parent, false);
                holder = new ViewHolder();
                holder.imageView = (ImageView) convertView.findViewById(R.id.main_gridView_item_photo);
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.main_gridView_item_cb);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            String s = list.get(position);
            if (!s.equals(IMG_ADD_TAG)) {
                holder.checkBox.setVisibility(View.VISIBLE);
                holder.imageView.setImageBitmap(ImageTool.createImageThumbnail(s));
            } else {
                holder.checkBox.setVisibility(View.GONE);
                holder.imageView.setImageResource(R.drawable.raw_1500020546);
            }
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    refreshAdapter();
                }
            });
            return convertView;
        }

        private class ViewHolder {
            ImageView imageView;
            CheckBox checkBox;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            System.out.println("data null");
            return;
        }
        if (requestCode == 0) {
            final Uri uri = data.getData();
            String path = ImageTool.getImageAbsolutePath(this, uri);
            System.out.println(path);
            if (list.size() == IMG_COUNT) {
                removeItem();
                refreshAdapter();
                return;
            }
            removeItem();
            list.add(path);
            list.add(IMG_ADD_TAG);
            refreshAdapter();
        }
    }

    private void removeItem() {
        if (list.size() != IMG_COUNT) {
            if (list.size() != 0) {
                list.remove(list.size() - 1);
            }
        }
    }



    private void initView() {
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mFabiao = (TextView) findViewById(R.id.fabiao);
        mFabiao.setOnClickListener(this);
       mEtCont = (EditText) findViewById(R.id.et_cont);
      /*   mImgJia = (ImageView) findViewById(R.id.img_jia);
        tupian = (ImageView) findViewById(R.id.tupian);
        mImgJia.setOnClickListener(this);*/
        mGridview = (GridView) findViewById(R.id.gridview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
           // case R.id.img_jia:
                //*/调取系统的相册  Intent.ACTION_PICK相册
               /* Intent it = new Intent(Intent.ACTION_PICK);
                //设置格式
                it.setType("image*//**//**//**//*");
                startActivityForResult(it, 3000);*/


               // break;
            case R.id.fabiao:
                upLoad();
                String trim = mEtCont.getText().toString().trim();

                String uid = (String) SharedPreferencesUtils.getParam(FaBuDuanActivity.this, "uid", "-1");
                String token = (String) SharedPreferencesUtils.getParam(FaBuDuanActivity.this, "token", "");
                if ("-1".equals(uid)) {
                    Intent intent = new Intent(FaBuDuanActivity.this, LoginRerActivity.class);
                    intent.putExtra("flay", 4);
                    startActivity(intent);
                } else {
                    mPresenter.publishJoke(uid, token, trim);
                }
                break;
        }
    }

   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3000 && resultCode == RESULT_OK) {
            //得到相册图片
            Uri uri = data.getData();

            Glide.with(this).load(uri).into(tupian);

        }

    }*/

    @Override
    public int getContentLayout() {
        return R.layout.activity_fa_bu_duan;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void publishJoke(BaseBean baseBean) {
        Toast.makeText(FaBuDuanActivity.this, baseBean.getMsg(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(FaBuDuanActivity.this, DuanSuccessActivity.class);
        intent.putExtra("msg", baseBean.getMsg());
        startActivity(intent);

    }
}
