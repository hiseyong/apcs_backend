package com.example.cafeteria.dto;

public class StudentDto {
    private String studentId;  // 학생 ID
    private String name;       // 학생 이름
    private String password;   // 학생 비밀번호

    // 생성자들
    public StudentDto() {
    }

    public StudentDto(String studentId, String name, String password) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
    }

    // 게터랑 세터들~
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}