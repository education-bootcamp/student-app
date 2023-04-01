package com.icm.studentapp.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseStudentDto {
    private String studentId;
    private String name;
    private String address;
    private double salary;
}
