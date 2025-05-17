package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MemberStatus;

@Entity
@Getter
@Setter
@Builder
@Table(name = "member_mission")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_mission")
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "member_id") // 외래키 이름 지정
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "mission_id") // 외래키 이름 지정
    private Mission mission;

    public void addUser(Member member) {
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void addMission(Mission mission) {
        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }
}
