package umc.study.repository.MemberRepository;

import org.springframework.stereotype.Repository;
import umc.study.web.dto.MainPageResponseDto;
import umc.study.web.dto.MyPageRequestDto;

public interface MemberRepositoryCustom {

    MainPageResponseDto returnMainPageByMemberId(Long memberId);

    MyPageRequestDto returnMyPageByMemberId(Long memberId);
}
