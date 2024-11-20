package com.example.cafeteria.controller;

import com.example.cafeteria.dto.ConsumptionDto;
import com.example.cafeteria.dto.LoginDto;
import com.example.cafeteria.dto.StudentDto;
import com.example.cafeteria.entity.Consumption;
import com.example.cafeteria.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 학생 등록
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDto studentDto) {
        try {
            studentService.registerStudent(studentDto);
            return ResponseEntity.ok("학생 등록 성공");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("학생 등록 실패");
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody LoginDto loginDto) {
        boolean isAuthenticated = studentService.authenticate(loginDto);
        if (isAuthenticated) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패: 잘못된 ID 또는 비밀번호");
        }
    }

//    학생의 소비 등록
    @PostMapping("/consume")
    public ResponseEntity<String> registerConsumption(@RequestBody ConsumptionDto consumptionDto) {
        try {
            studentService.registerConsumption(consumptionDto);
            return ResponseEntity.ok("소비 기록이 성공적으로 등록되었습니다.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("소비 기록 등록 중 오류가 발생했습니다.");
        }
    }

    // 학생의 모든 소비 기록 조회
    @GetMapping("/{studentId}/consumptions")
    public ResponseEntity<List<Consumption>> getConsumptions(@PathVariable String studentId) {
        try {
            List<Consumption> consumptions = studentService.getConsumptionsByStudentId(studentId);
            return ResponseEntity.ok(consumptions);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}