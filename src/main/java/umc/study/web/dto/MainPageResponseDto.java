package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MainPageResponseDto {
    private MemberBasicInfoDto basicInfo;
    private Long completedMissionCount;
    private List<UncompletedMissionDto> uncompletedMissions;
}
