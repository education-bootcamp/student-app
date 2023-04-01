package com.icm.studentapp.service.impl;

import com.icm.studentapp.dto.paginated.PaginatedStudentResponseDto;
import com.icm.studentapp.dto.request.RequestStudentDto;
import com.icm.studentapp.dto.response.ResponseStudentDto;
import com.icm.studentapp.entity.Student;
import com.icm.studentapp.repo.StudentRepo;
import com.icm.studentapp.service.StudentService;
import com.icm.studentapp.util.IdManager;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public void deleteStudent(String id) {

    }

    @Override
    public ResponseStudentDto findStudent(String id) {
        return null;
    }

    @Override
    public PaginatedStudentResponseDto findAllStudents(int page, int size) {
        return null;
    }
}
