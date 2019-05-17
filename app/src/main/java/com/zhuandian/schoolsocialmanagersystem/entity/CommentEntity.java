package com.zhuandian.schoolsocialmanagersystem.entity;

import cn.bmob.v3.BmobObject;

/**
 * desc :
 * author：xiedong
 * date：2019/4/22
 */
public class CommentEntity extends BmobObject {
    private String content;
    private UserEntity myuser;    //评论的用户，Pointer类型，一对一关系
    private PostEntity postEntity;    //所评论的动态，这里体现的是一对多的关系，一个评论只能属于一个动态

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getMyuser() {
        return myuser;
    }

    public void setMyuser(UserEntity myuser) {
        this.myuser = myuser;
    }

    public PostEntity getPostEntity() {
        return postEntity;
    }

    public void setPostEntity(PostEntity postEntity) {
        this.postEntity = postEntity;
    }
}
