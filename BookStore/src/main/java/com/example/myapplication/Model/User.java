package com.example.myapplication.Model;

public class User {
    private int userId;

    private String login;
    private String password;

    private String role;

    public User(String login, String password, String role){
        this.login=login;
        this.password=password;
        this.role=role;
    }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}
