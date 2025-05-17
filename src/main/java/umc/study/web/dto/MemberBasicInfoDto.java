package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberBasicInfoDto {
    private String address;
    private Integer point;
}
