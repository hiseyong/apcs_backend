package com.example.cafeteria.service;

import com.example.cafeteria.dto.ConsumptionDto;
import com.example.cafeteria.entity.Consumption;
import com.example.cafeteria.dto.LoginDto;
import com.example.cafeteria.dto.StudentDto;
import com.example.cafeteria.entity.Student;
import com.example.cafeteria.storage.AccountStorage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class StudentService {
    private final AccountStorage accountStorage;

    public StudentService(AccountStorage accountStorage) {
        this.accountStorage = accountStorage;
    }

    // 학생 등록
    public void registerStudent(StudentDto studentDto) {
        if (accountStorage.exists(studentDto.getStudentId())) {
            throw new IllegalArgumentException("학생 ID가 이미 존재합니다.");
        }

        Student student = new Student();
        student.setId(studentDto.getStudentId());
        student.setName(studentDto.getName());
        student.setPassword(studentDto.getPassword());
        accountStorage.addStudent(studentDto.getStudentId(), student);
    }

    // 로그인 인증
    public boolean authenticate(LoginDto loginDto) {
        Student student = accountStorage.getStudent(loginDto.getStudentId());
        return student != null && student.getPassword().equals(loginDto.getPassword());
    }

    // 학생 정보 조회
    public Student getStudent(String studentId) {
        return accountStorage.getStudent(studentId);
    }

//    소비내역 등록
    public void registerConsumption(ConsumptionDto consumptionDto) {
        System.out.println(consumptionDto.getStudentId());
        if (!accountStorage.exists(consumptionDto.getStudentId())) {
            throw new IllegalArgumentException("학생 ID가 존재지 않습니다.");
        }

        Consumption consumption = new Consumption(consumptionDto.getItemName(), consumptionDto.getPrice(), new Date());
        consumption.setStudentId(consumptionDto.getStudentId());
        consumption.setItemName(consumptionDto.getItemName());
        consumption.setPrice(consumptionDto.getPrice());
        consumption.setTimestamp(new Date());

        accountStorage.addConsumption(consumptionDto.getStudentId(), consumption);
    }
//소비 내역 조회
    public List<Consumption> getConsumptionsByStudentId(String studentId) {
        if (!accountStorage.exists(studentId)) {
            throw new IllegalArgumentException("학생 ID가 존재하지 않습니다.");
        }
        return accountStorage.getConsumptions(studentId);
    }
}