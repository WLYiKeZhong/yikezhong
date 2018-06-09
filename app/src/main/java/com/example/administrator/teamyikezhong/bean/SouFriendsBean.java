package com.example.administrator.teamyikezhong.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class SouFriendsBean {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"age":null,"appkey":"7ad8b1d72903bb1a","appsecret":"5A274054B6311B5A2B0F22ECD586202E","createtime":"2018-01-16T20:27:00","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15210485030","money":null,"nickname":"123456","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"C39868E432CF76701D3BD0D3F87CFF35","uid":1394,"userId":null,"username":"15210485030"},{"age":null,"appkey":"8ec9308379cda7e2","appsecret":"6D624317A053B8A616A0186566C1B646","createtime":"2017-12-13T11:40:41","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15146274399","money":null,"nickname":"123456","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"B9FB59A97C9DA5BFE8DB62CC3D242BB4","uid":4609,"userId":null,"username":"15146274399"},{"age":null,"appkey":"aad8845d25e421c6","appsecret":"406699F45BB43197A47DDB95C7F6D2DC","createtime":"2018-05-01T23:14:22","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1524971860003newHead.jpg","latitude":null,"longitude":null,"mobile":"15812341234","money":null,"nickname":"12346887585","password":"7F14BAAF818358E25E2D9C5259AA47DD","praiseNum":null,"token":"4C5D2742A43985F6E511736A4FA04F08","uid":13158,"userId":null,"username":"15812341234"},{"age":null,"appkey":"a2a6142dfd3aa5cd","appsecret":"D238BDB06B1C948AC754F4CE575EA748","createtime":"2018-04-22T20:34:07","email":null,"fans":null,"follow":null,"gender":0,"icon":"http://thirdqq.qlogo.cn/qqapp/100424468/15537E060B11403090B3DD08859EF108/100","latitude":null,"longitude":null,"mobile":null,"money":null,"nickname":"123456","password":null,"praiseNum":null,"token":null,"uid":13924,"userId":"abc","username":null}]
     * page : 1
     */

    private String msg;
    private String code;
    private int page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : 7ad8b1d72903bb1a
         * appsecret : 5A274054B6311B5A2B0F22ECD586202E
         * createtime : 2018-01-16T20:27:00
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 15210485030
         * money : null
         * nickname : 123456
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * praiseNum : null
         * token : C39868E432CF76701D3BD0D3F87CFF35
         * uid : 1394
         * userId : null
         * username : 15210485030
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
