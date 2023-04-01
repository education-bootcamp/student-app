package com.icm.studentapp.controller;

import com.icm.studentapp.dto.request.RequestStudentDto;
import com.icm.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return dto.toString();
    }

    @GetMapping("/{id}")
    public String findStudent(@PathVariable String id) {
        studentService.findStudent(id);
        return "find student";
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
    public String findAllStudents(@RequestParam int page, @RequestParam int size) {
        studentService.findAllStudents(page, size);
        return "all student";
    }
}
