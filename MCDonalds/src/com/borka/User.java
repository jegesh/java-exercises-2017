package com.borka;

/**
 * Created by Comp14 on 06/09/2017.
 */
public class User {
    String user;
    String password;




//    public User[] getUsers() {
//        return users;
//    }
//
//    public void setUsers(User[] users) {
//        this.users = users;
//    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public User login (String u, String p)
//    {
//
//    }
}
