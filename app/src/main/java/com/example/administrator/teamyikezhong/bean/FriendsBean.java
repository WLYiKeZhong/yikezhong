package com.example.administrator.teamyikezhong.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class FriendsBean {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"b807f2a1de063bfb","appsecret":"CA6F0D9ABEF209DFA1D25AA23469EB50","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13969993828","money":null,"nickname":null,"password":"76503C729CCDAC174B5A4AB6E72CFB5A","praiseNum":null,"token":null,"uid":8217,"userId":null,"username":"13969993828"},{"age":null,"appkey":"6bfd763c1e111273","appsecret":"FE59F90A1BF85A554FDA0D8746300C62","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13984943710","money":null,"nickname":null,"password":"983C141188D3FCA704B7B80E4244790F","praiseNum":null,"token":null,"uid":8218,"userId":null,"username":"13984943710"},{"age":null,"appkey":"8e26b15fdd085a04","appsecret":"1708231A4A5936729B668B33D9402826","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13980789987","money":null,"nickname":null,"password":"69274D70A6361163629799654BCA34F7","praiseNum":null,"token":null,"uid":8219,"userId":null,"username":"13980789987"},{"age":null,"appkey":"a3c1e8ac37394561","appsecret":"2E1C284D9F0F7C331608486D4DC0F88A","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13946959913","money":null,"nickname":null,"password":"E7738644094DDC0DE1200538FCDED244","praiseNum":null,"token":null,"uid":8220,"userId":null,"username":"13946959913"},{"age":null,"appkey":"a1d6fd954520c45a","appsecret":"6CE962A360149919D60F1DA06ECC0A49","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13969629031","money":null,"nickname":null,"password":"71A29C1B5AF8D3A031FBAFE2CBA9CD4B","praiseNum":null,"token":null,"uid":8221,"userId":null,"username":"13969629031"},{"age":null,"appkey":"1ac97d3e7cb01303","appsecret":"0ECADDE576DE48BA0BAEDF525E585364","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13914590917","money":null,"nickname":null,"password":"391AE36FA8C7EE7981F1F3C522192FC3","praiseNum":null,"token":null,"uid":8222,"userId":null,"username":"13914590917"},{"age":null,"appkey":"771a2c473ae36b60","appsecret":"17C8CE95A7E77D4135F9705A967237F5","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13956453889","money":null,"nickname":null,"password":"D6DFAFDD23C85140D648129B90C3DBC2","praiseNum":null,"token":null,"uid":8223,"userId":null,"username":"13956453889"},{"age":null,"appkey":"424d5e0056f579a3","appsecret":"5AE99A6841533E16D126A165E4D40DA4","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13956337371","money":null,"nickname":null,"password":"B6B50ABEE80B2EB55AA2A26FA26C542C","praiseNum":null,"token":null,"uid":8224,"userId":null,"username":"13956337371"},{"age":null,"appkey":"860dd6718de5eaae","appsecret":"1FBDE6370FBB428D95F14EBDC9EE7AB2","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13953668095","money":null,"nickname":null,"password":"4EC3982B1F853C4ECB1A052DA3E5AC90","praiseNum":null,"token":null,"uid":8225,"userId":null,"username":"13953668095"},{"age":null,"appkey":"cfe5846db63ff4de","appsecret":"3124EE130124B0634F134CF3FF254FB9","createtime":"2017-12-23T10:55:35","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13964197294","money":null,"nickname":null,"password":"C8608D2C7D5150F9EA793702B90639A7","praiseNum":null,"token":null,"uid":8226,"userId":null,"username":"13964197294"}]
     */

    private String msg;
    private String code;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : b807f2a1de063bfb
         * appsecret : CA6F0D9ABEF209DFA1D25AA23469EB50
         * createtime : 2017-12-23T10:55:35
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 13969993828
         * money : null
         * nickname : null
         * password : 76503C729CCDAC174B5A4AB6E72CFB5A
         * praiseNum : null
         * token : null
         * uid : 8217
         * userId : null
         * username : 13969993828
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
        private Object nickname;
        private String password;
        private Object praiseNum;
        private Object token;
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

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
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

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
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
