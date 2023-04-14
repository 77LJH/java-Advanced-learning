package edu.gdut.Util;

public class User {
    String name;
    int password;

    public User() {
    }

    public User(String name, int password) {
        this.name = name;
        this.password = password;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return password
     */
    public int getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(int password) {
        this.password = password;
    }

    public String toString() {
        return "User{name = " + name + ", password = " + password + "}";
    }
}
