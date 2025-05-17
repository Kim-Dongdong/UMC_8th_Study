package umc.study.service.MemberService;


import umc.study.web.dto.MainPageResponseDto;
import umc.study.web.dto.MyPageRequestDto;

public interface MemberQueryService {

    MainPageResponseDto returnMainPageResponseDto(Long memberId);

    MyPageRequestDto returnMyPageRequestDto(Long memberId);
}
