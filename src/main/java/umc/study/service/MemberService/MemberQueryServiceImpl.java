package umc.study.service.MemberService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.web.dto.MainPageResponseDto;
import umc.study.web.dto.MyPageRequestDto;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public MainPageResponseDto returnMainPageResponseDto(Long memberId) {
        return memberRepository.returnMainPageByMemberId(memberId);
    }

    @Override
    public MyPageRequestDto returnMyPageRequestDto(Long memberId) {
        return memberRepository.returnMyPageByMemberId(memberId);
    }
}
