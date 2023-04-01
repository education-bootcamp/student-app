package com.icm.studentapp.controller;

import com.icm.studentapp.dto.request.RequestStudentDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @PostMapping
    public String saveStudent(@RequestBody RequestStudentDto dto){return dto.toString();}
    @GetMapping("/{id}")
    public String findStudent(@PathVariable String id){return "find student";}// localhost:8000/api/v1/4654
    @DeleteMapping(params = "id")
    public String deleteStudent(@RequestParam String id){return "delete student";}// localhost:8000/api/v1/students?id=1234
    @PutMapping(params = "id")
    public String updateStudent(@RequestBody RequestStudentDto dto, @RequestParam String id){return "update student";}
    @GetMapping(path = "/list", params = {"page","size"})
    public String findAllStudents(@RequestParam int page, @RequestParam int size){return "all student";}
}
