package com.example.cafeteria.entity;

public class Student {
    private String id;
    private String password;
    private String name;

    // 생성자들
    public Student() {
    }

    public Student(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    // 게터랑 세터들~
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}