package umc.study.repository.MissionRepository;

import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.Review;

import java.util.List;

public interface MissionRepositoryCustom {

    List<Mission> findCompletedMissionsByMemberId(Long memberId);

    List<Mission> findUncompletedMissionsByMemberId(Long memberId);
}
