package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyPageRequestDto {
    private String name;
    private String email;
    private Integer point;
    private String phoneNum;
}
