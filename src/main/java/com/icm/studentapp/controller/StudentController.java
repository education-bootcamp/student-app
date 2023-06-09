package com.icm.studentapp.controller;

import com.icm.studentapp.dto.paginated.PaginatedStudentResponseDto;
import com.icm.studentapp.dto.request.RequestStudentDto;
import com.icm.studentapp.dto.response.ResponseStudentDto;
import com.icm.studentapp.service.StudentService;
import com.icm.studentapp.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StandardResponseEntity> saveStudent(@RequestBody RequestStudentDto dto) {
        studentService.saveStudent(dto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,
                        "Student Saved",null), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseEntity> findStudent(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponseEntity(200,
                        "Student Data",studentService.findStudent(id)), HttpStatus.OK);
    }// localhost:8000/api/v1/4654

    @DeleteMapping(params = "id")
    public ResponseEntity<StandardResponseEntity> deleteStudent(@RequestParam String id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(
                new StandardResponseEntity(204,
                        "Student Deleted",null), HttpStatus.NO_CONTENT);
    }// localhost:8000/api/v1/students?id=1234

    @PutMapping(params = "id")
    public  ResponseEntity<StandardResponseEntity> updateStudent(@RequestBody RequestStudentDto dto, @RequestParam String id) {
        studentService.updateStudent(dto, id);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,
                        "Student Updated",null), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list", params = {"page", "size"})
    public  ResponseEntity<StandardResponseEntity> findAllStudents(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(
                new StandardResponseEntity(200,
                        "Student List",studentService.findAllStudents(page, size)), HttpStatus.OK);
    }

    @GetMapping(path = "/search", params = {"page", "size","text"})
    public  ResponseEntity<StandardResponseEntity> searchStudents(@RequestParam String text, @RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(
                new StandardResponseEntity(200,
                        "Student List",studentService.searchStudents(page, size, text)), HttpStatus.OK);
    }
}
