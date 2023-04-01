package com.icm.studentapp.service;

import com.icm.studentapp.dto.paginated.PaginatedStudentResponseDto;
import com.icm.studentapp.dto.request.RequestStudentDto;
import com.icm.studentapp.dto.response.ResponseStudentDto;

import java.util.List;

public interface StudentService {
    public void saveStudent(RequestStudentDto dto);
    public void updateStudent(RequestStudentDto dto, String id);
    public void deleteStudent(String id);
    public ResponseStudentDto findStudent(String id);
    public PaginatedStudentResponseDto findAllStudents(int page, int size);
    //public PaginatedStudentResponseDto searchStudents(String searchText, int page, int size);
}
