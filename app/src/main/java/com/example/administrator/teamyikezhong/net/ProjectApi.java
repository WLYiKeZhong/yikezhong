package com.example.administrator.teamyikezhong.net;

import com.example.administrator.teamyikezhong.bean.RegBean;
import com.example.administrator.teamyikezhong.bean.UpdatePassBean;
import com.example.administrator.teamyikezhong.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class ProjectApi {
    private static ProjectApi projectApi;
    private ProjectApiService projectApiService;
    private ProjectApi(ProjectApiService projectApiService) {
        this.projectApiService=projectApiService;
    }

    public static ProjectApi getProjectApi(ProjectApiService projectApiService){
        if (projectApi==null){
            projectApi=new ProjectApi(projectApiService);
        }
        return projectApi;
    }
    public Observable<UserBean> login(String mobile, String password){
        return projectApiService.login(mobile,password);
    }

    public Observable<RegBean> reg(String mobile, String password) {
        return projectApiService.reg(mobile, password);
    }

    public Observable<UpdatePassBean> getPass( String mobile, String newPass){
        return projectApiService.getPass(mobile, newPass);
    }

}
