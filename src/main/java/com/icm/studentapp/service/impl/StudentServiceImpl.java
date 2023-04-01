package com.icm.studentapp.service.impl;

import com.icm.studentapp.dto.paginated.PaginatedStudentResponseDto;
import com.icm.studentapp.dto.request.RequestStudentDto;
import com.icm.studentapp.dto.response.ResponseStudentDto;
import com.icm.studentapp.entity.Student;
import com.icm.studentapp.repo.StudentRepo;
import com.icm.studentapp.service.StudentService;
import com.icm.studentapp.util.IdManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final IdManager idManager;

    public StudentServiceImpl(StudentRepo studentRepo, IdManager idManager) {
        this.studentRepo = studentRepo;
        this.idManager = idManager;
    }

    @Override
    public void saveStudent(RequestStudentDto dto) {
        Student s= new Student(
                idManager.generate(8,"SM-S"),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        );
        studentRepo.save(s);
    }

    @Override
    public void updateStudent(RequestStudentDto dto, String id) {
        Optional<Student> selectedStudent = studentRepo.findById(id);
        if (selectedStudent.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);// 404
        }
        Student student = selectedStudent.get();
        student.setAddress(dto.getAddress());
        student.setName(dto.getName());
        student.setSalary(dto.getSalary());
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }

    @Override
    public ResponseStudentDto findStudent(String id) {
        Optional<Student> selectedStudent = studentRepo.findById(id);
        if (selectedStudent.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);// 404
        }
        return new ResponseStudentDto(
                selectedStudent.get().getStudentId(),
                selectedStudent.get().getName(),
                selectedStudent.get().getAddress(),
                selectedStudent.get().getSalary()
        );
    }

    @Override
    public PaginatedStudentResponseDto findAllStudents(int page, int size) {
        long count= studentRepo.count();
        Page<Student> all = studentRepo.findAll(PageRequest.of(page, size));
        List<ResponseStudentDto> dtos = new ArrayList<>();
        for (Student s:all
             ) {
            dtos.add(new ResponseStudentDto(
                    s.getStudentId(),
                    s.getName(),
                    s.getAddress(),
                    s.getSalary()
            ));
        }
        return new PaginatedStudentResponseDto(
                count,dtos
        );
    }

    @Override
    public PaginatedStudentResponseDto searchStudents(int page, int size, String text) {
        text="%"+text+"%";
        long count = studentRepo.getCountWithSearchText(text);
        Page<Student> all = studentRepo.findAllWithSearchText(text, PageRequest.of(page, size));
        List<ResponseStudentDto> dtos = new ArrayList<>();
        for (Student s:all
        ) {
            dtos.add(new ResponseStudentDto(
                    s.getStudentId(),
                    s.getName(),
                    s.getAddress(),
                    s.getSalary()
            ));
        }
        return new PaginatedStudentResponseDto(
                count,dtos
        );
    }
}
