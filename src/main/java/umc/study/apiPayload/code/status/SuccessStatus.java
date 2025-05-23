package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    // 일반적인 응답
    // 해당 줄은 enum상수 _OK를 정의하면서 생성자에게 값을 전달하는것
    // @AllArgsConstructor를 통해 자동 생성된 생성자에게 값을 넘겨 아래 필드들에게 값을 할당하는것이다!!!
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    // enum 자신의 값으로 가지고 있던 message, code, httpStatus값을
    // interface의 메소드 오버라이딩을 통해 DTO로 생성

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
