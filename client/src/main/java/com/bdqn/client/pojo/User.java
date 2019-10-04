package com.bdqn.client.pojo;

import java.io.Serializable;

/**
 * ClassName: User
 * create by:  xyf
 * description: TODO
 * create time: 2019/10/2 0002 下午 12:16
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5597052021973451168L;
    private int userId;
    private String name;

    public User() {
    }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
