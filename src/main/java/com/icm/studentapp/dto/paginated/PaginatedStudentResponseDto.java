package com.icm.studentapp.dto.paginated;

import com.icm.studentapp.dto.response.ResponseStudentDto;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginatedStudentResponseDto {
    private long count;
    private List<ResponseStudentDto> dataList;
}
