package com.icm.studentapp.service.impl;

import com.icm.studentapp.dto.paginated.PaginatedStudentResponseDto;
import com.icm.studentapp.dto.request.RequestStudentDto;
import com.icm.studentapp.dto.response.ResponseStudentDto;
import com.icm.studentapp.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void saveStudent(RequestStudentDto dto) {

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
