package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.domain.Store;

import java.util.List;

public interface MissionQueryService {

    List<Mission> findCompletedMissionByMemberId(Long memberId);

    List<Mission> findUncompletedMissionByMemberId(Long memberId);
}
