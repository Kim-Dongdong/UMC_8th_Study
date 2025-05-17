package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TempTestDto{
        String testString;
        // 왜 static으로? : 범용적으로 dto를 사용하기 위해
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TempExceptionDTO {
        Integer flag;
    }
}
