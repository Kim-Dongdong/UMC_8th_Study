package umc.study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.QMemberMission;
import umc.study.domain.QMission;
import umc.study.domain.Review;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

@Repository
@AllArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    QMission mission = QMission.mission;
    QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> findUncompletedMissionsByMemberId(Long memberId) {

        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.eq(MemberStatus.valueOf("COMPLETE")));

        return queryFactory
                .select(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Mission> findCompletedMissionsByMemberId(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.eq(MemberStatus.valueOf("INCOMPLETE")));

        return queryFactory
                .select(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(predicate)
                .fetch();
    }
}
