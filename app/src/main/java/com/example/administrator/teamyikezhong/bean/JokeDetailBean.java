package com.example.administrator.teamyikezhong.bean;

import java.util.List;

/**
 * Created by 兰昊琼 on 2018/6/8.
 */

public class JokeDetailBean {

    /**
     * msg : 获取详情成功
     * code : 0
     * data : {"commentNum":0,"comments":[],"content":"反射光栅发光飞碟","createTime":"2018-04-27T16:14:57","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524816897229a.jpg","jid":2372,"praiseNum":0,"shareNum":null,"uid":11080,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523842330803head1.jpg","nickname":null,"praiseNum":"null"}}
     */

    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * content : 反射光栅发光飞碟
         * createTime : 2018-04-27T16:14:57
         * imgUrls : https://www.zhaoapi.cn/images/quarter/1524816897229a.jpg
         * jid : 2372
         * praiseNum : 0
         * shareNum : null
         * uid : 11080
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523842330803head1.jpg","nickname":null,"praiseNum":"null"}
         */

        private int commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private int praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1523842330803head1.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
