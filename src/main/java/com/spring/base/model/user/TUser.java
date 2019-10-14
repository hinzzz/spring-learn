package com.spring.base.model.user;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private Integer password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TUser{" +
        ", id=" + id +
        ", username=" + username +
        ", password=" + password +
        "}";
    }
}
