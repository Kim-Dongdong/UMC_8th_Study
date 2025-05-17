package umc.study.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.*;
import umc.study.domain.QMember;
import umc.study.domain.QMemberMission;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.QStoreCategory;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.MainPageResponseDto;
import umc.study.web.dto.MemberBasicInfoDto;
import umc.study.web.dto.MyPageRequestDto;
import umc.study.web.dto.UncompletedMissionDto;

import java.util.List;

@Repository
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    QMember member = QMember.member;
    QMemberMission memberMission = QMemberMission.memberMission;
    QMission mission = QMission.mission;
    QStore store = QStore.store;
    QStoreCategory storeCategory = QStoreCategory.storeCategory;

    @Override
    public MainPageResponseDto returnMainPageByMemberId(Long memberId) {

        // COMPLETED된 미션 수
        Long completedCount = queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MemberStatus.valueOf("COMPLETE"))
                )
                .fetchOne();

        // UNCOMPLETED된 미션 정보
        List<UncompletedMissionDto> uncompletedMissions = queryFactory
                .select(Projections.constructor(
                        UncompletedMissionDto.class,
                        mission.deadline,
                        mission.missionReward,
                        mission.mission_spec,
                        store.name,
                        storeCategory.name
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .join(store.storeCategory, storeCategory)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MemberStatus.valueOf("UNCOMPLETED"))
                )
                .fetch();

        // 기본 정보
        MemberBasicInfoDto basicInfo = queryFactory
                .select(Projections.constructor(
                        MemberBasicInfoDto.class,
                        member.address,
                        member.point
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();

        return new MainPageResponseDto(basicInfo, completedCount, uncompletedMissions);
    }

    @Override
    public MyPageRequestDto returnMyPageByMemberId(Long memberId) {
        // member.name, member.point, member.email, member.phone_num

        return queryFactory
                .select(Projections.constructor(
                        MyPageRequestDto.class,
                        member.name,
                        member.email,
                        member.point,
                        member.phoneNum
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
