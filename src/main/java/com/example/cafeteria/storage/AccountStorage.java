package com.example.cafeteria.storage;

import com.example.cafeteria.entity.Consumption;
import com.example.cafeteria.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccountStorage {
    private final Map<String, Student> studentMap = new HashMap<>();
    private final Map<String, List<Consumption>> consumptionMap = new HashMap<>();

    public AccountStorage() {
        // 기본 계정 등록
        Student defaultStudent = new Student("hiseyong", "password123", "Seyong");
        studentMap.put("hiseyong", defaultStudent);

        // 기본 계정 기본 소비 내역 등록
        List<Consumption> defaultConsumptions = new ArrayList<>();
        Consumption defaultConsumption = new Consumption("Coffee", 2.5, new Date());
        defaultConsumptions.add(defaultConsumption);

        consumptionMap.put("hiseyong", defaultConsumptions);
    }

    // 학생 추가
    public void addStudent(String studentId, Student student) {
        studentMap.put(studentId, student);
    }

    // 학생 조회
    public Student getStudent(String studentId) {
        return studentMap.get(studentId);
    }

    // 모든 학생 조회
    public Map<String, Student> getAllStudents() {
        return studentMap;
    }

    // 학생 삭제
    public void removeStudent(String studentId) {
        studentMap.remove(studentId);
    }

    // 학생 존재 여부 확인
    public boolean exists(String studentId) {
        return studentMap.containsKey(studentId);
    }

//    소비 기록 등록
    public void addConsumption(String studentId, Consumption consumption) {
        if (!consumptionMap.containsKey(studentId)) {
            throw new IllegalArgumentException("학생 ID가 존재하지 않습니다.");
        }
        consumptionMap.get(studentId).add(consumption);
    }

    // 소비 기록 조회
    public List<Consumption> getConsumptions(String studentId) {
        return consumptionMap.get(studentId);
    }
}