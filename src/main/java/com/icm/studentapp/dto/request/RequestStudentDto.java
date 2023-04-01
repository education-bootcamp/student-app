package com.icm.studentapp.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestStudentDto {
    private String name;
    private String address;
    private double salary;
}
