package com.example.administrator.teamyikezhong.mypage.shezhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.activity.MainActivity;
import com.example.administrator.teamyikezhong.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShezhiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImg;
    /**
     * 返回
     */
    private TextView mFanhui;
    private ListView mLv;
    /**
     * 退出登录
     */
    private Button mTuilogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        initView();
        initlvview();
    }

    private void initlvview() {
        // 1创建数据
        final List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "检查更新");
        map1.put("cont","0.1.1");

        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "意见反馈");
        //map2.put("image", R.drawable.raw_1499947358);

        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "关于一刻钟");
       // map3.put("image", R.drawable.raw_1499946865);

        HashMap<String, Object> map4 = new HashMap<String, Object>();
        map4.put("name", "清除缓存");
        map4.put("cont","128MB");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        // 2创建适配器
        final SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.shezhilv_item, new String[] { "name", "cont" },
                new int[] { R.id.tv_name, R.id.tv_cont });
// 3 填充
        mLv.setAdapter(adapter);
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mFanhui = (TextView) findViewById(R.id.fanhui);
        mFanhui.setOnClickListener(this);
        mLv = (ListView) findViewById(R.id.lv);
        mTuilogin = (Button) findViewById(R.id.tuilogin);
        mTuilogin.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhui:
                finish();
                break;
            case R.id.tuilogin:
                SharedPreferencesUtils.clear(ShezhiActivity.this);
                Intent intent = new Intent(ShezhiActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
