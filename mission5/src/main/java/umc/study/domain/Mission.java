package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String title;

    @Column(nullable = false, length = 100)
    private String contents;

    private Integer missionReward;

    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY) // store은 여러 개의 mission을 가질 수 있음
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();

    public void addStore(Store store) {
        this.store = store;
        store.getMissionList().add(this);
    }
}
