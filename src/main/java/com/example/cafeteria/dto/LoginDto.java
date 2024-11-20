package com.example.cafeteria.dto;

public class LoginDto {
    private String studentId;  // 로그인 시 사용하는 학생 ID
    private String password;   // 로그인 시 사용하는 비밀번호

    // 생성자들
    public LoginDto() {
    }


    public LoginDto(String studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }

    // 게터랑 세터들~
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}