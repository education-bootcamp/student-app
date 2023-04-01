package com.icm.studentapp.controller;

import com.icm.studentapp.dto.paginated.PaginatedStudentResponseDto;
import com.icm.studentapp.dto.request.RequestStudentDto;
import com.icm.studentapp.dto.response.ResponseStudentDto;
import com.icm.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String saveStudent(@RequestBody RequestStudentDto dto) {
        studentService.saveStudent(dto);
        return "Saved!";
    }

    @GetMapping("/{id}")
    public ResponseStudentDto findStudent(@PathVariable String id) {
        return studentService.findStudent(id);
    }// localhost:8000/api/v1/4654

    @DeleteMapping(params = "id")
    public String deleteStudent(@RequestParam String id) {
        studentService.deleteStudent(id);
        return "delete student";
    }// localhost:8000/api/v1/students?id=1234

    @PutMapping(params = "id")
    public String updateStudent(@RequestBody RequestStudentDto dto, @RequestParam String id) {
        studentService.updateStudent(dto, id);
        return "update student";
    }

    @GetMapping(path = "/list", params = {"page", "size"})
    public PaginatedStudentResponseDto findAllStudents(@RequestParam int page, @RequestParam int size) {
        return studentService.findAllStudents(page, size);
    }
}
