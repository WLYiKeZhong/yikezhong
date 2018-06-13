package com.example.administrator.teamyikezhong.mypage.zuopin.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.teamyikezhong.R;
import com.example.administrator.teamyikezhong.inter.OnItemLinter;
import com.example.administrator.teamyikezhong.mypage.zuopin.adapter.BenDiAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/10 0010.
 */

public class BenDiFragment extends Fragment {
    private View view;
    private XRecyclerView mVideosView;
    private List<String> data;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bendi_item, null);
        list = new ArrayList<>();
        data = new ArrayList<>();
       // for (int i =0;i<2;i++) {
            data.add("http://img.zcool.cn/community/010f87596f13e6a8012193a363df45.jpg@1280w_1l_2o_100sh.jpg");
            data.add("http://img03.tooopen.com/uploadfile/downs/images/20110714/sy_20110714135215645030.jpg");
      //  }
        Cursor cursor = getActivity().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Video.Media.DEFAULT_SORT_ORDER);
        try {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID)); // id
                String displayName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
                String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.ALBUM)); // 专辑
                String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.ARTIST)); // 艺术家
                String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)); // 显示名称
                String mimeType = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE));
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)); // 路径
                long duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)); // 时长
                long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE)); // 大小
                String resolution = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.RESOLUTION));

                Log.e("-----", "v_path=" + path);
                Log.e("-----", "v_album=" + album);
                Log.e("-----", "v_resolution=" + resolution);
                list.add(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        initView(view);
        return view;
    }


    private void initView(View view) {
        mVideosView = (XRecyclerView) view.findViewById(R.id.videosView);
        mVideosView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        BenDiAdapter adapter = new BenDiAdapter(getActivity(),data);
        mVideosView.setAdapter(adapter);
        adapter.onVideosItemLintenr(new OnItemLinter() {
            @Override
            public void onItemClick(int postion) {
                if (list.size()==0){
                    Toast.makeText(getActivity(),"本地中没有视频",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getActivity(), BenDiVideoActivity.class);
                    intent.putExtra("path", list.get(postion));
                    startActivity(intent);
                }
            }

            @Override
            public void onLongItemClick(int postion) {

            }
        });
    }
}
