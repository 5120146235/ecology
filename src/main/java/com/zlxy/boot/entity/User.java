package com.zlxy.boot.entity;

public class User {
    private Integer id;
    private String lastName;
    private String loginid;
    private String password;
    private String pinYinLastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPinYinLastName() {
        return pinYinLastName;
    }

    public void setPinYinLastName(String pinYinLastName) {
        this.pinYinLastName = pinYinLastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", loginid='" + loginid + '\'' +
                ", password='" + password + '\'' +
                ", pinYinLastName='" + pinYinLastName + '\'' +
                '}';
    }
}
