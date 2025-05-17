package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UncompletedMissionDto {
    private LocalDateTime deadline;
    private Integer missionReward;
    private String missionSpec;
    private String storeName;
    private String storeCategoryName;
}
