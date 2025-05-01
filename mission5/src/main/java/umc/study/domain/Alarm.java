package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "alarm")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isConfirmed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
    private List<NewMission> newMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
    private List<ReviewRequest> reviewRequestList = new ArrayList<>();

    public void addNewMission(NewMission newMission) {
        newMissionList.add(newMission);
        newMission.setAlarm(this);
    }

    public void addReviewRequest(ReviewRequest reviewRequest) {
        reviewRequestList.add(reviewRequest);
        reviewRequest.setAlarm(this);
    }
}
