package umc.study.service.MissionService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.service.StoreService.StoreQueryService;

import java.util.List;

@Service
@AllArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findCompletedMissionByMemberId(Long memberId) {
        List<Mission> completedMissionList = missionRepository.findCompletedMissionsByMemberId(memberId);

        completedMissionList.forEach(mission -> System.out.println("CompletedMission = " + mission));

        return completedMissionList;
    }

    @Override
    public List<Mission> findUncompletedMissionByMemberId(Long memberId) {
        List<Mission> uncompletedMissionList = missionRepository.findUncompletedMissionsByMemberId(memberId);

        uncompletedMissionList.forEach(mission -> System.out.println("UncompletedMission = " + mission));

        return uncompletedMissionList;
    }
}
