package com.zero.springbootlearning.model.user;

import java.io.Serializable;

public class UserTest2 implements Serializable {

    private static final long serialVersionUID = -7610178978393267131L;

    private int id;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
