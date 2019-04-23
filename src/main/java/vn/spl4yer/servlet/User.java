package vn.spl4yer.servlet;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String fullname;
    private int age;

    public User() {
    }

    public User(String username, String fullname, int age) {
        this.username = username;
        this.fullname = fullname;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
