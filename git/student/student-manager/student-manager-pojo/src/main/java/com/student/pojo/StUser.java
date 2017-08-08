package com.student.pojo;

public class StUser {
    private Long id;

    private String username;

    private String password;

    private String isteacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIsteacher() {
        return isteacher;
    }

    public void setIsteacher(String isteacher) {
        this.isteacher = isteacher == null ? null : isteacher.trim();
    }
}