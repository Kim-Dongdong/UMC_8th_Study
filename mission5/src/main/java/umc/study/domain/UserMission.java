package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@Builder
@Table(name = "user_mission")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "user_id") // 외래키 이름 지정
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // 현재 엔터티 To 연관관계 엔터티 관계로 생각하자
    @JoinColumn(name = "mission_id") // 외래키 이름 지정
    private Mission mission;

    public void addUser(User user) {
        this.user = user;
        user.getUserMissionList().add(this);
    }

    public void addMission(Mission mission) {
        this.mission = mission;
        mission.getUserMissionList().add(this);
    }
}
